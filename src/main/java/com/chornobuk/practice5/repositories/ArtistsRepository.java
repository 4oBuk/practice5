package com.chornobuk.practice5.repositories;

import com.chornobuk.practice5.entities.Artist;

import org.springframework.data.repository.CrudRepository;

public interface ArtistsRepository extends CrudRepository<Artist, Long>{

}
