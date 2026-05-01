package edu.isgb.school.controller;


import edu.isgb.school.entities.*;
import edu.isgb.school.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestSchoolController {

    private final SchoolService schoolService;

    public TestSchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }


    @PostMapping("/schools")
    public School createSchool(@RequestBody School school) {
        return schoolService.createSchool(school, null, null, null);
    }

    @GetMapping("/schools/{id}")
    public School getSchool(@PathVariable Integer id) {
        return schoolService.getSchoolById(id);
    }


    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student,
                                 @RequestParam(required = false) Integer schoolId) {
        return schoolService.createStudent(student, student.getAddress(), schoolId);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return schoolService.getAllStudents();
    }

    @PostMapping("/instructors")
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        return schoolService.createInstructor(instructor, instructor.getCourses());
    }

    @GetMapping("/instructors")
    public List<Instructor> getInstructorsByName(@RequestParam String name) {
        return schoolService.getInstructorsByName(name);
    }

    @GetMapping("/instructors/{id}")
    public Instructor getInstructor(@PathVariable Integer id) {
        return schoolService.getInstructorById(id);
    }

    @GetMapping("/instructors/{id}/courses")
    public List<Course> getInstructorCourses(@PathVariable Integer id) {
        return schoolService.getCoursesByInstructorId(id);
    }

    @PostMapping("/instructors/{id}/courses")
    public Instructor addCourse(@PathVariable Integer id,
                                @RequestBody Course course) {
        return schoolService.addCourseToInstructor(id, course);
    }


    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable Integer id) {
        return schoolService.getCourseById(id);
    }
}
