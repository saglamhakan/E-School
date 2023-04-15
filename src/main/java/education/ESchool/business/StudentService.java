package education.ESchool.business;

import education.ESchool.dataAccess.StudentRepository;
import education.ESchool.dtos.requests.CreateOneStudentRequest;
import education.ESchool.dtos.requests.StudentRequest;
import education.ESchool.dtos.requests.UpdateOneStudentRequest;
import education.ESchool.dtos.responses.GetAllStudentsResponse;
import education.ESchool.dtos.responses.GetByIdStudentsResponse;
import education.ESchool.entities.Student;
import education.ESchool.exception.BusinessException;
import education.ESchool.mappers.ModelMapperService;
import education.ESchool.result.*;
import education.ESchool.rules.StudentBusinessRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service

public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapperService modelMapperService;

    private final StudentBusinessRules studentBusinessRules;

    @Autowired
    public StudentService(StudentRepository studentRepository, ModelMapperService modelMapperService, StudentBusinessRules studentBusinessRules){
        this.studentRepository=studentRepository;
        this.modelMapperService=modelMapperService;
        this.studentBusinessRules=studentBusinessRules;
    }

    public Student getOneStudentByStudentName(String studentName) {
        Student student = studentRepository.findByStudentName(studentName);
        if (student!=null){
            return student;
        }else{
            throw new BusinessException("Student not found");
        }
    }

    public DataResult<List<GetAllStudentsResponse>> findAll() {

        List<Student> students=studentRepository.findAll();
        List<GetAllStudentsResponse> getAllStudentsResponses=students.stream().map(student -> this.modelMapperService.forResponse()
                .map(student, GetAllStudentsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllStudentsResponse>>
                (getAllStudentsResponses,true,"Students successfully listed");

    }

    public Student getStudentById(int studentId){
        Student student =this.studentRepository.findById(studentId).orElse(null);
        if (Objects.nonNull(student)){
            return student;
        }
       throw new  BusinessException("Student not found");

    }

    public  DataResult<Student> add(CreateOneStudentRequest createOneStudentRequest) {
        Student student=new Student();
        if (this.studentBusinessRules.validateRequest(createOneStudentRequest)) {
            student = this.modelMapperService.forRequest().map(createOneStudentRequest, Student.class);
            this.studentBusinessRules.existsByStudentNumber(createOneStudentRequest.getStudentNumber());
            this.studentRepository.save(student);
            return new SuccessDataResult<Student>(student,true,"Student successfully added");
        }
            return new ErrorDataResult<Student>(student,"Student could not added");
    }

    public void deleteById(int studentId) {
        this.studentRepository.deleteById(studentId);
    }


    public Student updateOneUser(int studentId, UpdateOneStudentRequest updateOneStudentRequest) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (Objects.nonNull(student)) {
            student.setStudentName(updateOneStudentRequest.getStudentName());
            studentRepository.save(student);
            return student;
        } else {
            throw new BusinessException("User could not found");
        }
    }
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
