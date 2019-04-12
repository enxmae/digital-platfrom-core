package com.dvfu.digital_platform_core.service.impl;

import com.dvfu.digital_platform_core.dao.EntryPoint;
import com.dvfu.digital_platform_core.repository.EntryPointRepository;
import com.dvfu.digital_platform_core.service.EntryPointService;
import org.springframework.stereotype.Service;

@Service
public class EntryPointServiceImpl implements EntryPointService {

    private static EntryPointRepository entryPointRepository;

    public EntryPointServiceImpl(EntryPointRepository entryPointRepository) {
        this.entryPointRepository = entryPointRepository;
    }

    @Override
    public EntryPoint insert(EntryPoint entryPoint) {
        return entryPointRepository.save(entryPoint);
    }

    @Override
    public void delete(Long id) {
        entryPointRepository.deleteById(id);
    }
}

