package com.bogucharova;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersPhone {
    public static void main(String[] args) {

        try {
            Map<String, List<String>> userPhone = new HashMap<>();

            User user1 = new User("Иванов И.И.".toUpperCase());
            User user2 = new User("Петров П.П.".toUpperCase());
            User user3 = new User("Сидоров С.С.".toUpperCase());

            user1.addPhone("+8 800 2000 500");
            user1.addPhone("+8 800 200 600");
            user2.addPhone("+8 800 2000 700");
            user3.addPhone("+8 800 2000 800");
            user3.addPhone("+8 800 2000 900");
            user3.addPhone("+8 800 2000 000");

            userPhone.put(user1.getFio(), user1.getPhones());
            userPhone.put(user2.getFio(), user2.getPhones());
            userPhone.put(user3.getFio(), user3.getPhones());

            System.out.println("Введите ФИО:");
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            String user;
            user = read.readLine().toUpperCase();

            List<String> phones = userPhone.get(user);
            printPhones(phones);

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    private static void printPhones(List<String> phones) {
        if (phones != null) {
            int i = 1;
            for (String phone : phones) {
                System.out.println(i++ + ". " + phone);
            }
        } else {
            System.out.println("ФИО нет в БД");
        }
    }
}
