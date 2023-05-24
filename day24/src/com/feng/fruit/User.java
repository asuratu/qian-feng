package com.feng.fruit;

/**
 * @ClassName User
 * @Description com.feng.fruit.User
 * @Author AsuraTu
 * @Date 2023/5/24 14:52
 * @Version 1.0.0
 */
public class User {
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
