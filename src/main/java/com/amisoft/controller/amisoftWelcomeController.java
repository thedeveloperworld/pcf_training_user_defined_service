package com.amisoft.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amitdatta on 10/06/17.
 */

@RestController
public class amisoftWelcomeController {


    @RequestMapping(value = "/welcome", method= RequestMethod.GET)
    public ResponseEntity<String> welcomeMessage(){

        ResponseEntity<String> responseStatus = null;
        return responseStatus = ResponseEntity.status(HttpStatus.OK).body
                ("<center><h1 style=\"color:Blue;\"><b>  Welcome  to PCF Training  </center></h1></b>");
    }
}
