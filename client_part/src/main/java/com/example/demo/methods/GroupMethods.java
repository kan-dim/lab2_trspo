package com.example.demo.methods;

import com.example.demo.classes.excursion.Excursion;
import com.example.demo.classes.people.Guide;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.swing.*;

public class GroupMethods {
    public void createGroup() {

        final String address = "http://localhost:8082/groups/";
        RestTemplate restTempl = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("day", 11).
                queryParam("clientsList", "VLAD").
                queryParam("managerName", "Persik").
                queryParam("month", 12);

        System.out.println("Create new groups");

        HttpEntity<String> response = restTempl.exchange(builder.toUriString(),
                HttpMethod.POST, null, String.class);

        System.out.println(response.getBody());
    }

    public void getGroupInfo(int day, int month, MappingState state) {

        String address = "http://localhost:8082/groups/";
        RestTemplate restTempl = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("month", day).
                queryParam("day", month).
                queryParam("state", state);

        HttpEntity<String> response = restTempl.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);

        System.out.println(response.getBody());
    }

    public void deleteGroupByDate(int day, int month) {

        String address = "http://localhost:8082/groups";
        RestTemplate restTempl = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("month", day).
                queryParam("day", month);

        HttpEntity<String> response = restTempl.exchange(builder.toUriString(), HttpMethod.DELETE, null, String.class);

        System.out.println(response.getBody());
    }

}