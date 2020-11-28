package org.ith.learn.org.ith.another;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BiliTool {

    private static List<File> fileList = new ArrayList<File>();
    private static String filePath = "/Users/lightman_mac/Movies/285707752";
    private static final String OUTPATH = "/tmp/mybatis/mybatis";

    public static void main(String[] args) {
        doWork();
    }

    private static void doWork() {
        listTheFile(new File(filePath));
        Map<String, String> values = fillMaps();
        File outFile = new File(OUTPATH);
        if (!outFile.exists()) {
            outFile.mkdirs();
        }

        ExecutorService service = Executors.newCachedThreadPool();
        CountDownLatch downLatch = new CountDownLatch(1);

        for (final String key : values.keySet()) {
            final String value = values.get(key);
            service.execute(new Runnable() {
                public void run() {
                    exec(key,value);
                }
            });
        }

        downLatch.countDown();

        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.shutdownNow();

        System.out.println("Done-------------doWork");
    }

    private static Map<String, String> fillMaps() {
        List<String> videos = new ArrayList<String>();
        List<String> audios = new ArrayList<String>();
        Map<String, String> values = new HashMap<String,String>();
        for (File file : fileList) {
            String path = file.getPath();
            if (path.contains("video")) {
                videos.add(path);
            }
            if (path.contains("audio")) {
                audios.add(path);
            }
        }

        for (int i = 0; i < videos.size(); i++) {
            String video = videos.get(i);
            String vsub = video.split("/video.m4s")[0];
            for (int j = 0; j < audios.size(); j++) {
                String audio = audios.get(i);
                String asub = audio.split("/audio.m4s")[0];

                if (vsub.equals(asub)) {
                    values.put(video, audio);
                }
            }
        }
        return values;
    }

    private static void exec(String video, String audio) {

        Process process = null;

        try {

            String sp = filePath.substring(filePath.lastIndexOf("/") + 1);
            String out = video.split(sp)[1].split("/")[1];

            String sb = "ffmpeg -i " + video + " -i " + audio +
                    " -c:v copy -strict experimental " +
                    OUTPATH + out + ".mp4";

            String[] cmd = {"/bin/sh", "-c", sb};
            process = Runtime.getRuntime().exec(cmd);


            BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();

            System.out.println("done " + OUTPATH + out + ".mp4");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }

    private static void listTheFile(File src) {
        if (src != null) {
            if (src.isDirectory()) {
                File[] files = src.listFiles();
                for (File file : files) {
                    listTheFile(file);
                }
            } else {
                if (src.isFile() && src.getName().contains("m4s")) {
                    fileList.add(src);
                }
            }
        }
    }
}
