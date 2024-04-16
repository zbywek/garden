package pl.infomind.garden.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Data
@Entity
@Table(name="users")
public class User implements UserDetails {

    @Id
    private String username;

    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private List<Authority> authorities;

    private boolean isAccountNonExpired;

    private boolean isCredentialsNonExpired;

    private boolean isAccountNonLocked;

    private boolean isEnabled;
}
