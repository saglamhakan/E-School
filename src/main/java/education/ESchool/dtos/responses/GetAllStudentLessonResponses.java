package education.ESchool.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllStudentLessonResponses {

    private int id;
    private LocalDate enrollmentDate;
    private Double grade;
    private int lesson_id;
    private int student_id;

    private int point1;

    private int point2;
}
