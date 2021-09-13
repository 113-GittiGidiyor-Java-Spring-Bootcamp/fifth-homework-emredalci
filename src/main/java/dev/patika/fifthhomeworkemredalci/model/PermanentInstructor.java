package dev.patika.fifthhomeworkemredalci.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permanent_instructors")
@PrimaryKeyJoinColumn(name = "instructor_id")
public class PermanentInstructor extends Instructor{

    @Column(name = "fixed_salary",nullable = false,precision = 7,scale = 1)
    private double fixedSalary;


}
