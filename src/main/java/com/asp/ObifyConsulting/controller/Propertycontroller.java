package com.asp.ObifyConsulting.controller;

import com.asp.ObifyConsulting.DTO.PropertyDTO;
import com.asp.ObifyConsulting.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Property/v1")
public class Propertycontroller {
   @Autowired
    private PropertyService propertyService;
    @PostMapping("/save")
    public ResponseEntity saveProperty(@RequestBody PropertyDTO propertyDTO){
        System.out.println(propertyDTO);
        propertyDTO = propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity =
                new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        System.out.println("Hello to check");
        return responseEntity;
        //return propertyDTO;

    }
}
