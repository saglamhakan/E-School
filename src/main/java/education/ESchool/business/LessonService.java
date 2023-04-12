package education.ESchool.business;

import education.ESchool.dataAccess.LessonRepository;
import education.ESchool.dtos.requests.CreateOneLessonRequest;
import education.ESchool.dtos.requests.UpdateLessonRequest;
import education.ESchool.dtos.responses.GetAllLessonsResponse;
import education.ESchool.entities.Lesson;
import education.ESchool.mappers.ModelMapperService;
import education.ESchool.result.*;
import education.ESchool.rules.LessonBusinessRules;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    private final ModelMapperService modelMapperService;

    private final LessonBusinessRules lessonBusinessRules;

    @Autowired
    public LessonService(LessonRepository lessonRepository, ModelMapperService modelMapperService, LessonBusinessRules lessonBusinessRules) {
        this.lessonRepository = lessonRepository;
        this.modelMapperService = modelMapperService;
        this.lessonBusinessRules = lessonBusinessRules;
    }

    public DataResult<List<GetAllLessonsResponse>> getAll() {

        List<Lesson> lessons = lessonRepository.findAll();
        List<GetAllLessonsResponse> getAllLessonsResponses = lessons.stream().map(lesson -> this.modelMapperService.forResponse()
                .map(lesson, GetAllLessonsResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllLessonsResponse>>
                (getAllLessonsResponses, true, "Lessons successfully listed");
    }

    public Result saveOneLesson(CreateOneLessonRequest createOneLessonRequest) {
        if (this.lessonBusinessRules.validateRequest(createOneLessonRequest)) {
            Lesson lesson = this.modelMapperService.forRequest().map(createOneLessonRequest, Lesson.class);
            this.lessonBusinessRules.existsByLessonId(lesson.getLessonId());
            lessonRepository.save(lesson);

            return new SuccessResult("Lesson successfully added");
        } else
            return new ErrorResult("Lesson could not be added");

    }

    public Lesson findByLessonId(int lessonId) {
        return lessonRepository.findByLessonId(lessonId);

    }


    public void deleteById(int lessonId) {
        this.lessonRepository.deleteById(lessonId);
    }

    public Lesson update( UpdateLessonRequest updateLessonRequest) {
        Lesson lesson = this.modelMapperService.forRequest().map(updateLessonRequest, Lesson.class);
        return this.lessonRepository.save(lesson);
    }


    }



