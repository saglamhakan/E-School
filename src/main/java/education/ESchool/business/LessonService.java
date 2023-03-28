package education.ESchool.business;

import education.ESchool.dataAccess.LessonRepository;
import education.ESchool.dtos.requests.CreateOneLessonRequest;
import education.ESchool.dtos.responses.GetAllLessonsResponse;
import education.ESchool.dtos.responses.GetByIdStudentsResponse;
import education.ESchool.entities.Lesson;
import education.ESchool.mappers.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class LessonService {

    private LessonRepository lessonRepository;

    private ModelMapperService modelMapperService;

    @Autowired
    public LessonService(LessonRepository lessonRepository, ModelMapperService modelMapperService){
        this.lessonRepository=lessonRepository;
        this.modelMapperService=modelMapperService;
    }

    public List<GetAllLessonsResponse> getAll( ) {

        List<Lesson> lessons=lessonRepository.findAll();
        List<GetAllLessonsResponse> getAllLessonsResponses=lessons.stream().map(lesson -> this.modelMapperService.forResponse()
                .map(lesson, GetAllLessonsResponse.class)).collect(Collectors.toList());
       return getAllLessonsResponses;
    }

    public Lesson saveOneLesson(CreateOneLessonRequest createOneLessonRequest) {

        Lesson lesson=this.modelMapperService.forRequest().map(createOneLessonRequest, Lesson.class);

        return lessonRepository.save(lesson);
    }

    public List<GetByIdStudentsResponse> getByStudentId(int studentId) {
        List<Lesson> lessons=lessonRepository.findByStudent_StudentId(studentId);

        List<GetByIdStudentsResponse> getByIdStudentsResponses=lessons.stream().map(lesson -> this.modelMapperService.forResponse()
                .map(lesson, GetByIdStudentsResponse.class)).collect(Collectors.toList());
        return getByIdStudentsResponses;
    }


    public void deleteById(int lessonId) {
        this.lessonRepository.deleteById(lessonId);
    }

}
