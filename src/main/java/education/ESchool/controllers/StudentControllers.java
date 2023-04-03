package education.ESchool.controllers;

import education.ESchool.business.StudentService;
import education.ESchool.dtos.requests.CreateOneStudentRequest;
import education.ESchool.dtos.responses.GetAllStudentsResponse;
import education.ESchool.entities.Student;
import education.ESchool.result.DataResult;
import education.ESchool.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentControllers {

    private StudentService studentService;

    @GetMapping("/getAll")
    public DataResult<List<GetAllStudentsResponse>> getAll(){
        return this.studentService.findAll();
    }

    @PostMapping("/add")
    public Result createStudent(@RequestBody CreateOneStudentRequest createOneStudentRequest){
        return this.studentService.add(createOneStudentRequest);
    }

    @DeleteMapping("/{studentId}")
    public void deleteById(@PathVariable int studentId){
        this.studentService.deleteById(studentId);
    }

}
