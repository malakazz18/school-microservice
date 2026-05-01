package edu.isgb.school.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity


public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idAddress;


    private String street;


    private String city;


    private String postalCode;


}