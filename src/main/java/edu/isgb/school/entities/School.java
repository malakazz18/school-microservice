package edu.isgb.school.entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity

public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idSchool;


    private String name;

    private Integer phone;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Department> departments = new ArrayList<>();


    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Instructor> instructors = new ArrayList<>();

    public School() {}

    public School(String name, Integer phone) {
        this.name = name;
        this.phone = phone;
    }


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

    public Integer getIdSchool() { return idSchool; }
    public void setIdSchool(Integer idSchool) { this.idSchool = idSchool; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getPhone() { return phone; }
    public void setPhone(Integer phone) { this.phone = phone; }

    public List<Department> getDepartments() { return departments; }
    public void setDepartments(List<Department> departments) { this.departments = departments; }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }

    public List<Instructor> getInstructors() { return instructors; }
    public void setInstructors(List<Instructor> instructors) { this.instructors = instructors; }
}
