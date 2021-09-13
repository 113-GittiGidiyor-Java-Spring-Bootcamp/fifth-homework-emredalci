package dev.patika.fifthhomeworkemredalci.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "instructors")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,property = "type",include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({@JsonSubTypes.Type(value =PermanentInstructor.class,name="PermanentInstructor"),
               @JsonSubTypes.Type(value = VisitingResearcher.class,name= "VisitingResearcher")})
public class Instructor extends AbstractBaseEntity{

    @Column(name = "name",nullable = false,length = 25)
    private String name;

    @Column(name = "address",nullable = false,length = 100)
    private String address;

    @Column(name = "phone_number",nullable = false,unique = true,length = 11)
    private String phoneNumber;

    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnoreProperties({"instructor","students"})
    private Set<Course> courses = new HashSet<>();

    //equals and hashCode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructor that = (Instructor) o;
        return Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    //toString

    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
