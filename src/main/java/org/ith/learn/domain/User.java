package org.ith.learn.domain;

import java.io.Serializable;
import java.util.Date;

/**


 DROP TABLE IF EXISTS user;

 CREATE TABLE user (
 id int(11) NOT NULL auto_increment,
 username varchar(32) NOT NULL COMMENT '用户名',
 birthday datetime default NULL COMMENT '生日',
 sex char(1) default NULL COMMENT '性别',
 address varchar(256) default NULL COMMENT '地址',
 PRIMARY KEY (id)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;


 insert into user(username,birthday,sex,address) values ('刘小备','2004-06-08','男','承德市');
 insert into user(username,birthday,sex,address) values ('关大羽','2003-12-23','男','德阳市');
 insert into user(username,birthday,sex,address) values ('张老飞','2001-05-07','男','广州市');
 insert into user(username,birthday,sex,address) values ('嫦小娥','1991-03-04','女','北京市');
 insert into user(username,birthday,sex,address) values ('昭小君','1994-11-29','女','上海市');





 */
public class User implements Serializable {

    private Integer id;
    private Date birthday;
    private String sex;
    private String username;
    private String address;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
