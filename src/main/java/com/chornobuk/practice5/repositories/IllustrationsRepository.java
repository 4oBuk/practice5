package com.chornobuk.practice5.repositories;

import com.chornobuk.practice5.entities.Illustration;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IllustrationsRepository extends JpaRepository<Illustration, Long> {
    Page<Illustration> findAllByNameContainingAndAiGenerated(String name, Boolean aiGenerated, Pageable pageable);
}
