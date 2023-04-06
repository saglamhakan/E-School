package education.ESchool.dataAccess;

import education.ESchool.dtos.requests.StudentRequest;
import education.ESchool.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    boolean existsByStudentNumber(int studentNumber);

    User findByStudentName(String studentName);

    static Student getOneStudentByStudentName(String studentName) {
        return null;
    }


}
