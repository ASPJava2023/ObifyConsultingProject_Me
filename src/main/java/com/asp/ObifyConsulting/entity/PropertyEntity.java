package com.asp.ObifyConsulting.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
    @NotEmpty(message = "Title can't be Empty")
    @Column(name = "PROPERTY_TITLE",nullable = false)
    @Size(min = 3,max = 40,message = "Must be 3-40 words long")
    private String title;
    private String description;
    private String ownerName;
    @Column(name = "OwnerEmail",nullable = false)
    @Email(message = "Email is not valid")
    private String ownerEmail;
    @Min(value = 11,message = "Price should be greater than 11 Rs")
    private Double price;
    private String address;
}
