package education.ESchool.security;

import education.ESchool.dtos.requests.StudentRequest;
import education.ESchool.entities.Student;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Data
public class JwtUserDetails implements UserDetails {

    Long userId;

    String username;

    String password;

    public Collection<? extends GrantedAuthority> Authorities;

    JwtUserDetails(Long userId, String userName, String password, Collection<? extends GrantedAuthority> authorities){
        this.username=userName;
        this.password=password;
        this.Authorities=authorities;
        this.userId=userId;

    }

    public static JwtUserDetails create(Student student) {
        List<GrantedAuthority> authoriesList = new ArrayList<>();
        authoriesList.add(new SimpleGrantedAuthority("user"));
        return new JwtUserDetails((long) student.getStudentId(), student.getStudentName(), student.getStudentNumber(), authoriesList);

    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
