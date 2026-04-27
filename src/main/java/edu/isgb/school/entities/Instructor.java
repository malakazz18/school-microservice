package edu.isgb.school.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idInstructor;


    private String name;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "Instructor_Course",
            joinColumns = @JoinColumn(name = "instructors_pk_Instructor"),
            inverseJoinColumns = @JoinColumn(name = "courses_pk_course")
    )
    private List<Course> courses = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_PK_school")
    private School school;

    public Instructor() {}

    public Instructor(String name) {
        this.name = name;
    }


    public void addCourse(Course course) {
        courses.add(course);
        course.getInstructors().add(this);
    }

    public Integer getIdInstructor() { return idInstructor; }
    public void setIdInstructor(Integer idInstructor) { this.idInstructor = idInstructor; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }

    public School getSchool() { return school; }
    public void setSchool(School school) { this.school = school; }
}