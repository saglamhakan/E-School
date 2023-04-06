package education.ESchool.security;

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

    private JwtUserDetails(String userName, String password, Collection<? extends GrantedAuthority> authorities){
        this.username=userName;
        this.password=password;
        this.Authorities=authorities;

    }

    public static JwtUserDetails create(User user) {
        List<GrantedAuthority> authoriesList = new ArrayList<>();
        authoriesList.add(new SimpleGrantedAuthority("user"));
        return new JwtUserDetails(user.getUsername(), user.getPassword(), authoriesList);

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
