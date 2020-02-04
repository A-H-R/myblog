package com.mouse.po;
/*
 *created by mouse on 2020/2/4
 */

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "m_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String avatar;
    private String username;
    private String realName;
    private String password;
    private String email;
    private Integer type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
