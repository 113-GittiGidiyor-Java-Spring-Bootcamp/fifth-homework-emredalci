package dev.patika.fifthhomeworkemredalci.util;

import java.time.LocalDate;
import java.time.Period;

public class StudentValidatorUtil {

    public static boolean validateStudentAge(LocalDate birthDate,LocalDate currentDate) {
            int age = Period.between(birthDate,currentDate).getYears();
            if(age > 18 && age <40) {
                return true;
            }else{
                return false;
            }
    }




}
