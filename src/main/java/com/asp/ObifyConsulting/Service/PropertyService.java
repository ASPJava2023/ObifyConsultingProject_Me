package com.asp.ObifyConsulting.Service;

import com.asp.ObifyConsulting.DTO.PropertyDTO;

import java.util.List;

public interface PropertyService {
    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List <PropertyDTO> getAllProperties();
}
