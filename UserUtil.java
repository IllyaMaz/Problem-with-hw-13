package com.company;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UserUtil {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();


    //Task1
    public  User createUser(URI uri,User user) throws IOException, InterruptedException {
        String create = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(create))
                .header("Content-type","application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(),User.class);
    }

    //Task2 This don`t work!!!!!
    public String overwrite(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        User user = GSON.fromJson(response.body(),User.class);
        user.setUsername("Illya");
        String s = GSON.toJson(user);
        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(s))
                .build();
        HttpResponse<String> response1 = CLIENT.send(request1,HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response1.body(),String.class);
    }

    //Task 4 And this to don`t work!!!!!!!!
    public String sendGet(URI uri)   {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = null;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return GSON.fromJson(response.body(),String.class);
    }




}
