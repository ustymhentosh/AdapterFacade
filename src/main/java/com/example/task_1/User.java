package com.example.task_1;

import java.time.LocalDate;

public interface User {
    public String getEmail();

    public String getCountry();

    public LocalDate getLastActiveTime();

    public void setEmail(String email);

    public void setCountry(String country);

    public void setLastActiveTime(LocalDate lastTime);
}
