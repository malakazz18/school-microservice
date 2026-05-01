package edu.isgb.school.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idStudent;


    private String name;


    @Temporal(TemporalType.DATE)
    private Date birthDate;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)

    private School school;

}