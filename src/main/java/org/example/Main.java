package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

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

                System.out.println(response.toString());
            } else {
                System.out.println("Something went wrong while fetching data.");
            }
        }
    }
}