package education.ESchool.rules;

import education.ESchool.dataAccess.StudentRepository;
import education.ESchool.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentBusinessRules {

    private StudentRepository studentRepository;

    public void existsByStudentNumber(int studentNumber){
        if (this.studentRepository.existsByStudentNumber(studentNumber)){
            throw new BusinessException("Student number already exists");
        }
    }
}
