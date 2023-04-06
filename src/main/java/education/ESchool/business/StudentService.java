package education.ESchool.business;

import education.ESchool.dataAccess.StudentRepository;
import education.ESchool.dtos.requests.CreateOneStudentRequest;
import education.ESchool.dtos.responses.GetAllStudentsResponse;
import education.ESchool.entities.Student;
import education.ESchool.mappers.ModelMapperService;
import education.ESchool.result.*;
import education.ESchool.rules.StudentBusinessRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
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

    public DataResult<List<GetAllStudentsResponse>> findAll() {

        List<Student> students=studentRepository.findAll();
        List<GetAllStudentsResponse> getAllStudentsResponses=students.stream().map(student -> this.modelMapperService.forResponse()
                .map(student, GetAllStudentsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllStudentsResponse>>
                (getAllStudentsResponses,true,"Students successfully listed");

    }

    public Student getById(int studentId){
        return this.studentRepository.findById(studentId).orElse(null);
    }

    public Result add(CreateOneStudentRequest createOneStudentRequest) {
        if (this.validateRequest(createOneStudentRequest)){
            Student student=this.modelMapperService.forRequest().map(createOneStudentRequest,Student.class);
            this.studentBusinessRules.existsByStudentNumber(createOneStudentRequest.getStudentNumber());
            return new SuccessResult("Student successfully added");
        }else
            return new ErrorResult(false,"Student could not added");

    }


    public void deleteById(int studentId) {
        this.studentRepository.deleteById(studentId);
    }

    private boolean validateRequest(CreateOneStudentRequest createOneStudentRequest) {
        boolean isSuccess = true;

        if (StringUtils.isEmpty(createOneStudentRequest.getStudentName())) {
            isSuccess = false;

        }
        return isSuccess;
    }
}
