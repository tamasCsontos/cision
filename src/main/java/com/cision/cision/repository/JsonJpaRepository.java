package com.cision.cision.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JsonJpaRepository extends CrudRepository<JsonJpaEntity, Long> {

    List<JsonJpaEntity> findByContent(String content);
}
