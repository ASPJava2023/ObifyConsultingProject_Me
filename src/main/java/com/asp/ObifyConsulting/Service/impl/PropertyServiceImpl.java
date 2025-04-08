package com.asp.ObifyConsulting.Service.impl;

import com.asp.ObifyConsulting.DTO.PropertyDTO;
import com.asp.ObifyConsulting.Service.PropertyService;
import com.asp.ObifyConsulting.converter.PropertyConver;
import com.asp.ObifyConsulting.entity.PropertyEntity;
import com.asp.ObifyConsulting.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> entities = propertyRepository.findAll();
        List<PropertyDTO> plist = new ArrayList<PropertyDTO>();
        for (PropertyEntity propertyEntity :entities) {
            PropertyDTO propertyDTO = propertyConver.convertEntityTODTO(propertyEntity);
               plist.add(propertyDTO);
        }
        return plist;
    }
}
