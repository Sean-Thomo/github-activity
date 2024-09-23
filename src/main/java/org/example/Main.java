package org.example;

import java.io.IOException;
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
            System.out.println("URL: " + GET_URL);
            System.out.println("Response Code: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner input = new Scanner(connection.getInputStream());
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = input.next()) != null) {
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