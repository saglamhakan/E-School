package education.ESchool.controllers;

import education.ESchool.business.LessonService;
import education.ESchool.dtos.requests.CreateOneLessonRequest;
import education.ESchool.dtos.responses.GetAllLessonsResponse;
import education.ESchool.dtos.responses.GetByIdStudentsResponse;
import education.ESchool.entities.Lesson;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lesson")
@AllArgsConstructor
public class LessonControllers {

    private LessonService lessonService;

    @GetMapping("/getAll")
    public List<GetAllLessonsResponse> getAll(){
        return this.lessonService.getAll();
    }
    @PostMapping("/add")
    public Lesson createLesson(@RequestBody CreateOneLessonRequest createOneLessonRequest){
       return this.lessonService.saveOneLesson(createOneLessonRequest);
    }

    @GetMapping("/{studentId}")
    public List<GetByIdStudentsResponse> getByStudentId(@PathVariable int studentId){
        return this.lessonService.getByStudentId(studentId);
    }



    @DeleteMapping("/delete")
    public void deleteById(@RequestParam int lessonId){
        this.lessonService.deleteById(lessonId);
    }

}
