package dev.patika.fifthhomeworkemredalci.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
@Entity
public class Course extends AbstractBaseEntity{

    // instance variables
    @Column(name = "course_code",nullable = false,unique = true)
    private String courseCode;

    @Column(name = "course_name",nullable = false,length = 50)
    private String courseName;

    @Column(name = "credit_score",nullable = false)
    private double creditScore;

    @ManyToMany( fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"courses"})
    private Set<Student> students = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"courses"})
    @JoinColumn(name = "instructor_id")
    @JsonBackReference
    private Instructor instructor;

    //equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }

    //toString

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", creditScore=" + creditScore +
                '}';
    }
}
