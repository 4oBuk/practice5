package com.chornobuk.practice5.controllers;

import com.chornobuk.practice5.entities.Artist;
import com.chornobuk.practice5.services.ArtistsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("artists")
public class ArtistsController {

    private final ArtistsService artistsService;

    public ArtistsController(ArtistsService artistsService) {
        this.artistsService = artistsService;
    }

    @GetMapping
    public Iterable<Artist> getAllArtists() {
        return artistsService.getAllArtists();
    }
}
