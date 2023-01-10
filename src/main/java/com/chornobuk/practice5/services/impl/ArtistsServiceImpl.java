package com.chornobuk.practice5.services.impl;

import com.chornobuk.practice5.entities.Artist;
import com.chornobuk.practice5.repositories.ArtistsRepository;
import com.chornobuk.practice5.services.ArtistsService;

import org.springframework.stereotype.Service;

@Service
public class ArtistsServiceImpl implements ArtistsService {

    private ArtistsRepository artistsRepository;

    public ArtistsServiceImpl(ArtistsRepository artistsRepository) {
        this.artistsRepository = artistsRepository;
    }
    @Override
    public Iterable<Artist> getAllArtists() {
        return artistsRepository.findAll();
    }
}
