package education.ESchool.rules;

import education.ESchool.dataAccess.StudentLessonsRepository;


import education.ESchool.exception.BusinessException;
import education.ESchool.result.ErrorResult;
import education.ESchool.result.Result;
import education.ESchool.result.SuccessResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class StudentLessonBusinessRules {

    private StudentLessonsRepository studentLessonsRepository;

    public void existsByGradeAndDiscontinuity(double grade, int discontinuity) {
        if (grade < 60.0 || discontinuity>10) {
            throw  new BusinessException("You did not pass the lesson");
        }else
            throw  new BusinessException("You passed the lesson");

    }

    public void existsByPoints(int points1, int points2){
        if (points1 >100 || points2>100){
            throw new BusinessException("The entered grade cannot be greater than 100");

        }
    }


}
