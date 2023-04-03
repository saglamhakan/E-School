package education.ESchool.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdStudentLessonResponses {

    private int studentId;

    private int lessonId;

    private double grade;


}
