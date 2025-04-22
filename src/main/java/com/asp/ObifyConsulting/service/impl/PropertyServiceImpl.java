package com.asp.ObifyConsulting.service.impl;

import com.asp.ObifyConsulting.DTO.PropertyDTO;
import com.asp.ObifyConsulting.exception.PropertyNotFoundExceptionCustom;
import com.asp.ObifyConsulting.service.PropertyService;
import com.asp.ObifyConsulting.converter.PropertyConver;
import com.asp.ObifyConsulting.entity.PropertyEntity;
import com.asp.ObifyConsulting.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
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
        log.info("Data saved in DB");
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

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> byId = propertyRepository.findById(propertyID);
        PropertyDTO dto  = null;
        if (byId.isPresent()) {

            PropertyEntity propertyEntity = byId.get();
             // System.out.println("Print id");
            propertyEntity.setTitle(propertyDTO.getTitle());
            propertyEntity.setDescription(propertyDTO.getDescription());
            propertyEntity.setOwnerName(propertyDTO.getOwnerName());
            propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
            propertyEntity.setPrice(propertyDTO.getPrice());
            propertyEntity.setAddress(propertyDTO.getAddress());

            dto = propertyConver.convertEntityTODTO(propertyEntity);
            propertyRepository.save(propertyEntity);
            System.out.println("Updated Record Saved");
            return dto;
        } else {
            System.out.println("No id found with Number:" + propertyID);
            return new PropertyDTO();
        }
    }
    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyID) {
        Optional <PropertyEntity> byId = Optional.ofNullable(propertyRepository.findById(propertyID)
                .orElseThrow(() -> new PropertyNotFoundExceptionCustom("Property not found " + propertyID)));
        //if (byId.isPresent()) {
            PropertyDTO dto =null;
            PropertyEntity propertyEntity = byId.get();
            propertyEntity.setDescription(propertyDTO.getDescription());
            dto = propertyConver.convertEntityTODTO(propertyEntity);
            propertyRepository.save(propertyEntity);
            System.out.println("Updated Description in Record Saved");
            return dto;

        }


    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> byId = propertyRepository.findById(propertyID);
        if (byId.isPresent()) {
            PropertyDTO dto =null;
            PropertyEntity propertyEntity = byId.get();
            propertyEntity.setPrice(propertyDTO.getPrice());
            dto = propertyConver.convertEntityTODTO(propertyEntity);
            propertyRepository.save(propertyEntity);
            System.out.println("Updated Description in Record Saved");
            return dto;
           } else {
            System.out.println("No id found with Number:" + propertyID);
            return new PropertyDTO();
        }
    }

    @Override
    public void deleteProperty(Long propertyID) {
        propertyRepository.deleteById(propertyID);
        System.out.println("It Given property deletated");
    }

}
