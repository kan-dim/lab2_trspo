package com.example.demo.methods;

import com.example.demo.classes.people.Manager;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class ManagerMethods {
    public void createManagers() {

        final String address = "http://localhost:8082/managers/";
        RestTemplate restTempl = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", "Igor").
                queryParam("knowEnglish", true);

        System.out.println("Create new Manager");

        HttpEntity<Manager> response = restTempl.exchange(builder.toUriString(),
                HttpMethod.POST, null, Manager.class);

        System.out.println(response.getBody());


        builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", "Misha").
                queryParam("knowEnglish", false);

        response = restTempl.exchange(builder.toUriString(),
                HttpMethod.POST, null, Manager.class);

        System.out.println(response.getBody());
    }

    public void getManagersInfo(String name, MappingState state) {

        String address = "http://localhost:8082/managers";

        RestTemplate restTempl = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address)
                .queryParam("name", name)
                .queryParam("state", state);

        HttpEntity<String> response = restTempl.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);

        System.out.println(response.getBody());
    }

    public void deleteManagerByName(String name) {

        String address = "http://localhost:8082/managers/";
        RestTemplate restTempl = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", name);

        HttpEntity<String> response = restTempl.exchange(builder.toUriString(), HttpMethod.DELETE, null, String.class);

        System.out.println(response.getBody());
    }


}