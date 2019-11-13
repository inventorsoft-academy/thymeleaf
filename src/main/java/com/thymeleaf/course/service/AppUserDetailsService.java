package com.thymeleaf.course.service;

import com.thymeleaf.course.dao.SignInUpDao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class AppUserDetailsService implements UserDetailsService {

    private SignInUpDao signInUpDao;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return signInUpDao.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with username " + userEmail));
    }
}
