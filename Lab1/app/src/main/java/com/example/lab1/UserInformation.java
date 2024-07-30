package com.example.lab1;

import java.util.ArrayList;

public class UserInformation {
    private static ArrayList<User> users = new ArrayList<>();
    static {
        khoiTaoUser();
    }
    private static void khoiTaoUser() {
        users = new ArrayList<>();
        users.add(new User("kan", "1128", ""));
        users.add(new User("user2", "password2", ""));
        users.add(new User("user3", "password3", ""));
    }
    public static void themUser(User user) {
        users.add(user);
    }
    public static boolean tontaiUser(String tenNguoiDung) {
        for (User user : users) {
            if (user.getUsername().equals(tenNguoiDung)) {
                return true;
            }
        }
        return false;
    }

    public static User tenUser(String tenNguoiDung) {
        for (User user : users) {
            if (user.getUsername().equals(tenNguoiDung)) {
                return user;
            }
        }
        return null;
    }
}
