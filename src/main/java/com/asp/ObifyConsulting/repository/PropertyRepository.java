package com.asp.ObifyConsulting.repository;

import com.asp.ObifyConsulting.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<PropertyEntity,Long> {
}
