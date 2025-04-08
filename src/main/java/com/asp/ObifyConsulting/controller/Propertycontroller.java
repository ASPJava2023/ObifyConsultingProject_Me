package com.asp.ObifyConsulting.controller;

import com.asp.ObifyConsulting.DTO.PropertyDTO;
import com.asp.ObifyConsulting.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        System.out.println("Data saved in DB");
        return responseEntity;
        //return propertyDTO;
    }
    @GetMapping("/properties")
    public ResponseEntity<PropertyDTO>getAllproperties(){
        List<PropertyDTO> allProperties = propertyService.getAllProperties();
        return new ResponseEntity(allProperties,HttpStatus.OK);
    }
    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(
            @RequestBody PropertyDTO propertyDTO,@PathVariable long propertyId){
        propertyDTO = propertyService.updateProperty(propertyDTO, propertyId);
        return  new ResponseEntity(propertyDTO,HttpStatus.CREATED);
    }
}
