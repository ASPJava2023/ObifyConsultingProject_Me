package com.asp.ObifyConsulting.converter;

import com.asp.ObifyConsulting.DTO.PropertyDTO;
import com.asp.ObifyConsulting.entity.PropertyEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(value = MockitoExtension.class)
public class PropertyConverTest {

    @InjectMocks
    private PropertyConver propertyConver;
    @Test
    @DisplayName("convert DTO to EntityTest_Success")
    public void convertDTOEntityTest(){
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(1l);
        propertyDTO.setTitle("Dummy");
        propertyDTO.setDescription("Dummy Description");
        propertyDTO.setOwnerName("Dummay Name");
        propertyDTO.setOwnerEmail("Dummay@gmail.com");
        propertyDTO.setPrice(1000.10);
        propertyDTO.setAddress("Dummay Address");
        PropertyEntity propertyEntity = propertyConver.convertDTOEntity(propertyDTO);
        Assertions.assertEquals(propertyDTO.getTitle(),propertyEntity.getTitle());
        Assertions.assertEquals(propertyDTO.getDescription(),propertyEntity.getDescription());
        Assertions.assertEquals(propertyDTO.getOwnerName(),propertyEntity.getOwnerName());
        Assertions.assertEquals(propertyDTO.getOwnerEmail(),propertyEntity.getOwnerEmail());
        Assertions.assertEquals(propertyDTO.getPrice(),propertyEntity.getPrice());
        Assertions.assertEquals(propertyDTO.getAddress(),propertyEntity.getAddress());
    }
    @Disabled
    @Test
    @DisplayName("convert DTO to EntityTest_Fail")
    public void convertDTOEntityTestFail(){
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(1l);
        propertyDTO.setTitle("Dummy");
        propertyDTO.setDescription("Dummy Description");
        propertyDTO.setOwnerName("Dummay Name");
        propertyDTO.setOwnerEmail("Dummay@gmail.com");
        propertyDTO.setPrice(1000.10);
        propertyDTO.setAddress("Dummay Address");
        PropertyEntity propertyEntity = propertyConver.convertDTOEntity(propertyDTO);
        System.out.println("Result"+propertyEntity.equals(propertyDTO));
        System.out.println("propertyEntity"+propertyEntity.toString());
        System.out.println("propertyDTO"+propertyDTO.toString());
        Assertions.assertNotEquals(propertyDTO.getTitle(),propertyEntity.getTitle());
        Assertions.assertNotEquals(propertyDTO.getDescription(),propertyEntity.getDescription());
        Assertions.assertNotEquals(propertyDTO.getOwnerName(),propertyEntity.getOwnerName());
        Assertions.assertNotEquals(propertyDTO.getOwnerEmail(),propertyEntity.getOwnerEmail());
        Assertions.assertNotEquals(propertyDTO.getPrice(),propertyEntity.getPrice());
        Assertions.assertNotEquals(propertyDTO.getAddress(),propertyEntity.getAddress());
    }
    @Test
    @DisplayName("convert Entity to DTO Test")
    public void convertEntityTODTOTest(){

        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle("Dummay");
        propertyEntity.setId(1l);
        propertyEntity.setDescription("Dummay Dummay");
        propertyEntity.setPrice(1000.00);
        propertyEntity.setOwnerEmail("Dummay@gmail.com");
        propertyEntity.setOwnerName("Dummy");
        PropertyDTO propertyDTO = propertyConver.convertEntityTODTO(propertyEntity);
        Assertions.assertEquals(propertyDTO.getTitle(),propertyEntity.getTitle());
        Assertions.assertEquals(propertyDTO.getDescription(),propertyEntity.getDescription());
        Assertions.assertEquals(propertyDTO.getOwnerName(),propertyEntity.getOwnerName());
        Assertions.assertEquals(propertyDTO.getOwnerEmail(),propertyEntity.getOwnerEmail());
        Assertions.assertEquals(propertyDTO.getPrice(),propertyEntity.getPrice());
        Assertions.assertEquals(propertyDTO.getAddress(),propertyEntity.getAddress());
    }
}
