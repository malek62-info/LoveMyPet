package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Advice;
import com.nanterre.LoveMyPet.repository.AdviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdviceServiceImpl implements AdviceService {

    @Autowired
    private AdviceRepository adviceRepository;

    @Override
    public void addAdvice(Advice advice) {
        adviceRepository.save(advice);
    }
}
