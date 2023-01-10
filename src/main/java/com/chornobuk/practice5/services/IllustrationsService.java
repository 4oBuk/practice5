package com.chornobuk.practice5.services;

import com.chornobuk.practice5.entities.Illustration;

public interface IllustrationsService {
    public Illustration getById(Long id);

    public void deleteById(Long id);

    public Illustration updateIllustration();

    public Illustration createIllustration();

    public Iterable<Illustration> getPaginatedIllustrations(String artist, String name, int page);
}
