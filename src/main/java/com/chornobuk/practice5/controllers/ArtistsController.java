package com.chornobuk.practice5.controllers;

import com.chornobuk.practice5.entities.Artist;
import com.chornobuk.practice5.services.ArtistsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("artists")
public class ArtistsController {

    private final ArtistsService artistsService;

    @GetMapping
    public Iterable<Artist> getAllArtists() {
        return artistsService.getAllArtists();
    }
}
