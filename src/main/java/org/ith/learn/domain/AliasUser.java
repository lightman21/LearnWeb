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



展示javabean中的字段和数据库列不一致的情况

 */
public class AliasUser implements Serializable {

    private Integer dearId;
    private Date dearBirthday;
    private String dearSex;
    private String dearUsername;
    private String dearAddress;

    @Override
    public String toString() {
        return "AliasUser{" +
                "dearId=" + dearId +
                ", dearBirthday=" + dearBirthday +
                ", dearSex='" + dearSex + '\'' +
                ", dearUsername='" + dearUsername + '\'' +
                ", dearAddress='" + dearAddress + '\'' +
                '}';
    }

    public Integer getDearId() {
        return dearId;
    }

    public void setDearId(Integer dearId) {
        this.dearId = dearId;
    }

    public Date getDearBirthday() {
        return dearBirthday;
    }

    public void setDearBirthday(Date dearBirthday) {
        this.dearBirthday = dearBirthday;
    }

    public String getDearSex() {
        return dearSex;
    }

    public void setDearSex(String dearSex) {
        this.dearSex = dearSex;
    }

    public String getDearUsername() {
        return dearUsername;
    }

    public void setDearUsername(String dearUsername) {
        this.dearUsername = dearUsername;
    }

    public String getDearAddress() {
        return dearAddress;
    }

    public void setDearAddress(String dearAddress) {
        this.dearAddress = dearAddress;
    }
}
