package education.ESchool.controllers;

import education.ESchool.business.StudentService;
import education.ESchool.dtos.requests.CreateOneStudentRequest;
import education.ESchool.dtos.requests.UpdateOneStudentRequest;
import education.ESchool.dtos.responses.GetAllStudentsResponse;
import education.ESchool.dtos.responses.GetByIdStudentsResponse;
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

    @GetMapping("/studentName")
    public Student getOneStudentByStudentName(String studentName) {
        return studentService.getOneStudentByStudentName(studentName);
    }

    @GetMapping("/{studentId}")
    public Student getUserById(@PathVariable int studentId){
        return this.studentService.getStudentById(studentId);
    }

    @PutMapping("/{studentId}")
    public Student updateOneStudent(@PathVariable int studentId, UpdateOneStudentRequest updateOneStudentRequest){
        return this.studentService.updateOneUser(studentId,updateOneStudentRequest);
    }
}
