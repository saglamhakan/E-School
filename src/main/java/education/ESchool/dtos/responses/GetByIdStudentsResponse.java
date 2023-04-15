package education.ESchool.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdStudentsResponse {

    private int studentId;
    private String studentName;

    private String studentNumber;

    private String lessonName;

    private int firstExamPoints;

    private int secondExamPoints;

    private int averagePoints;

    private int absenteeism;


}
