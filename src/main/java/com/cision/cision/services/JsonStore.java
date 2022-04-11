package com.cision.cision.services;

import com.cision.cision.controller.Json;
import com.cision.cision.repository.JsonJpaEntity;
import com.cision.cision.repository.JsonJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class JsonStore {

    @Autowired
    private final JsonJpaRepository jsonJpaRepository;

    public ResponseEntity save(Json request) {

        if(request!=null) {

            try {
                long size = request.getContent().length();
                JsonJpaEntity jsonJpaEntity = JsonJpaEntity.builder()
                        .content(request.getContent())
                        .timestamp(request.getTimestamp())
                        .size(size)
                        .build();
                jsonJpaRepository.save(jsonJpaEntity);
                return new ResponseEntity<>(jsonJpaEntity, HttpStatus.OK);

            }catch(Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);;
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
