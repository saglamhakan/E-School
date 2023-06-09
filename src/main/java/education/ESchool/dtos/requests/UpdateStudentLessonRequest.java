package education.ESchool.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentLessonRequest {

    private int lessonId;

    private int studentId;

    private int point1;

    private int point2;
}
