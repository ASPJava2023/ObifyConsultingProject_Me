package com.asp.ObifyConsulting.service;

import com.asp.ObifyConsulting.DTO.PropertyDTO;

import java.util.List;

public interface PropertyService {
    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties();
    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyID);
    PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyID);

    PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyID);
    void deleteProperty(Long propertyID);
}