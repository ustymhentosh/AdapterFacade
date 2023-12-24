package com.example.task_2;

public class Main {
    public static void main(String[] args) {
        DataBase db = new DataBase();
        Authorization auth = new Authorization();
        if (auth.login(db)) {
            ReportBuilder br = new ReportBuilder(db);
        }
    }
}
