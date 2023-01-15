package com.chornobuk.practice5.services.impl;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import com.chornobuk.practice5.entities.Illustration;
import com.chornobuk.practice5.services.IllustrationsService;

import jakarta.persistence.EntityNotFoundException;

import com.chornobuk.practice5.repositories.IllustrationsRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IllustrationsServiceImpl implements IllustrationsService {

    private final int illustrationsPerPage;

    private final IllustrationsRepository illustrationsRepository;

    public IllustrationsServiceImpl(IllustrationsRepository illustrationsRepository,
            @Value("${illustrations.per.page}") int illustrationsPerPage) {
        this.illustrationsRepository = illustrationsRepository;
        this.illustrationsPerPage = illustrationsPerPage;
    }

    @Override
    public Illustration createIllustration(Illustration illustration) {
        illustration.setUpdatedAt(LocalDateTime.now());
        illustration.setImageUrl("url");
        illustration.setId(null);// to prevent overriding existed entities
        return illustrationsRepository.save(illustration);
    }

    @Override
    public void deleteById(Long id) {
        illustrationsRepository.deleteById(id);
    }

    @Override
    public Illustration getById(Long id) {
        try {
            return illustrationsRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException("illustration not found");
        }
    }

    @Override
    public Iterable<Illustration> getPaginatedIllustrations(String name, boolean aiGenerated, int page) {
        Pageable pageable = PageRequest.of(page, illustrationsPerPage);
        Page<Illustration> pageData = illustrationsRepository.findAllByNameContainingAndAiGenerated(name, aiGenerated,
                pageable);
        return pageData.getContent();
    }

    @Override
    public Illustration updateIllustration(Illustration illustration) {
        illustration.setUpdatedAt(LocalDateTime.now());
        return illustrationsRepository.saveAndFlush(illustration);
    }

}
