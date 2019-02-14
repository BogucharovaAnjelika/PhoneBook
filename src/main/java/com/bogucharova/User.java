package com.bogucharova;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String fio;
    private List<String> phones = new ArrayList<>();

    public User(String fio) {
        this.fio = fio;
    }

    public void addPhone(String phone) {
        phones.add(phone);
    }

    public void printPhones() {
        int i = 1;
        for (String phone : phones) {
            System.out.println(i++ + ". " + phone);
        }
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}
