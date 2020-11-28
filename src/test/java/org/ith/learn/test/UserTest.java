package org.ith.learn.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.ith.learn.dao.IUserDao;
import org.ith.learn.entity.User;

import java.io.InputStream;
import java.util.List;

public class UserTest {

    public static void main(String[] args) throws Exception{
        // 1 读取配置
        InputStream in = Resources.getResourceAsStream("sqlmapconfig.xml");

        // 2创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3使用工厂生成sqlsession对象
        SqlSession sqlSession = factory.openSession();
        // 4使用SqlSession创建Dao接口的代理对象
        IUserDao dao = sqlSession.getMapper(IUserDao.class);
        // 5使用代理对象执行方法
        List<User> users = dao.findAll();

        for(User user : users){
            System.out.println(user);
        }
        // 6释放资源
        sqlSession.close();
        in.close();
    }
}
