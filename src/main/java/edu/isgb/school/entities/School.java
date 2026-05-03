package edu.isgb.school.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idSchool;


    private String name;

    private Integer phone;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Department> departments = new ArrayList<>();


    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Instructor> instructors = new ArrayList<>();




    public void addDepartment(Department department) {
        departments.add(department);
        department.setSchool(this);
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setSchool(this);
    }

    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
        instructor.setSchool(this);
    }


}
