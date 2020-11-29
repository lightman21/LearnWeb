package org.ith.learn.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.ith.learn.dao.IUserDao;
import org.ith.learn.domain.AliasUser;
import org.ith.learn.domain.QueryVo;
import org.ith.learn.domain.User;

import java.util.List;

public class IUserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;

    public IUserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("org.ith.learn.dao.IUserDao.findAll");
        session.close();
        return users;
    }

    public List<AliasUser> findAllByMap() {
        return null;
    }

    public void saveUser(User user) {
        SqlSession session = factory.openSession();
        session.insert("org.ith.learn.dao.IUserDao.saveUser",user);
        session.commit();
        session.close();
    }

    public void updateUser(User user) {

    }

    public void deleteUser(User user) {

    }

    public List<User> likeUserName(String username) {
        return null;
    }

    public List<User> likeUserNameByUser(User user) {
        return null;
    }

    public List<User> likeByVo(QueryVo vo) {
        return null;
    }

    public void insertAndGetId(User user) {

    }

    public List<AliasUser> queryAlias() {
        return null;
    }
}
