package com.asp.ObifyConsulting.controller;

import com.asp.ObifyConsulting.DTO.PropertyDTO;
import com.asp.ObifyConsulting.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PatchExchange;

import java.util.List;

@RestController
@RequestMapping("/Property/v1")
public class Propertycontroller {

    //Swagger end point -http://localhost:9094/swagger-ui/index.html
   @Autowired
    private PropertyService propertyService;
   @GetMapping("/hello")
   public static String sayHello(){
       return "Hello from ankit";
   }
    @PostMapping("/properties")
    public ResponseEntity saveProperty(@RequestBody @Valid PropertyDTO propertyDTO){
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
       propertyService.updateProperty(propertyDTO, propertyId);
        return  new ResponseEntity(propertyDTO,HttpStatus.OK);
    }
    @PatchExchange("/properties/updateDescription/{propertyId}")
    public ResponseEntity <PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO,
                                          @PathVariable Long propertyId)
    {
        propertyDTO = propertyService.updatePropertyDescription(propertyDTO, propertyId);
        return  new ResponseEntity(propertyDTO,HttpStatus.OK);
    }
    @PatchExchange("/properties/updatePropertyPrice/{propertyId}")
    public ResponseEntity <PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO,
                                          @PathVariable Long propertyId)
    {
         propertyDTO = propertyService.updatePropertyPrice(propertyDTO, propertyId);
        return  new ResponseEntity(propertyDTO,HttpStatus.OK);
    }
    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> deleteProperty(@PathVariable Long propertyId){
            propertyService.deleteProperty(propertyId);
        return  new ResponseEntity("Property deleted",HttpStatus.OK);
    }
}
