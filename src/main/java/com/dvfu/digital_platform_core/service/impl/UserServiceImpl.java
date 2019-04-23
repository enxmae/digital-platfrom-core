package com.dvfu.digital_platform_core.service.impl;

import com.dvfu.digital_platform_core.dao.Authority;
import com.dvfu.digital_platform_core.dao.User;
import com.dvfu.digital_platform_core.dao.UserRequest;
import com.dvfu.digital_platform_core.constants.UserRoleName;
import com.dvfu.digital_platform_core.repository.UserRepository;
import com.dvfu.digital_platform_core.service.AuthorityService;
import com.dvfu.digital_platform_core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.access.AccessDeniedException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authService;

    @Override
    public void resetCredentials() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.setPassword(passwordEncoder.encode("123"));
            userRepository.save(user);
        }
    }

    @Override
    // @PreAuthorize("hasRole('USER')")
    public User findByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByUsername(username);
        return u;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public User findById(Long id) throws AccessDeniedException {
        User u = userRepository.getOne(id);
        return u;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public List<User> findAll() throws AccessDeniedException {
        List<User> result = userRepository.findAll();
        return result;
    }

    @Override
    public User save(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setFirstname(userRequest.getFirstname());
        user.setLastname(userRequest.getLastname());
        List<Authority> auth = authService.findByAuthority(UserRoleName.ROLE_SPNA);
        user.setAuthorities(auth);
        this.userRepository.save(user);
        return user;
    }

}
