package com.chornobuk.practice5.repositories;

import com.chornobuk.practice5.entities.Illustration;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IllustrationsRepository extends CrudRepository<Illustration, Long> {

}
