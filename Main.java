package com.company;

import java.io.IOException;
import java.net.URI;

public class Main {
    private static final String URI_ONE = "https://jsonplaceholder.typicode.com/users";
    private static final String URI_TWO = "https://jsonplaceholder.typicode.com/users?id=1";

    public static void main(String[] args) throws IOException, InterruptedException {
        User user = createUser();

        UserUtil userUtil = new UserUtil();

        System.out.println(userUtil.overwrite(URI.create(URI_TWO)));


    }

    private static User createUser() {
        User user = new User();
        user.setId(20);
        user.setName("Illya Maznichenko");
        user.setUsername("Asnils");
        user.setEmail("maznichenkoo16@gmail.com");
        user.address.setStreet("Molodizhna");
        user.address.setSuite("59");
        user.address.setCity("Vilnogirsk");
        user.address.setZipcode("123");
        user.address.geo.setLat("-1234.432");
        user.address.geo.setLng("83.123.4");
        user.setPhone("+380636593406");
        user.setWebsite("NoN");
        user.company.setName("GoIt");
        user.company.setCatchPhrase("I manage to get a job");
        user.company.setBs("harness real-time e-markets");
        return user;
    }
}
