package dev.patika.fifthhomeworkemredalci.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDTO extends StudentRequestDTO{

    private long id;

}
