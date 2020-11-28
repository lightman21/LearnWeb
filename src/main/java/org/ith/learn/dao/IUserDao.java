package org.ith.learn.dao;

import org.ith.learn.entity.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {

    List<User> findAll();
}
