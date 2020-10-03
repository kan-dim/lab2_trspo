package com.example.demo.methods;

import com.example.demo.classes.excursion.Excursion;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class ExcursionMethods {
    public void createExcursion() {

        final String address = "http://localhost:8082/excursion/";
        RestTemplate restTempl = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("guideName", "Orange").
                queryParam("day", 5).
                queryParam("visitors", 10).
                queryParam("duration", 100).
                queryParam("month", 10);

        System.out.println("Create new Excursion");

        HttpEntity<String> response = restTempl.exchange(builder.toUriString(),
                HttpMethod.POST, null, String.class);

        System.out.println(response.getBody());

        builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("guideName", "Apple").
                queryParam("day", 7).
                queryParam("visitors", 12).
                queryParam("duration", 125).
                queryParam("month", 3);


        response = restTempl.exchange(builder.toUriString(),
                HttpMethod.POST, null, String.class);

        System.out.println(response.getBody());
    }

    public void getExcursionInfo(String name, MappingState state) {

        String address = "http://localhost:8082/excursion/";
        RestTemplate restTempl = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", name)
                .queryParam("state", state);

        HttpEntity<String> response = restTempl.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);

        System.out.println(response.getBody());
    }

    public void deleteExcursionByName(String name) {

        String address = "http://localhost:8082/excursion";
        RestTemplate restTempl = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", name);

        HttpEntity<String> response = restTempl.exchange(builder.toUriString(), HttpMethod.DELETE, null, String.class);

        System.out.println(response.getBody());
    }

}