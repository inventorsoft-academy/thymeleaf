package com.thymeleaf.course.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import java.util.Arrays;
import java.util.Collection;


@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private long id;

    @Column(length = 40, nullable = false)
    private String email;

    @Column(length = 128, nullable = false)
    private String password;

    @Column(length = 24, nullable = false)
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email;
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
