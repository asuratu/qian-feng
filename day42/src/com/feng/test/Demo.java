package com.feng.test;

import com.feng.test.dao.UserDao;
import com.feng.test.model.User;

/**
 * @ClassName Demo
 * @Description com.feng.test.Demo
 * @Author AsuraTu
 * @Date 2023/5/25 16:20
 * @Version 1.0.0
 */
public class Demo {
    public static void main(String[] args) {
        // 查询
        User user = UserDao.getUserById(14);
        System.out.println(user);

        // 插入
        User user1 = new User();
        user1.setPassport("feng");
        user1.setPassword("123456");
        user1.setNickname("feng");
        user1.setCreateAt(new java.util.Date());
        user1.setUpdateAt(new java.util.Date());
        user1.setBalance(100.0);
        if (UserDao.createUser(user1) > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }

        // 更新
        user.setPassport("fengfengfengfeng");
        user.setUpdateAt(new java.util.Date());
        if (UserDao.updateUser(user) > 0) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }

        // 删除
        if (UserDao.deleteUserById(2) > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }

    }
}
