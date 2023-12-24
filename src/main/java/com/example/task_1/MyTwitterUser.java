package com.example.task_1;

import java.time.LocalDate;



public class MyTwitterUser implements User {

    public TwitterUser twitterUser;
    
    public void setEmail(String email){
        twitterUser.setUserMail(email);
    }

    public void setCountry(String country){
        twitterUser.setCountry(country);
    }

    public void setLastActiveTime(LocalDate lastTime){
        twitterUser.setLastActiveTime(lastTime);
    }

    public MyTwitterUser(TwitterUser twitterUser) {
        this.twitterUser = twitterUser;
    }

    @Override
    public String getEmail() {
        return twitterUser.getUserMail();
    }

    @Override
    public String getCountry() {
        return twitterUser.getCountry();
    }

    @Override
    public LocalDate getLastActiveTime() {
        return twitterUser.getLastActiveTime();
    }

}
