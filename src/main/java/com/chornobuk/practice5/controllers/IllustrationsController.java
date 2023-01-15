package com.chornobuk.practice5.controllers;

import com.chornobuk.practice5.entities.Illustration;
import com.chornobuk.practice5.services.IllustrationsService;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("illustrations")
public class IllustrationsController {

    private final IllustrationsService illustrationsService;

    @GetMapping("/{id}")
    public Illustration getIllustrationById(@PathVariable Long id) {
        return illustrationsService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Illustration createIllustration(@RequestBody @Valid Illustration illustration) {
        return illustrationsService.createIllustration(illustration);
    }

    @PutMapping
    public Illustration updateIllustration(@RequestBody @Valid Illustration illustration) {
        return illustrationsService.updateIllustration(illustration);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteIllustrationById(@PathVariable Long id) {
        illustrationsService.deleteById(id);
    }

    @GetMapping
    public Iterable<Illustration> getPaginatedIllustrations(@RequestParam String name,
            @RequestParam boolean aiGenerated, @RequestParam Integer page) {
            
        return illustrationsService.getPaginatedIllustrations(name, aiGenerated, page);
    }
}
