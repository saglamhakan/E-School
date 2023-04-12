package education.ESchool.rules;

import education.ESchool.dataAccess.StudentRepository;
import education.ESchool.dtos.requests.CreateOneStudentRequest;
import education.ESchool.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@AllArgsConstructor
public class StudentBusinessRules {

    private StudentRepository studentRepository;

    public void existsByStudentNumber(String studentNumber){
        if (this.studentRepository.existsByStudentNumber(studentNumber)){
            throw new BusinessException("Student number already exists");
        }
    }

    public boolean validateRequest(CreateOneStudentRequest createOneStudentRequest) {
        boolean isSuccess = true;

        if (StringUtils.isEmpty(createOneStudentRequest.getStudentName())) {
            isSuccess = false;

        }
        return isSuccess;
    }
}
