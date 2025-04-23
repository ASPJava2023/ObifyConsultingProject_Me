package com.asp.ObifyConsulting.controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MycontrollerTest {
    @InjectMocks
    private Mycontroller mycontroller;
   static Double num1;
   static Double num2;

    @BeforeAll
    static void BeforeAll(){
        num1 = 3.5;
        num2 = 3.5;
        System.out.println("After all test run");
    }
    @BeforeEach
    void init() {
        System.out.println("**************---------***************");
//        num1 = 3.5;
//        num2 = 3.5;
    }
    @AfterEach
    void destroy() {
        System.out.println("XXXXX=====XXXXXXXXXXXXXXXXXX");
//        num1 =null;
//        num2 =null;
}
@AfterAll
   static void afterAll(){
    System.out.println("After all test run");
    num1 =null;
    num2 =null;
    }
    @Test
    @DisplayName("Test Adding success scenario")
    @Tag("Success")
        void addTest(){
         Double expectedValue = 7.0;
        Double result = mycontroller.add(num1, num2);
        Assertions.assertEquals(expectedValue,result);
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
    @Test
    @DisplayName("Test multiplay for num1 than num2 pass scenario")
    @Tag("Success")
    public void Testmultiplay_num1_gt_num2(){
        double actual =15.75;
        Double result = mycontroller.multiplay(num1+1, num2);
        Assertions.assertEquals(result,actual);
    }
    @Test
    @DisplayName("Test multiplay for num1 is less than num2 pass scenario")
    @Tag("pass")
    public void Testmultiplay_num1_Not_gt_num2(){
        double actual =15.75;
        Double result = mycontroller.multiplay(num1, num2+1);
        Assertions.assertEquals(result,actual);
    }
}
