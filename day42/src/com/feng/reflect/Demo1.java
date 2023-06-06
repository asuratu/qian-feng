package com.feng.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName Demo1
 * @Description com.feng.reflect.Demo1
 * @Author AsuraTu
 * @Date 2023/5/29 11:17
 * @Version 1.0.0
 */
public class Demo1 {
    public static void main(String[] args) {
        // 反射 是在运行时动态获取类的信息
        // 程序在运行的过程中, 拿到类的字节码文件, 进而获得类中的属性和方法
        // 通过反射可以获取类的属性(包括私有属性)和方法(包括私有方法), 并且可以对其进行操作

        // 1. 获取类的字节码文件
        getClassFile();

        System.out.println("====================================");

        // 2. 获取类的属性
        getClassField();

        System.out.println("====================================");

        // 3. 获取类的方法
        getClassMethod();

        System.out.println("====================================");

        // 4. 获取类的构造方法
        getClassConstructor();
    }

    private static void getClassConstructor() {
        // 4.1 获取类的所有构造方法, 执行构造方法创建对象
        Class<User> userClass = User.class;

        // Constructor<?>[] getConstructors() 获取类的所有公有构造方法
        // Constructor<?>[] getDeclaredConstructors() 获取类的所有构造方法
        // Constructor<T> getConstructor(Class<?>... parameterTypes) 获取类的指定公有构造方法
        // Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) 获取类的指定构造方法

        // 4.2 获取类的所有公有构造方法
        try {
            Constructor<?>[] constructors = userClass.getConstructors();
            System.out.println("获取类的所有公有构造方法 getConstructors(): " + Arrays.toString(constructors));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 4.3 获取类的所有构造方法
        try {
            Constructor<?>[] declaredConstructors = userClass.getDeclaredConstructors();
            System.out.println("获取类的所有构造方法 getDeclaredConstructors(): " + Arrays.toString(declaredConstructors));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 4.4 获取类的指定公有构造方法
        try {
            Constructor<User> constructor = userClass.getConstructor();
            System.out.println("获取类的指定公有构造方法 getConstructor(Class<?>... parameterTypes): " + constructor);

            // 通过构造方法创建对象
            User user = constructor.newInstance();
            System.out.println("通过构造方法创建对象: " + user);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 4.5 获取类的指定构造方法
        try {
            Constructor<User> declaredConstructor = userClass.getDeclaredConstructor();
            System.out.println("获取类的指定构造方法 getDeclaredConstructor(Class<?>... parameterTypes): " + declaredConstructor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 1. 获取类的方法
    private static void getClassMethod() {
        // 1.1 获取类的所有方法
        Class<User> userClass = User.class;

        // Method[] getMethods() 获取类的所有公有方法
        // Method[] getDeclaredMethods() 获取类的所有方法
        // Method getMethod(String name, Class<?>... parameterTypes) 获取类的指定公有方法
        // Method getDeclaredMethod(String name, Class<?>... parameterTypes) 获取类的指定方法

        // 1.2 获取类的所有公有方法
        Method[] methods = userClass.getMethods();
        System.out.println("获取类的所有公有方法 getMethods(): " + Arrays.toString(methods));

        // 1.3 获取类的所有方法
        Method[] declaredMethods = userClass.getDeclaredMethods();
        System.out.println("获取类的所有方法 getDeclaredMethods(): " + Arrays.toString(declaredMethods));

        // 1.4 获取类的指定公有方法
        Method method1 = null;
        try {
            method1 = userClass.getMethod("setPassport", String.class);
            System.out.println("获取类的指定公有方法 getMethod(String name, Class<?>... parameterTypes): " + method1);

            // 1.4.1 可以获得关于方法的所有信息
            // 方法名
            System.out.println("方法名: " + method1.getName());
            // 返回值类型
            System.out.println("返回值类型: " + method1.getReturnType());
            // 参数列表
            System.out.println("参数列表: " + Arrays.toString(method1.getParameterTypes()));
            // 修饰符列表
            System.out.println("修饰符列表: " + method1.getModifiers());
            // 操作方法, 执行方法
            User user = new User();
            method1.invoke(user, "123456");
            System.out.println("操作方法, 执行方法: " + user);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 1.5 获取类的指定方法
        try {
            Method method = userClass.getDeclaredMethod("setPassword", String.class);
            System.out.println("获取类的指定方法 getDeclaredMethod(String name, Class<?>... parameterTypes): " + method);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    // 2. 获取类的属性
    private static void getClassField() {
        // 2.1 获取类的所有属性
        Class<User> userClass = User.class;

        // Field[] getFields() 获取类的所有公有属性 (只能获取公有属性)
        Field[] fields = userClass.getFields();
        System.out.println("获取类的所有公有属性 getFields(): " + Arrays.toString(fields));

        // Field[] getDeclaredFields() 获取类的所有属性 (任意权限)
        Field[] declaredFields = userClass.getDeclaredFields();
        System.out.println("获取类的所有属性 getDeclaredFields(): " + Arrays.toString(declaredFields));

        // Field getField(String name) 获取类的指定公有属性 (只能获取公有属性)
        Field passport = null;
        try {
            passport = userClass.getField("passport");
            System.out.println("获取类的指定公有属性 getField(String name): " + passport);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        // Field getDeclaredField(String name) 获取类的指定属性 (任意权限)
        Field nickname = null;
        try {
            nickname = userClass.getDeclaredField("nickname");
            System.out.println("获取类的指定属性 getDeclaredField(String name): " + passport);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        // q: 通过反射获得属性有什么用?
        // a: 通过反射可以获取类的属性(包括私有属性)和方法(包括私有方法), 并且可以对其进行操作

        // q: JavaBean类的默认权限修饰符是什么?
        // a: 默认是包权限 protected, 只能在同一个包下访问

        // 获得属性的值
        if (nickname != null) {
            // getName() 获取属性的名称
            String fieldName = nickname.getName();
            System.out.println("属性的名称: " + fieldName);

            // getGenericType() 获取属性的类型
            Class<?> fieldType = nickname.getType();
            System.out.println("属性的类型: " + fieldType);

            // getModifiers() 获取属性的修饰符
            int fieldModifiers = nickname.getModifiers(); // 修饰符的值, 用数字表示, 1: public, 2: private, 4: protected
            System.out.println("属性的修饰符: " + fieldModifiers);

            // get(Object obj) 获取属性的值
            // 如果是私有属性, 需要设置可访问性为true
            nickname.setAccessible(true);
            User user = new User();
            user.setNickname("feng");
            try {
                Object fieldValue = nickname.get(user);
                System.out.println("属性的值: " + fieldValue);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            // set(Object obj, Object value) 设置属性的值
            try {
                nickname.set(user, "fengfengfeng");
                System.out.println("属性的值: " + user.getNickname());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            // setAccessible(boolean flag) 设置属性的可访问性
            // 如果是私有属性, 需要设置可访问性为true
        }

    }

    // 1. 获取类的字节码文件 Bytecode File
    public static void getClassFile() {
        // 1.1 通过类名.class 类型的静态属性
        Class<User> userClass = User.class;

        // 1.2 通过对象.getClass()
        User user = new User();
        Class<? extends User> userClass1 = user.getClass();

        // 1.3 通过Class.forName("类的全限定名")
        try {
            Class<?> userClass2 = Class.forName("com.feng.reflect.User");
            System.out.println(userClass2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
