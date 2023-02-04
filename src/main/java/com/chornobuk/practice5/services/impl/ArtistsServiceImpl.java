package com.chornobuk.practice5.services.impl;

import com.chornobuk.practice5.entities.Artist;
import com.chornobuk.practice5.exceptions.EntityNotFoundException;
import com.chornobuk.practice5.repositories.ArtistsRepository;
import com.chornobuk.practice5.services.ArtistsService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArtistsServiceImpl implements ArtistsService {

    private final ArtistsRepository artistsRepository;

    @Override
    public Iterable<Artist> getAllArtists() {
        return artistsRepository.findAll();
    }

    @Override
    public Artist getById(Long id) {
        return artistsRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

}
