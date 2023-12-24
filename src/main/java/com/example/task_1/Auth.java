package com.example.task_1;

public class Auth {
    public User login(int n){
        if (n > 0){
            return new MyFacebookUser(new FacebookUser());
        } else {
            return new MyTwitterUser(new TwitterUser());
        }
    }
}
