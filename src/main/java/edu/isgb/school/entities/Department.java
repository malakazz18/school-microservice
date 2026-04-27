package edu.isgb.school.entities;


import jakarta.persistence.*;

@Entity

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idDepartment;


    private String name;

    @ManyToOne(fetch = FetchType.LAZY)

    private School school;

    public Department() {}

    public Department(String name) {
        this.name = name;
    }

    public Integer getIdDepartment() { return idDepartment; }
    public void setIdDepartment(Integer idDepartment) { this.idDepartment = idDepartment; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public School getSchool() { return school; }
    public void setSchool(School school) { this.school = school; }
}