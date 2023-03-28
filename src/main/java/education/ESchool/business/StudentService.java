package education.ESchool.business;

import education.ESchool.dataAccess.StudentRepository;
import education.ESchool.dtos.requests.CreateOneStudentRequest;
import education.ESchool.dtos.responses.GetAllStudentsResponse;
import education.ESchool.entities.Student;
import education.ESchool.mappers.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class StudentService {

    private StudentRepository studentRepository;
    private ModelMapperService modelMapperService;

    @Autowired
    public StudentService(StudentRepository studentRepository, ModelMapperService modelMapperService){
        this.studentRepository=studentRepository;
        this.modelMapperService=modelMapperService;
    }

    public List<GetAllStudentsResponse> findAll() {

        List<Student> students=studentRepository.findAll();
        List<GetAllStudentsResponse> getAllStudentsResponses=students.stream().map(student -> this.modelMapperService.forResponse()
                .map(student, GetAllStudentsResponse.class)).collect(Collectors.toList());

        return getAllStudentsResponses;

    }

    public Student add(CreateOneStudentRequest createOneStudentRequest) {
        Student student=this.modelMapperService.forRequest().map(createOneStudentRequest,Student.class);
        return this.studentRepository.save(student);
    }

/*
    public Student getByStudentId(int studentId) {
       return this.studentRepository.getByStudent_StudentId(studentId);
    }

 */


    public void deleteById(int studentId) {
        this.studentRepository.deleteById(studentId);
    }
}
