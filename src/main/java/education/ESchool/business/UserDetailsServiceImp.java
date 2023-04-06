package education.ESchool.business;

import education.ESchool.dataAccess.StudentRepository;
import education.ESchool.security.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    private final StudentRepository userRepository;

    @Autowired
    public UserDetailsServiceImp(StudentRepository userRepository){
        this.userRepository=userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String studentName) throws UsernameNotFoundException {
        User user=userRepository.findByStudentName(studentName);
        return JwtUserDetails.create(user);
    }


    public UserDetails loadUserById(int id) {
        return null;
    }
}
