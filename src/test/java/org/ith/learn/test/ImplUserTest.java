package org.ith.learn.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.ith.learn.dao.IUserDao;
import org.ith.learn.dao.impl.IUserDaoImpl;
import org.ith.learn.domain.AliasUser;
import org.ith.learn.domain.QueryVo;
import org.ith.learn.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ImplUserTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao iUserDao;
    SqlSessionFactory factory;

    @Before
    public void onCreate() throws Exception {
        // 1 读取配置
        in = Resources.getResourceAsStream("sqlmapconfig.xml");
        // 2创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        // 3使用工厂生成sqlsession对象
        sqlSession = factory.openSession();
        // 4使用SqlSession创建Dao接口的代理对象
        iUserDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void onDestroy() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() throws Exception {
        IUserDao dao = new IUserDaoImpl(factory);
        List<User> users = dao.findAll();
        users.forEach(System.out::println);
    }


    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setUsername("Java by DaoImpl");
        user.setSex("男");
        user.setAddress("Canada");
        user.setBirthday(new Date());
        IUserDao dao = new IUserDaoImpl(factory);
        dao.saveUser(user);
    }

    @Test
    public void testInsertAndGetId() throws Exception {
        User user = new User();
        user.setUsername("Python");
        user.setSex("男");
        user.setAddress("UK");
        user.setBirthday(new Date());

        System.out.println(user);

        iUserDao.insertAndGetId(user);

        System.out.println(user);
    }

    @Test
    public void testUpdate() throws Exception {
        User user = new User();
        user.setId(1);
        user.setUsername("mybatis");
        user.setSex("男");
        user.setAddress("NewYork");
        user.setBirthday(new Date());
        iUserDao.updateUser(user);
    }

    @Test
    public void testDelete() throws Exception {
        User user = new User();
        user.setId(2);
        iUserDao.deleteUser(user);
    }

    @Test
    public void testLike() throws Exception {
        List<User> users = iUserDao.likeUserName("%小%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testLikeByUser() throws Exception {
        User buser = new User();
        buser.setUsername("小");
        List<User> users = iUserDao.likeUserNameByUser(buser);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testLikeByVo() throws Exception {
        QueryVo vo = new QueryVo();
        User buser = new User();
        buser.setUsername("小");
        vo.setUser(buser);
        List<User> users = iUserDao.likeByVo(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryAlias() throws Exception {
        List<AliasUser> users = iUserDao.queryAlias();
        for (AliasUser user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindAllByMap() throws Exception {
        List<AliasUser> users = iUserDao.findAllByMap();
        for (AliasUser user : users) {
            System.out.println(user);
        }
    }


}
