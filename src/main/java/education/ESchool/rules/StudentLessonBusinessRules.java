package education.ESchool.rules;

import education.ESchool.dataAccess.StudentLessonsRepository;


import education.ESchool.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class StudentLessonBusinessRules {

    private StudentLessonsRepository studentLessonsRepository;

    public void existsByGrade(double grade) {
        if (grade < 60.0) {
            throw new BusinessException("You did not pass the lesson");
        }else
            throw new BusinessException("You passed the exam");

    }
}
