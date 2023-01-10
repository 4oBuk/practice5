package com.chornobuk.practice5.controllers;

import com.chornobuk.practice5.entities.Illustration;
import com.chornobuk.practice5.services.IllustrationsService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("illustration")
public class IllustrationsController {

    private IllustrationsService illustrationsService;

    public IllustrationsController(IllustrationsService illustrationsService) {
        this.illustrationsService = illustrationsService;
    }

    @GetMapping("/{id}")
    public Illustration getIllustrationById(@PathVariable Long id) {
        // TODO
        return null;
    }

    @PostMapping
    public Illustration createNewIllustration(@RequestBody Illustration illustration) {
        // TODO
        return null;
    }

    @PutMapping
    public Illustration updateIllustration(@RequestBody Illustration illustration) {
        // TODO
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteIllustrationById(@PathVariable Long id) {
        // TODO
        return null;
    }

    @GetMapping
    public Iterable<Illustration> getPaginatedIllustrations(@RequestParam String artist, @RequestParam String name,
            @RequestParam int page) {
        // TODO
        return null;
    }
}
