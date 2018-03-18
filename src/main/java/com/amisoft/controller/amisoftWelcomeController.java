package com.amisoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by amitdatta on 10/06/17.
 */

@RestController
public class amisoftWelcomeController {

    private static final String DEFAULT_ATTENDEE_SERVICE_URI = "http://localhost:8001";

    @Value(value = "${amisoft.attendee-service.uri}")
    private String baseUri;

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping(value = "/welcome", method= RequestMethod.GET)
    public ResponseEntity<String> welcomeMessage(){

        ResponseEntity<String> responseStatus = null;
        return responseStatus = ResponseEntity.status(HttpStatus.OK).body
                ("<center><h1 style=\"color:Blue;\"><b>  Welcome  to PCF Training  </center></h1></b>");
    }


    @RequestMapping(value = "/addAttendee", method= RequestMethod.GET)
    public ResponseEntity<String> addAttendee(@RequestParam(value = "firstName") String firstName){


        String urlWithEndPoint = baseUri+"/addAttendee";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlWithEndPoint).queryParam("firstName",firstName);
        String attendeeResponse =  restTemplate.getForObject(builder.toUriString(),String.class);

        ResponseEntity<String> responseStatus = null;
        return responseStatus = ResponseEntity.status(HttpStatus.OK).body
                ("<center><h1 style=\"color:Blue;\"><b>"+attendeeResponse +" </center></h1></b>");
    }


    @RequestMapping(value = "/findAllAttendee", method= RequestMethod.GET)
    public ResponseEntity<String> findAllAttendee(){


        String urlWithEndPoint = baseUri+"/findAllAttendee";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlWithEndPoint);
        String attendeeResponse =  restTemplate.getForObject(builder.toUriString(),String.class);

        ResponseEntity<String> responseStatus = null;
        return responseStatus = ResponseEntity.status(HttpStatus.OK).body
                ("<center><h1 style=\"color:Blue;\"><b> Result shown in welcome service , fetched from <i>user defined </i> attendee service </center></h1></b><br>" +attendeeResponse + "</br>");
    }

}
