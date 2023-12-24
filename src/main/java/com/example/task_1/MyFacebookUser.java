package com.example.task_1;

import java.time.LocalDate;


public class MyFacebookUser implements User {
    private FacebookUser facebookUser;

    public MyFacebookUser(FacebookUser facebookUser) {
        this.facebookUser = facebookUser;
    }

    @Override
    public void setEmail(String email) {
        facebookUser.setEmail(email);
    }

    @Override
    public void setCountry(String country) {
        facebookUser.setUserCountry(country);
    }

    @Override
    public void setLastActiveTime(LocalDate lastTime) {
        facebookUser.setUserActiveTime(lastTime);
    }

    @Override
    public String getEmail() {
        return facebookUser.getEmail();
    }

    @Override
    public String getCountry() {
        return facebookUser.getUserCountry();
    }

    @Override
    public LocalDate getLastActiveTime() {
        return facebookUser.getUserActiveTime();
    }

}
