package com.asp.ObifyConsulting.Service.impl;

import com.asp.ObifyConsulting.DTO.PropertyDTO;
import com.asp.ObifyConsulting.Service.PropertyService;
import com.asp.ObifyConsulting.converter.PropertyConver;
import com.asp.ObifyConsulting.entity.PropertyEntity;
import com.asp.ObifyConsulting.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConver propertyConver;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        //propertyConver.convertDTOEntity(propertyDTO);
        PropertyEntity propertyEntity = propertyConver.convertDTOEntity(propertyDTO);
        propertyEntity = propertyRepository.save(propertyEntity);
         propertyDTO = propertyConver.convertEntityTODTO(propertyEntity);
        return propertyDTO;
    }
}
