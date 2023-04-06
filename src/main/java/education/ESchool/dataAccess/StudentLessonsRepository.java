package education.ESchool.dataAccess;

import education.ESchool.entities.StudentLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentLessonsRepository extends JpaRepository<StudentLesson, Integer> {

    StudentLesson findByStudent_StudentIdAndLesson_LessonId(int studentId, int lessonId);

}