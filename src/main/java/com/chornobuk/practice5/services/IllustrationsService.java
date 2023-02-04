package com.chornobuk.practice5.services;

import com.chornobuk.practice5.dtos.illustration.IllustrationCreateDTO;
import com.chornobuk.practice5.dtos.illustration.IllustrationUpdateDTO;
import com.chornobuk.practice5.entities.Illustration;

public interface IllustrationsService {
    public Illustration getById(Long id);

    public void deleteById(Long id);

    public Illustration updateIllustration(IllustrationUpdateDTO illustration);

    public Illustration createIllustration(IllustrationCreateDTO illustration);

    public Iterable<Illustration> getPaginatedIllustrations(String name, boolean aiGenerated, int page);
}
