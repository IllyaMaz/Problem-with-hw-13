package com.company;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class UserUtil {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();
    private static final String PATH_FILE = "D:\\hw-13.1.1\\CommentsForPost.txt";


    //Task1 Create Object
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

    //Task2 Overwrite Object
    public User overwrite(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        User user = GSON.fromJson(response.body(),User.class);

        user.setUsername("Illya");
        String s = GSON.toJson(user);//user not work for POST , user.get(0) work for POST and dont work for Put again

        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(s))
                .header("Content-type","application/json; charset=UTF-8")
                .build();
        HttpResponse<String> response1 = CLIENT.send(request1,HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(response1.body(),User.class);
    }

    //Task3 Delete Object
    public void delete(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        User user = GSON.fromJson(response.body(),User.class);
        String s = user.toString();
        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(uri)
                .method("DELETE",HttpRequest.BodyPublishers.ofString(s))
                .build();
        HttpResponse<String> response1 = CLIENT.send(request1,HttpResponse.BodyHandlers.ofString());
    }

    //Task4 GET All Objects
    public List<User> sendGet(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(response.body(),new TypeToken<List<User>>(){}.getType());
    }

    //Task5 GET Object by Id
    public User getById(URI uri,int id) throws IOException, InterruptedException {
        String s = String.format(uri + "/%d",id);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(s))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(),User.class);
    }

    //Task6 GET Object by userName
    public User getByUserName(URI uri,String userName) throws IOException, InterruptedException {
        String s = String.format(uri+"?username=%s",userName);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(s))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        List<User> list = new ArrayList<>();
        list=GSON.fromJson(response.body(),new TypeToken<List<User>>(){}.getType());
        return list.get(0);
    }

    //Task7 Coment to post users
    public String writeComent(URI uri,int id) throws IOException, InterruptedException {
        String uriUser = String.format(uri+"/users/%d/posts",id);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uriUser))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());

        List<Posts> q = GSON.fromJson(response.body(),new TypeToken<List<Posts>>(){}.getType());

        Posts maxPosts = new Posts();
        for (Posts p : q) {
            if (p.id > maxPosts.id){
                maxPosts=p;
            }
        }

        String uriPosts = String.format(uri + "/posts/"+maxPosts.id+"/comments");
        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(URI.create(uriPosts))
                .GET()
                .build();
        HttpResponse<String> response1 = CLIENT.send(request1,HttpResponse.BodyHandlers.ofString());

        File file = new File(PATH_FILE);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
                writer.write(response1.body());
        } catch (IOException exception){
            System.err.println(exception.getMessage());
        }

        return response1.body();
    }

    //Task8
    public List<Todos> getAvailableTasks(URI uri,int userId) throws IOException, InterruptedException {
        String s = String.format(uri + "/users/%d/todos?completed=false",userId);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(s))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(),new TypeToken<List<Todos>>(){}.getType());
    }






}
