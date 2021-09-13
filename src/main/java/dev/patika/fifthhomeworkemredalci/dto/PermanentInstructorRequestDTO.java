package dev.patika.fifthhomeworkemredalci.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PermanentInstructorRequestDTO extends InstructorRequestDTO {

    @ApiModelProperty(example = "1000.0")
    @NotNull(message = "Fixed salary is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private double fixedSalary;

}
