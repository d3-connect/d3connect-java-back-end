package io.d3connect.d3connect.controller;

// MailGun Imports
import java.io.File;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class MailGunController {

    final static  String API_KEY = "943b60448c306b56336482f4e96c5d89-bbbc8336-70f55bfd";
    final static  String DOMAIN_NAME = "mg.dnohomework.com";

    @PostMapping("email/send")
    public static JsonNode sendSimpleMessage() throws UnirestException {
        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" +  DOMAIN_NAME + "/messages")
                .basicAuth("api", API_KEY)
                .field("from", "From Java Class MailGun User <nikho@nikho.com>")
                .field("to", "derek.noblej@gmail.com")
                .field("subject", "hello")
                .field("text", "testing")
                .asJson();
        System.out.println(request);
        System.out.println(request.getBody());
        return request.getBody();
    }
}
