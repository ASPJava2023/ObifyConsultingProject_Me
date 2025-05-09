package com.asp.ObifyConsulting.controller;

import com.asp.ObifyConsulting.DTO.MyDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@Slf4j
@RequestMapping("/api/v1")
public class Mycontroller {
    @GetMapping("/")
    public String welcomeinit(){
        log.info("The Welcome controller activatied");
        return "Welcome to Ankit API";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "This is welcome message from ASP";
    }
    @GetMapping("/add")
    public Double add(@RequestParam("n1") Double n1,@RequestParam("n2") Double n2){
        return n1+n2;
        }
    @GetMapping("/multiplay/{n1}/{n2}")
        public Double multiplay(@PathVariable("n1") Double n1,@PathVariable("n2") Double n2){
        Double result =null;
        if(n1>n2){
            result= n1*n2;
            return result;
        }
        else{
            result= n1*n2;
            return result;
        }

    }
@PostMapping("/mulAll")
    public ResponseEntity mulAll(@RequestBody MyDTO myDTO){
        Double result = null;
        result = myDTO.getN1()+ myDTO.getN2()+ myDTO.getN3();
    ResponseEntity<Double>responseEntity = new ResponseEntity<Double>(Double.valueOf(result.toString()), HttpStatus.CREATED);
        return responseEntity;
}
}
