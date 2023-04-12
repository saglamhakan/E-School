package education.ESchool.rules;

import education.ESchool.dataAccess.LessonRepository;
import education.ESchool.dtos.requests.CreateOneLessonRequest;
import education.ESchool.exception.BusinessException;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LessonBusinessRules {

    private LessonRepository lessonRepository;

    public void existsByLessonId(int lessonId) {
        if (this.lessonRepository.existsByLessonId(lessonId)) {
            throw new BusinessException("LessonId already exists");

        }
    }

    public boolean validateRequest(CreateOneLessonRequest createOneLessonRequest) {
        boolean isSuccess = true;

        if (StringUtils.isEmpty(createOneLessonRequest.getLessonName())) {
            isSuccess = false;

        }
        return isSuccess;
    }
}