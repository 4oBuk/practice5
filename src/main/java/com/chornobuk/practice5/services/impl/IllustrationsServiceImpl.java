package com.chornobuk.practice5.services.impl;

import java.time.LocalDateTime;

import com.chornobuk.practice5.entities.Illustration;
import com.chornobuk.practice5.services.IllustrationsService;
import com.chornobuk.practice5.repositories.IllustrationsRepository;


import org.springframework.stereotype.Service;

@Service
public class IllustrationsServiceImpl implements IllustrationsService {

    private IllustrationsRepository illustrationsRepository;

    public IllustrationsServiceImpl(IllustrationsRepository illustrationsRepository) {
       this.illustrationsRepository = illustrationsRepository;
    }

    @Override
    public Illustration createIllustration(Illustration illustration) {
        illustration.setCreatedAt(LocalDateTime.now());
        return illustrationsRepository.save(illustration);
    }

    @Override
    public void deleteById(Long id) {
       illustrationsRepository.deleteById(id);
    }

    @Override
    public Illustration getById(Long id) {
        return illustrationsRepository.findById(id).get();
    }

    @Override
    public Iterable<Illustration> getPaginatedIllustrations(String artist, String name, int page) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Illustration updateIllustration(Illustration illustration) {
        return illustrationsRepository.save(illustration);
    }

}
