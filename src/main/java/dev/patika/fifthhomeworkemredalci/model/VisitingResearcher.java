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
@Table(name = "visiting_researchers")
@PrimaryKeyJoinColumn(name = "instructor_id")
public class VisitingResearcher extends Instructor{

    @Column(name = "hourly_salary",nullable = false,precision = 4,scale = 1)
    private double hourlySalary;

}
