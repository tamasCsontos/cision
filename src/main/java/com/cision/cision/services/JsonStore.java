package com.cision.cision.services;

import com.cision.cision.controller.Json;
import com.cision.cision.repository.JsonJpaEntity;
import com.cision.cision.repository.JsonJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class JsonStore {

    @Autowired
    private final JsonJpaRepository jsonJpaRepository;

    public String save() {
        JsonJpaEntity jsonJpaEntity = null;
        jsonJpaRepository.save(jsonJpaEntity);
        return "ok";
    }

    public List<Json> findAll(){
        return jsonJpaRepository.findAll().stream().map(jsonJpaEntity -> Json.builder()
                .id(jsonJpaEntity.getId())
                .content(jsonJpaEntity.getContent())
                .timestamp(jsonJpaEntity.getTimestamp())
                .size(jsonJpaEntity.getSize())
                .build()).collect(Collectors.toList());
    }
}
