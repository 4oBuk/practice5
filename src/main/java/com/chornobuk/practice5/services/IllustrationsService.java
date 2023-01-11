package com.chornobuk.practice5.services;

import com.chornobuk.practice5.entities.Illustration;

public interface IllustrationsService {
    public Illustration getById(Long id);

    public void deleteById(Long id);

    public Illustration updateIllustration(Illustration illustration);

    public Illustration createIllustration(Illustration illustration);

    public Iterable<Illustration> getPaginatedIllustrations(String artist, String name, int page);
}
