package com.fawry.movie.service;

import com.fawry.movie.model.User;
import com.fawry.movie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String userame) throws UsernameNotFoundException {
        logger.debug("Loading user by userame: {}", userame);

        User user = userRepository.findByUsername(userame);

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername()) // email is the username
                .password(user.getPassword()) // phone is the password
                .roles(user.getRole().name())
                .build();

    }
}
