package dev.patika.fifthhomeworkemredalci.model;



import dev.patika.fifthhomeworkemredalci.model.enumeration.UpdateSalaryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InstructorSalaryLogger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long instructorId;
    private String clientIpAddress;
    private String clientUrl;
    private String sessionActivityId;

    @Column(updatable = false)
    private LocalDate createdTime;

    @Enumerated(EnumType.STRING)
    private UpdateSalaryType updateSalaryType;
    private double salaryBefore;
    private double salaryAfter;
    private double salaryRate;

    // Equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstructorSalaryLogger that = (InstructorSalaryLogger) o;
        return instructorId == that.instructorId && Double.compare(that.salaryBefore, salaryBefore) == 0 && Double.compare(that.salaryAfter, salaryAfter) == 0 && Double.compare(that.salaryRate, salaryRate) == 0 && Objects.equals(clientIpAddress, that.clientIpAddress) && Objects.equals(clientUrl, that.clientUrl) && Objects.equals(sessionActivityId, that.sessionActivityId) && Objects.equals(createdTime, that.createdTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructorId, clientIpAddress, clientUrl, sessionActivityId, createdTime, salaryBefore, salaryAfter, salaryRate);
    }

    //toString


    @Override
    public String toString() {
        return "InstructorSalaryLogger{" +
                "id=" + id +
                ", instructorId=" + instructorId +
                ", clientIpAddress='" + clientIpAddress + '\'' +
                ", clientUrl='" + clientUrl + '\'' +
                ", sessionActivityId='" + sessionActivityId + '\'' +
                ", transactionDateTime=" + createdTime +
                ", salaryBefore=" + salaryBefore +
                ", salaryAfter=" + salaryAfter +
                ", salaryRate=" + salaryRate +
                '}';
    }
}
