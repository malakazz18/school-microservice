package edu.isgb.school.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idCourse;


    private String name;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private List<Instructor> instructors = new ArrayList<>();

    public Course() {}

    public Course(String name) {
        this.name = name;
    }

    public Integer getIdCourse() { return idCourse; }
    public void setIdCourse(Integer idCourse) { this.idCourse = idCourse; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Instructor> getInstructors() { return instructors; }
    public void setInstructors(List<Instructor> instructors) { this.instructors = instructors; }
}
