package com.example.task_3;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;

import org.json.JSONObject;

public class OpenAiReader {

    public static String getDescription(String url) throws Exception {
        String apiKey = ConfigReader.getApiKey(ServiceName.OPEN_AI_READER);
        String apiUrl = "https://api.openai.com/v1/chat/completions";

        String questionForDesc = "Return me a description of a website with this url: " + url +
                " I only need a description and nothing other, no 'please' or 'here you are' words ," +
                "please return only description because I will be reading this wis some programming language.";

        String getDescription = createJsonRequest(questionForDesc);

        HttpRequest requestDesc = createHttpRequest(apiUrl, apiKey, getDescription);

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> responseDesc = client.send(requestDesc, HttpResponse.BodyHandlers.ofString());

        String desc = extractContent(responseDesc);

        return desc;
    }

    private static String createJsonRequest(String question) {
        return "{\n" +
                "    \"model\": \"gpt-3.5-turbo\",\n" +
                "    \"messages\": [\n" +
                "      {\n" +
                "        \"role\": \"system\",\n" +
                "        \"content\": \"You are a helpful assistant.\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"role\": \"user\",\n" +
                "        \"content\": \"" + question + "\"\n" +
                "      }\n" +
                "    ]\n" +
                "}";
    }

    private static HttpRequest createHttpRequest(String apiUrl, String apiKey, String jsonBody)
            throws URISyntaxException {
        return HttpRequest.newBuilder()
                .uri(new URI(apiUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(BodyPublishers.ofString(jsonBody))
                .build();
    }

    private static String extractContent(HttpResponse<String> response) {
        JSONObject jsonResponse = new JSONObject(response.body());
        return jsonResponse.getJSONArray("choices")
                .getJSONObject(0)
                .getJSONObject("message")
                .getString("content");
    }
}
