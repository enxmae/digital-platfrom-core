package com.dvfu.digital_platform_core.service;

import com.dvfu.digital_platform_core.dao.User;
import com.dvfu.digital_platform_core.dao.UserRequest;

import java.util.List;

public interface UserService {

    public void resetCredentials();

    public User findById(Long id);

    public User findByUsername(String username);

    public List<User> findAll();

    public User save(UserRequest user);
}
