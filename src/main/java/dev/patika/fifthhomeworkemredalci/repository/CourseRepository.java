package dev.patika.fifthhomeworkemredalci.repository;


import dev.patika.fifthhomeworkemredalci.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    Optional<Course> findByCourseName(String courseName);
    void deleteByCourseName(String courseName);
    boolean existsByCourseCode(String courseCode);
    Optional<Course> findByCourseCode(String courseCode);
}
