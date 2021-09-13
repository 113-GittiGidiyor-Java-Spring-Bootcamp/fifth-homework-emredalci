package dev.patika.fifthhomeworkemredalci.dto;


import dev.patika.fifthhomeworkemredalci.model.enumeration.Gender;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO {

    @ApiModelProperty(example = "Ahmet")
    @NotBlank(message = "Student name is mandatory")
    @Size(min = 3, max = 50)
    private String name;

    @ApiModelProperty(example = "YYYY-MM-DD")
    // @NotBlank(message = "Birth date is mandatory")
    private LocalDate birthDate;

    @ApiModelProperty(example = "Istanbul")
    @NotBlank(message = "Address is mandatory")
    @Size(max = 100)
    private String address;

    @ApiModelProperty(example = "MALE or FEMALE")
    @NotNull
    private Gender gender;

}
