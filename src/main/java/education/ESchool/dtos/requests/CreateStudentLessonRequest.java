package education.ESchool.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentLesson {

    private LocalDate enrollmentDate;
    private double grade;
    private int lesson_id;
    private int student_id;

    private double point1;

    private double point2;
}
