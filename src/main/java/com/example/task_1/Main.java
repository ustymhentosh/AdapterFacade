package com.example.task_1;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Auth auth = new Auth();
        MessageSender ms = new MessageSender();

        User user_0 = auth.login(0);
        User user_1 = auth.login(1);

        user_0.setEmail("hello@gmail.com");
        user_1.setEmail("bye@outlook.com");

        user_0.setCountry("USA");
        user_1.setCountry("UK");

        user_0.setLastActiveTime(LocalDate.of(2025, 12, 25));
        user_1.setLastActiveTime(LocalDate.of(2020, 1, 8));

        ms.send("Hello dear user!", user_0, "USA");
        ms.send("Hello some user!", user_1, "UK");

    }
}
