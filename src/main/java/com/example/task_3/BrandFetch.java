package com.example.task_3;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class BrandFetch {
    public static String getLogo(String domain) throws IOException, InterruptedException {
        String apiKey = ConfigReader.getApiKey(ServiceName.BRAND_FETETCH);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.brandfetch.io/v2/brands/" + domain))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject jsonResponse = new JSONObject(response.body());
        String logo = jsonResponse.getJSONArray("logos")
                .getJSONObject(0)
                .getJSONArray("formats")
                .getJSONObject(0)
                .getString("src");
        return logo;
    }
}
