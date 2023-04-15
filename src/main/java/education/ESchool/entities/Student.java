package education.ESchool.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;
    
    private String studentName;
    
    private String studentNumber;

    private String password;

    @ManyToMany(mappedBy = "students")
    private List<Lesson> lessons=new ArrayList<>();



}
