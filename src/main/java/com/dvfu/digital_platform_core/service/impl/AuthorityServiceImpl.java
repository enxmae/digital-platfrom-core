package com.dvfu.digital_platform_core.service.impl;

import com.dvfu.digital_platform_core.dao.Authority;
import com.dvfu.digital_platform_core.constants.UserRoleName;
import com.dvfu.digital_platform_core.repository.AuthorityRepository;
import com.dvfu.digital_platform_core.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public List<Authority> findById(Long id) {
        Authority auth = this.authorityRepository.getOne(id);
        List<Authority> auths = new ArrayList<>();
        auths.add(auth);
        return auths;
    }

    @Override
    public List<Authority> findByAuthority(UserRoleName name) {
        Authority auth = this.authorityRepository.findByAuthority(name);
        List<Authority> auths = new ArrayList<>();
        auths.add(auth);
        return auths;
    }

}
