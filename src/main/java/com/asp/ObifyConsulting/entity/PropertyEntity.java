package com.asp.ObifyConsulting.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PROPERTY_TABLE")
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "PROPERTY_TITLE")
    private String title;
    private String description;
    private String ownerName;
    @Column(name = "OwnerEmail")
    private String ownerEmail;
    private Double price;
    private String address;
}
