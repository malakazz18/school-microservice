package edu.isgb.school.service;

import edu.isgb.school.entities.*;
import edu.isgb.school.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;
    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;

    public SchoolService(SchoolRepository schoolRepository,
                         StudentRepository studentRepository,
                         InstructorRepository instructorRepository,
                         CourseRepository courseRepository,
                         DepartmentRepository departmentRepository) {
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseRepository;
        this.departmentRepository = departmentRepository;
    }

    public School createSchool(School school, List<Student> students,
                               List<Instructor> instructors, List<Department> departments) {
        if (students != null) {
            new ArrayList<>(students).forEach(school::addStudent);
        }
        if (instructors != null) {
            new ArrayList<>(instructors).forEach(school::addInstructor);
        }
        if (departments != null) {
            new ArrayList<>(departments).forEach(school::addDepartment);
        }
        return schoolRepository.save(school);
    }


    @Transactional(readOnly = true)
    public School getSchoolById(Integer id) {
        return schoolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("School not found with id: " + id));
    }


    public Student createStudent(Student student, Address address, Integer schoolId) {
        student.setAddress(address);
        if (schoolId != null) {
            School school = getSchoolById(schoolId);
            school.addStudent(student);
            schoolRepository.save(school);
            return studentRepository.save(student);
        }
        return studentRepository.save(student);
    }


    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public Instructor createInstructor(Instructor instructor, List<Course> courses) {
        if (courses != null) {
            List<Course> coursesCopy = new ArrayList<>(courses);
            coursesCopy.forEach(instructor::addCourse);
        }
        return instructorRepository.save(instructor);
    }


    @Transactional(readOnly = true)
    public List<Instructor> getInstructorsByName(String name) {
        return instructorRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public Instructor getInstructorById(Integer id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found with id: " + id));
    }

    @Transactional(readOnly = true)
    public Course getCourseById(Integer id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }


    @Transactional(readOnly = true)
    public List<Course> getCoursesByInstructorId(Integer instructorId) {
        Instructor instructor = getInstructorById(instructorId);
        return instructor.getCourses();
    }

    public Instructor addCourseToInstructor(Integer instructorId, Course course) {
        Instructor instructor = getInstructorById(instructorId);
        instructor.addCourse(course);
        return instructorRepository.save(instructor);
    }
}
