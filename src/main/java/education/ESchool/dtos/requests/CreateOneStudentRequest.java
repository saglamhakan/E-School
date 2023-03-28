package education.ESchool.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOneStudentRequest {

    private String studentName;
    private int studentNumber;
}
