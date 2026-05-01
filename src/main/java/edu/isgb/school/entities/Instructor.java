package edu.isgb.school.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idInstructor;


    private String name;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "instructor_course",
            joinColumns = @JoinColumn(name = "idInstructor"),
            inverseJoinColumns = @JoinColumn(name = "idCourse")
    )
    private List<Course> courses = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)

    private School school;




    public void addCourse(Course course) {
        courses.add(course);
        course.getInstructors().add(this);
    }


}