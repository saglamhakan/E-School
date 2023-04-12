package education.ESchool.business;

import education.ESchool.dataAccess.StudentRepository;
import education.ESchool.entities.Student;
import education.ESchool.security.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentDetailsService implements UserDetailsService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentDetailsService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String studentName) throws UsernameNotFoundException {
        Student student=studentRepository.findByStudentName(studentName);
        return JwtUserDetails.create(student);
    }


    public UserDetails loadUserById(int studentId) {
        Student student = studentRepository.findById(((studentId))).orElseThrow(() ->
                new UsernameNotFoundException("User not found with id : " + studentId));
        return JwtUserDetails.create(student);
    }
}
