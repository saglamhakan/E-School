package education.ESchool.dtos.requests;

import lombok.Data;

@Data
public class LoginRequest {

    private String studentName;
    private String password;
}
