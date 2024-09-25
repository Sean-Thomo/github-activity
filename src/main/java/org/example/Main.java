package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) throws IOException {
        final String USER_AGENT = "Mozilla/5.0";
        String GET_URL = "https://api.github.com/users/";

        if (args.length > 0) {
            GET_URL += args[0] + "/events";
            URL obj = new URL(GET_URL);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = input.readLine()) != null) {
                    response.append(inputLine);
                }

                input.close();

                // Parse the JSON response
                JSONArray events = new JSONArray(response.toString());
                int pushCount = 0;
                boolean issueOpened = false;
                boolean starredRepo = false;

                for (int i = 0; i < events.length(); i++) {
                    JSONObject event = events.getJSONObject(i);
                    String type = event.getString("type");
                    JSONObject repo = event.getJSONObject("repo");
                    String repoName = repo.getString("name");

                    if (type.equals("PushEvent")) {
                        pushCount++;
                    } else if (type.equals("IssuesEvent") && event.getJSONObject("payload").getString("action").equals("opened")) {
                        issueOpened = true;
                    } else if (type.equals("WatchEvent") && event.getString("action").equals("started")) {
                        starredRepo = true;
                    }
                }

                // Display the results
                System.out.println("- Pushed " + pushCount + " commits to " + args[0] + "/developer-roadmap");
                if (issueOpened) {
                    System.out.println("- Opened a new issue in " + args[0] + "/developer-roadmap");
                }
                if (starredRepo) {
                    System.out.println("- Starred " + args[0] + "/developer-roadmap");
                }
            } else {
                System.out.println("Something went wrong while fetching data.");
            }
        } else {
            System.out.println("Please provide a GitHub username.");
        }
    }
}