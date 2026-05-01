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

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idDepartment;


    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private School school;


}