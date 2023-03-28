package education.ESchool.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOneLessonRequest {

    private int lessonId;
    private String lessonName;

    private double lessonPoints;

    private int studentId;

    private String studentName;
    


}
