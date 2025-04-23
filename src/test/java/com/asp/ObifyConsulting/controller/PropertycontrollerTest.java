package com.asp.ObifyConsulting.controller;

import com.asp.ObifyConsulting.DTO.PropertyDTO;
import com.asp.ObifyConsulting.service.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertycontrollerTest {
    @InjectMocks
    private Propertycontroller propertycontroller;
    @Mock
    private PropertyService propertyService;
    @Test
    @DisplayName(value = "Test success scnario for saving new property")
    public void testsaveProperty(){
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(101L);
        propertyDTO.setTitle("Vila");
        propertyDTO.setDescription("At city");
        propertyDTO.setOwnerName("Ram lal");
        propertyDTO.setOwnerEmail("Ram@gmail.com");
        propertyDTO.setPrice(232.32);
        propertyDTO.setAddress("Mumbai");
        //PropertyDTO savedProperty = new PropertyDTO();
        //savedProperty.setId(1l);
        Mockito.when(propertyService.saveProperty(propertyDTO)).thenReturn(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = propertycontroller.saveProperty(propertyDTO);
        Assertions.assertNotNull(responseEntity.getBody().getId());
        Assertions.assertEquals(HttpStatus.CREATED.value(),responseEntity.getStatusCodeValue());
        }
        @Test
        @DisplayName(value = "Test success scnario for Getting all property")
         public  void TestgetAllproperties(){

            List<PropertyDTO> allSavedProperties = new ArrayList<>();
            PropertyDTO propertyDTO1 = new PropertyDTO();
            propertyDTO1.setId(101L);
            propertyDTO1.setTitle("Vila");
            propertyDTO1.setDescription("At city");
            propertyDTO1.setOwnerName("Ram lal");
            propertyDTO1.setOwnerEmail("Ram@gmail.com");
            propertyDTO1.setPrice(232.32);
            propertyDTO1.setAddress("Mumbai");

            PropertyDTO propertyDTO2 = new PropertyDTO();
            propertyDTO2.setId(101L);
            propertyDTO2.setTitle("Vila");
            propertyDTO2.setDescription("At city");
            propertyDTO2.setOwnerName("Ram lal");
            propertyDTO2.setOwnerEmail("Ram@gmail.com");
            propertyDTO2.setPrice(232.32);
            propertyDTO2.setAddress("Mumbai");

            allSavedProperties.add(propertyDTO1);
            allSavedProperties.add(propertyDTO2);

            OngoingStubbing<List<PropertyDTO>> listOngoingStubbing =
                                            Mockito.when(propertyService
                                        .getAllProperties())
                                    .thenReturn(allSavedProperties);
            ResponseEntity<PropertyDTO> responseEntity= propertycontroller.getAllproperties();
            Assertions.assertEquals(HttpStatus.OK.value(),responseEntity.getStatusCodeValue());

        }
        @Test
        @DisplayName(value = "\"Test success scnario for TestUpdatePropertyPrice property")
        public void TestUpdatePropertyPrice(){
            PropertyDTO propertyDTO = new PropertyDTO();
            propertyDTO.setPrice(42000.00);
            Mockito.when(propertyService.updatePropertyPrice(Mockito.any(),Mockito.anyLong())).thenReturn(propertyDTO);
            ResponseEntity<PropertyDTO> responseEntity = propertycontroller.updatePropertyPrice(propertyDTO, 1L);
            Assertions.assertEquals(42000.00,responseEntity.getBody().getPrice());
            Assertions.assertEquals(HttpStatus.OK.value(),responseEntity.getStatusCodeValue());
        }
}
