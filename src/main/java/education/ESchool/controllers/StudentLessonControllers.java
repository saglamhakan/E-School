package education.ESchool.controllers;

import education.ESchool.business.StudentLessonService;
import education.ESchool.dtos.requests.CreateStudentLessonRequest;
import education.ESchool.dtos.requests.UpdateStudentLessonRequest;
import education.ESchool.dtos.responses.GetAllStudentLessonResponses;
import education.ESchool.dtos.responses.GetByIdStudentLessonResponses;
import education.ESchool.entities.StudentLesson;
import education.ESchool.result.DataResult;
import education.ESchool.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/lesson")
@AllArgsConstructor
public class StudentLessonControllers {

    private StudentLessonService studentLessonService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllStudentLessonResponses>> getAll(){
        return studentLessonService.findAll();
    }

    @PostMapping("/add")
    public Result createStudentLesson(@RequestBody CreateStudentLessonRequest createStudentLessonRequest){
        return studentLessonService.add(createStudentLessonRequest);
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam int id){
        studentLessonService.deleteById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateStudentLessonRequest updateStudentLessonRequest) throws Exception {
        this.studentLessonService.update(updateStudentLessonRequest);
    }

    @GetMapping("/passedNotPassed")
    public GetByIdStudentLessonResponses getById(@RequestParam int studentLessonId) {
        return this.studentLessonService.getById(studentLessonId);
    }
}
