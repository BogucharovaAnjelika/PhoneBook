package com.bogucharova;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class UsersPhoneTest {

    @Test
    public void test1_searchUser_printPhone() throws Exception{
        Map<String, List<String>> userPhone = new HashMap<>();
        User user2 = new User("Петров П.П.".toUpperCase());
        user2.addPhone("+8 800 2000 700");
        userPhone.put(user2.getFio(), user2.getPhones());
        String user = "петров п.п.".toUpperCase();
        String phonePrint = "";
        List<String> phones = userPhone.get(user);
        int i = 1;
        if (phones != null) {
            for (String phone : phones) {
                phonePrint = i++ + ". " + phone;
            }
        }else{
            phonePrint = "ФИО нет в БД";
        }
        String phoneResult = "1. +8 800 2000 700";
        assertEquals (phonePrint, phoneResult);

    }

    @Test
    public void test2_searchUser_rangePhone() throws Exception{
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
        String user = "сидоров с.с.".toUpperCase();
        Integer phoneSizeResult = 3;
        List<String> phones = userPhone.get(user);
        Integer phoneSize = phones.size();
        assertEquals(phoneSize, phoneSizeResult);

    }

    @Test
    public void test3_searchUser_userNotFound() throws Exception{
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
        String user = "ивано п.с.".toUpperCase();
        String error = "";
        List<String> phones = userPhone.get(user);
        //System.out.println(phones);
        int i = 1;
        if (phones != null) {
            for (String phone : phones) {
                error = i++ + ". " + phone;
            }
        }else{
            error = "ФИО нет в БД";
        }
        String errorResult = "ФИО нет в БД";
        assertEquals(error, errorResult);
    }
}