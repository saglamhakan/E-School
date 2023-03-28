package education.ESchool.controllers;

import education.ESchool.business.StudentService;
import education.ESchool.dtos.requests.CreateOneStudentRequest;
import education.ESchool.dtos.responses.GetAllStudentsResponse;
import education.ESchool.entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentControllers {

    private StudentService studentService;

    @GetMapping("/getAll")
    public List<GetAllStudentsResponse> getAll(){
        return this.studentService.findAll();
    }

    @PostMapping("/add")
    public Student createStudent(@RequestBody CreateOneStudentRequest createOneStudentRequest){
        return this.studentService.add(createOneStudentRequest);
    }
/*
    @GetMapping("/{studentId}")
    public Student getByStudentId(@PathVariable int studentId) {
      return this.studentService.getByStudentId(studentId);
    }

 */

    @DeleteMapping("/{studentId}")
    public void deleteById(@PathVariable int studentId){
        this.studentService.deleteById(studentId);
    }

}
