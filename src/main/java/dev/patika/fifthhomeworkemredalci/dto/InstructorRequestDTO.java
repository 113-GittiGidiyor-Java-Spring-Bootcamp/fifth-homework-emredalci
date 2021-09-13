package dev.patika.fifthhomeworkemredalci.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorRequestDTO {

    @ApiModelProperty(example = "Emre")
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3,max = 50)
    private String name;

    @ApiModelProperty(example = "İstanbul")
    @NotBlank(message = "Address is mandatory")
    @Size(max = 100)
    private String address;

    @ApiModelProperty(example = "05XXXXXXXXX")
    @NotBlank(message = "Phone number is mandatory")
    @Size(min = 10,max = 11)
    private String phoneNumber;
}
