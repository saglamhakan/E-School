package education.ESchool.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lesson_id")
    private int lessonId;

    private String lessonName;

    private double lessonPoints;

    private String studentName;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


}
