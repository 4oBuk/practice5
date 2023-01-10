package com.chornobuk.practice5.repositories;

import com.chornobuk.practice5.entities.Artist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistsRepository extends CrudRepository<Artist, Long>{

}
