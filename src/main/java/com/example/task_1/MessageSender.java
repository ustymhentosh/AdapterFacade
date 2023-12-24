package com.example.task_1;

import java.time.LocalDate;

public class MessageSender {
    public void send(String text, User user, String country) {
        if (user.getLastActiveTime().isAfter(LocalDate.now())) {
            System.out.println("STATUS: SENT --> " + "Sent to the " + user.getEmail() + ".");
        } else {
            System.out.println("STATUS: NOT_SENT --> " + "User " + user.getEmail() + "will not be active.");
        }
    }
}
