package com.asp.ObifyConsulting.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestPropertyConver {

    @InjectMocks
    private  PropertyConver propertyConver;

    @Test
    @DisplayName("convert DTO  To Entity success")
    public void convertDTOEntityTest(){

        //propertyConver.convertDTOEntity();

    }

    @Test
    @DisplayName("convert Entity to DTO success")
    public void convertEntityTODTOTest(){

    }

}
