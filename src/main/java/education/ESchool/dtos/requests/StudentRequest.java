package education.ESchool.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {



    private String studentName;

    private String studentNumber;

    private String password;
}
