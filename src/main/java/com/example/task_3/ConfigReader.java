package com.example.task_3;

import java.io.BufferedReader;
import java.io.FileReader;

public class ConfigReader {
    public static String getApiKey(ServiceName whicSercvice) {
        String file = "./demo/config.csv";
        String line;
        try (
                BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                if (line.startsWith(whicSercvice.toString())) {
                    return line.split(",")[1];
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
