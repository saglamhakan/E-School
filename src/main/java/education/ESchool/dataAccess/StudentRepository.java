package education.ESchool.dataAccess;


import education.ESchool.dtos.requests.CreateOneStudentRequest;
import education.ESchool.dtos.requests.UpdateLessonRequest;
import education.ESchool.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    boolean existsByStudentNumber(String studentNumber);

    Student findByStudentName(String studentName);



}
