package education.ESchool.dataAccess;

import education.ESchool.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Integer> {


   // Lesson getByStudent_StudentId(int studentId);

    List<Lesson> findByStudent_StudentId(int studentId);
}
