package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> mailList = new HashMap<>();
        mailList.put("mail1@mail.ru","Иванов Иван Иванович");
        mailList.put("mail2@mail.ru","Иванов Иван Степанович");
        mailList.put("mail1@mail.ru","Иванов Иван Иванович");
        for (String key: mailList.keySet()) {
            String value = mailList.get(key);
            System.out.println(key + " >>>> "+ value);
        }
    }
}
