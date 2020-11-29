package org.ith.learn.dao;

import org.ith.learn.domain.AliasUser;
import org.ith.learn.domain.QueryVo;
import org.ith.learn.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {

    List<User> findAll();

    List<AliasUser> findAllByMap();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    List<User> likeUserName(String username);

    List<User> likeUserNameByUser(User user);

    List<User> likeByVo(QueryVo vo);

    void insertAndGetId(User user);

    List<AliasUser> queryAlias();
}
