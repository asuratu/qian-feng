package com.feng.reflect;

import java.util.Date;

/**
 * @ClassName User
 * @Description com.feng.orm.model.User
 * @Author AsuraTu
 * @Date 2023/5/25 14:20
 * @Version 1.0.0
 */
public class User {
    public String passport; // 默认权限是包权限 protected, 只能在同一个包下访问

    // protected 权限, 只能在同一个包下访问, 或者是子类中访问
    // private 权限, 只能在本类中访问
    // public 权限, 可以在任意位置访问
    private String nickname;

    private Integer id;
    private String password;
    private Date createAt;
    private Date updateAt;
    private Double balance;

    // 无参构造
    public User() {
    }

    // 有参构造
    public User(Integer id, String passport, String password, String nickname, Date createAt, Date updateAt, Double balance) {
        this.id = id;
        this.passport = passport;
        this.password = password;
        this.nickname = nickname;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    // 重写 toString 方法
    @Override
    public String toString() {
        return "User{" +
                "id=" + id + ", " +
                "passport='" + passport + '\'' + ", " +
                "password='" + password + '\'' + ", " +
                "nickname='" + nickname + '\'' + ", " +
                "createAt=" + createAt + ", " +
                "updateAt=" + updateAt + ", " +
                "balance=" + balance +
                '}';
    }
}
