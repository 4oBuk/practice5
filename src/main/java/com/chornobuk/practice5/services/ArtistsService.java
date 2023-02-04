package com.chornobuk.practice5.services;

import com.chornobuk.practice5.entities.Artist;

public interface ArtistsService {
    Iterable<Artist> getAllArtists();
    Artist getById(Long id);
}
