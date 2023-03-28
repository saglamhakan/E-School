package education.ESchool.dataAccess;

import education.ESchool.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
   // Student getByStudent_StudentId(int studentId);
}
