package com.dvfu.digital_platform_core.service;

import com.dvfu.digital_platform_core.dao.EntryPoint;

public interface EntryPointService {

    EntryPoint insert(EntryPoint entryPoint);

    void delete(Long id);

}
