package com.chornobuk.practice5.controllers;

import com.chornobuk.practice5.entities.Artist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("artists")
public class ArtistsController {

    @GetMapping
    public Artist getAllArtistById() {
        // TODO
        return null;
    }
}
