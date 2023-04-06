package education.ESchool.business;

import education.ESchool.dataAccess.StudentLessonsRepository;
import education.ESchool.dtos.requests.CreateStudentLessonRequest;
import education.ESchool.dtos.requests.UpdateStudentLessonRequest;
import education.ESchool.dtos.responses.GetAllStudentLessonResponses;
import education.ESchool.dtos.responses.GetByIdStudentLessonResponses;
import education.ESchool.entities.Lesson;
import education.ESchool.entities.Student;
import education.ESchool.entities.StudentLesson;
import education.ESchool.mappers.ModelMapperService;
import education.ESchool.result.DataResult;
import education.ESchool.result.Result;
import education.ESchool.result.SuccessDataResult;
import education.ESchool.result.SuccessResult;
import education.ESchool.rules.StudentLessonBusinessRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentLessonService {

    private final StudentLessonsRepository studentLessonsRepository;

    private final ModelMapperService modelMapperService;

    private final StudentService studentService;

    private final LessonService lessonService;

    private final StudentLessonBusinessRules studentLessonBusinessRules;

    @Autowired
    public StudentLessonService(StudentLessonsRepository studentLessonsRepository, ModelMapperService modelMapperService, StudentService studentService, LessonService lessonService,StudentLessonBusinessRules studentLessonBusinessRules) {
        this.studentLessonsRepository = studentLessonsRepository;
        this.modelMapperService = modelMapperService;
        this.lessonService = lessonService;
        this.studentService = studentService;
        this.studentLessonBusinessRules=studentLessonBusinessRules;
    }

    public DataResult<List<GetAllStudentLessonResponses>> findAll() {
        List<StudentLesson> studentLessons = studentLessonsRepository.findAll();
        List<GetAllStudentLessonResponses> getAllStudentLessonResponses = studentLessons.stream().
                map(studentLesson -> this.modelMapperService.forResponse()
                        .map(studentLesson, GetAllStudentLessonResponses.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllStudentLessonResponses>>(getAllStudentLessonResponses,true,"StudentLesson successfully listed");
    }

    public Result add(CreateStudentLessonRequest createStudentLessonRequest) {
        StudentLesson studentLesson = this.modelMapperService.forRequest().map(createStudentLessonRequest, StudentLesson.class);
        Student student = studentService.getById(createStudentLessonRequest.getStudent_id());
        Lesson lesson = lessonService.findByLessonId(createStudentLessonRequest.getLesson_id());
        studentLesson.setStudent(student);
        studentLesson.setLesson(lesson);
        this.studentLessonsRepository.save(studentLesson);
        return new SuccessResult("StudentLesson successfully added");
    }

    public GetByIdStudentLessonResponses getById(int studentLessonId) {
        StudentLesson studentLesson=studentLessonsRepository.findById(studentLessonId).orElse(null);
        GetByIdStudentLessonResponses getByIdStudentLessonResponses=this.modelMapperService.forResponse().map(studentLesson,GetByIdStudentLessonResponses.class);
        this.studentLessonBusinessRules.existsByGradeAndDiscontinuity(studentLesson.getGrade(),studentLesson.getDiscontinuity());

        return getByIdStudentLessonResponses;

    }

    public void deleteById(int id) {
        studentLessonsRepository.deleteById(id);
    }

    public void update(UpdateStudentLessonRequest updateStudentLessonRequest) throws Exception {
        int point1;
        int point2;

        StudentLesson studentLesson = this.studentLessonsRepository
                .findByStudent_StudentIdAndLesson_LessonId(
                        updateStudentLessonRequest.getStudentId(),
                        updateStudentLessonRequest.getLessonId());

        if (studentLesson == null) {
            throw new Exception();
        }
        point1 = updateStudentLessonRequest.getPoint1() == 0 ? studentLesson.getPoint1() : updateStudentLessonRequest.getPoint1();
        point2 = updateStudentLessonRequest.getPoint2() == 0 ? studentLesson.getPoint2() : updateStudentLessonRequest.getPoint2();

        studentLesson.setPoint1(point1);
        studentLesson.setPoint2(point2);
        studentLesson.setGrade(this.calculateGrade(point1, point2));

        this.studentLessonBusinessRules.existsByPoints(point1,point2);
        this.studentLessonsRepository.save(studentLesson);
    }

    private double calculateGrade(int point1, int point2) {
        return (point1 + point2) / 2.0;
    }



}
