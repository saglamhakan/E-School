package education.ESchool.controllers;

import education.ESchool.business.LessonService;
import education.ESchool.dtos.requests.CreateOneLessonRequest;
import education.ESchool.dtos.requests.UpdateLessonRequest;
import education.ESchool.dtos.responses.GetAllLessonsResponse;
import education.ESchool.entities.Lesson;
import education.ESchool.result.DataResult;
import education.ESchool.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
@AllArgsConstructor
public class LessonControllers {

    private LessonService lessonService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllLessonsResponse>> getAll(){
        return this.lessonService.getAll();
    }
    @PostMapping("/add")
    public Result createLesson(@RequestBody CreateOneLessonRequest createOneLessonRequest){
       return this.lessonService.saveOneLesson(createOneLessonRequest);
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam int lessonId){
        this.lessonService.deleteById(lessonId);
    }

    @PutMapping("/{lessonId}")
    public Lesson update(@PathVariable int lessonId, @RequestBody UpdateLessonRequest updateLessonRequest){
       return this.lessonService.update(lessonId,updateLessonRequest);
    }


}
