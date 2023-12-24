package com.example.task_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class AbstractReader {

    public static String getName(String domain) throws FileNotFoundException {
        String apiKey = ConfigReader.getApiKey(ServiceName.ABSTRACT_READER);

        try {
            String urlString = "https://companyenrichment.abstractapi.com/v1/?api_key=" + apiKey + "&domain=" + domain;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            connection.disconnect();

            return jsonObject.getString("name");

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
