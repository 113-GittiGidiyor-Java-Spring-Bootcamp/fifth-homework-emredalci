package dev.patika.fifthhomeworkemredalci.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestDTO {

    @ApiModelProperty(example = "CS101")
    @NotBlank(message = "Course code is mandatory")
    @Size(min = 2,max = 6)
    private String courseCode;

    @ApiModelProperty(example = "Introduction the Computer Science")
    @NotBlank(message = "Course name is mandatory")
    @Size(max = 100)
    private String courseName;

    @ApiModelProperty(example = "4.0")
    @NotNull(message = "Credit score is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private double creditScore;

    @NotNull(message = "Instructor id is mandatory")
    private long instructorId;

    private Set<Long> studentIds = new HashSet<>();

}
