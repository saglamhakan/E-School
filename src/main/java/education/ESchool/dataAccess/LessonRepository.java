package education.ESchool.dataAccess;

import education.ESchool.dtos.requests.UpdateLessonRequest;
import education.ESchool.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Integer> {


    Lesson findByLessonId(int lessonId);

    boolean existsByLessonId(int lessonId);





    //   List<Lesson> findByStudent_StudentId(int studentId);

}
