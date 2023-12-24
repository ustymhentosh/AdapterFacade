package com.example.task_3;

public class Main {
    public static void main(String[] args) throws Exception {
        Company myCompany = new Company();
        myCompany.fillWithDataFromDomain("youtube.com");
        System.out.println(myCompany.getName());
        System.out.println(myCompany.getDescription());
        System.out.println(myCompany.getLogo());
    }
}
