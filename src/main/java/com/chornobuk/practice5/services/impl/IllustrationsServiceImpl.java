package com.chornobuk.practice5.services.impl;

import java.time.LocalDateTime;

import com.chornobuk.practice5.dtos.illustration.IllustrationCreateDTO;
import com.chornobuk.practice5.dtos.illustration.IllustrationUpdateDTO;
import com.chornobuk.practice5.entities.Artist;
import com.chornobuk.practice5.entities.Illustration;
import com.chornobuk.practice5.exceptions.CustomIllegalArgumentException;
import com.chornobuk.practice5.exceptions.EntityNotFoundException;
import com.chornobuk.practice5.services.ArtistsService;
import com.chornobuk.practice5.services.IllustrationsService;

import jakarta.transaction.Transactional;

import com.chornobuk.practice5.repositories.IllustrationsRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IllustrationsServiceImpl implements IllustrationsService {

    private final int illustrationsPerPage;

    private final IllustrationsRepository illustrationsRepository;
    private final ArtistsService artistsService;

    public IllustrationsServiceImpl(IllustrationsRepository illustrationsRepository, ArtistsServiceImpl artistsService,
            @Value("${illustrations.per.page}") int illustrationsPerPage) {
        this.artistsService = artistsService;
        this.illustrationsRepository = illustrationsRepository;
        this.illustrationsPerPage = illustrationsPerPage;
    }

    @Override
    @Transactional
    public Illustration createIllustration(IllustrationCreateDTO illustrationDto) {
        Illustration newIllustration = new Illustration();
        Artist artist = artistsService.getById(illustrationDto.getArtistId());
        newIllustration.setAiGenerated(illustrationDto.getAiGenerated());
        newIllustration.setName(illustrationDto.getName());
        newIllustration.setImageUrl("url");
        newIllustration.setArtist(artist);
        newIllustration.setUpdatedAt(LocalDateTime.now());
        return illustrationsRepository.save(newIllustration);
    }

    @Override
    public void deleteById(Long id) {
        try {
            illustrationsRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("illustration not found");
        }
    }

    @Override
    public Illustration getById(Long id) {
        return illustrationsRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Iterable<Illustration> getPaginatedIllustrations(String name, boolean aiGenerated, int page) {
        if (page < 0) {
            throw new CustomIllegalArgumentException("page cannot be negative");
        }

        Pageable pageable = PageRequest.of(page, illustrationsPerPage);
        Page<Illustration> pageData = illustrationsRepository.findAllByNameContainingAndAiGenerated(name, aiGenerated,
                pageable);
        return pageData.getContent();
    }

    @Override
    public Illustration updateIllustration(IllustrationUpdateDTO illustrationDto) {
        Illustration updatedIllustration = getById(illustrationDto.getId());
        updatedIllustration.setAiGenerated(illustrationDto.getAiGenerated());
        updatedIllustration.setName(illustrationDto.getName());
        updatedIllustration.setUpdatedAt(LocalDateTime.now());
        return illustrationsRepository.save(updatedIllustration);
    }

}
