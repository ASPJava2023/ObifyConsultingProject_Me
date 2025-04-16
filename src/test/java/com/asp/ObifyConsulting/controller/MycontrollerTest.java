package com.asp.ObifyConsulting.controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MycontrollerTest {
    @InjectMocks
    private Mycontroller mycontroller;
    @BeforeEach
    void init(){
        System.out.println("**************---------***************");
    }
    @AfterEach
    void destroy(){
        System.out.println("XXXXX=====XXXXXXXXXXXXXXXXXX");
    }

    @Test
    @DisplayName("Test Adding success scenario")
    @Tag("Success")
    void addTest(){
         Double expectedValue =6.9;
        Double actualValue = mycontroller.add(3.5, 3.4);
        Assertions.assertEquals(expectedValue,actualValue);
        System.out.println("Test Adding success scenario");
    }
    @Test
    @DisplayName("Test Adding fail scenario")
    @Tag("Fail")
    void addTest_fail(){
        Double expectedValue = 6.9;
        Double actualValue = mycontroller.add(3.0, 3.4);
        System.out.println("Test Adding fail scenario");
        Assertions.assertNotEquals(expectedValue,actualValue);
    }
}
