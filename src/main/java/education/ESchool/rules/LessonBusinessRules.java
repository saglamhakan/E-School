package education.ESchool.rules;

import education.ESchool.dataAccess.LessonRepository;
import education.ESchool.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LessonBusinessRules {

    private LessonRepository lessonRepository;

    public void existsByLessonId(int lessonId) {
        if (this.lessonRepository.existsByLessonId(lessonId)){
            throw new BusinessException("LessonId already exists");

        }
    }
}
