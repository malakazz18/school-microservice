package edu.isgb.school.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idCourse;


    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)

    private List<Instructor> instructors = new ArrayList<>();


}
