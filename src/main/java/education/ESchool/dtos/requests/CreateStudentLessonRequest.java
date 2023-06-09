package education.ESchool.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentLessonRequest {

    private LocalDate enrollmentDate;
    private double grade;
    private int lesson_id;
    private int student_id;
    private int point1;
    private int point2;
    private int discontinuity;

}
