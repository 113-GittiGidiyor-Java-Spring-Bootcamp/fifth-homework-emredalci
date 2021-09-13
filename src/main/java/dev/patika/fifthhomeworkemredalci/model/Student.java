package dev.patika.fifthhomeworkemredalci.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import dev.patika.fifthhomeworkemredalci.model.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
@Entity
public class Student extends AbstractBaseEntity{

    @Column(name = "name",nullable = false,length = 50)
    private String name;

    @Column(name = "birth_date",nullable = false)
    private LocalDate birthDate;

    @Column(name = "address",nullable = false,length =100)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "students")
    @JsonIgnoreProperties({"students","instructor"})
    private Set<Course> courses = new HashSet<>();

    //equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(birthDate, student.birthDate) && Objects.equals(address, student.address) && gender == student.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, address, gender);
    }

    //toString

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                '}';
    }
}
