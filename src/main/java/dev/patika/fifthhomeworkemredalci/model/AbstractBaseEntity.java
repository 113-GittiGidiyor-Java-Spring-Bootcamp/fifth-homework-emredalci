package dev.patika.fifthhomeworkemredalci.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @CreatedDate
    @JsonIgnore
    @Column(name = "created_date", nullable = false,updatable = false)
    private Instant createdDate = Instant.now();

    @LastModifiedDate
    @JsonIgnore
    @Column(name = "last_modified_date",nullable = false)
    private Instant lastModifiedDate = Instant.now();


}
