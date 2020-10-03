package com.example.demo.methods;

import com.example.demo.classes.people.Client;
import com.example.demo.classes.people.ClientType;
import com.example.demo.classes.people.Guide;
import com.example.demo.classes.people.Language;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class GuideMethods {
    public void createGuides() {

        final String address = "http://localhost:8082/guides/";
        RestTemplate restTempl = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", "Karas").
                queryParam("knowEnglish", true);

        System.out.println("Create new guides");

        HttpEntity<Guide> response = restTempl.exchange(builder.toUriString(),
                HttpMethod.POST, null, Guide.class);

        System.out.println(response.getBody());

        builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", "Medwed").
                queryParam("knowEnglish", true);


        response = restTempl.exchange(builder.toUriString(),
                HttpMethod.POST, null, Guide.class);

        System.out.println(response.getBody());
    }

    public void getGuidesInfo(String name, MappingState state) {

        String address = "http://localhost:8082/guides/";
        RestTemplate restTempl = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", name)
                .queryParam("state", state);

        HttpEntity<String> response = restTempl.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);

        System.out.println(response.getBody());
    }

    public void deleteGuideByName(String name) {

        String address = "http://localhost:8082/guides";
        RestTemplate restTempl = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", name);

        HttpEntity<String> response = restTempl.exchange(builder.toUriString(), HttpMethod.DELETE, null, String.class);

        System.out.println(response.getBody());
    }

    public void updateFreeStateByName(String name){
        String address = "http://localhost:8082/guides";
        RestTemplate restTempl = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", name);

        HttpEntity<Boolean> response = restTempl.exchange(builder.toUriString(), HttpMethod.PUT, null, Boolean.class);

        System.out.println(response.getBody());

    }

}