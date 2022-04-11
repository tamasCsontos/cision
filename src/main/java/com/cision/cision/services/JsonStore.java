package com.cision.cision.services;

import com.cision.cision.controller.Json;
import com.cision.cision.repository.JsonJpaEntity;
import com.cision.cision.repository.JsonJpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Log4j2
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
                log.info("content " + request.getContent());
                log.info("timestamp " + request.getTimestamp());
                jsonJpaRepository.save(jsonJpaEntity);
                return new ResponseEntity<>(jsonJpaEntity, HttpStatus.OK);

            }catch(Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity findAll() {

        List<Json> jsons;
        try {
            jsons = jsonJpaRepository.findAll().stream().map(jsonJpaEntity -> Json.builder()
                    .id(jsonJpaEntity.getId())
                    .content(jsonJpaEntity.getContent())
                    .timestamp(jsonJpaEntity.getTimestamp())
                    .size(jsonJpaEntity.getSize())
                    .build()).collect(Collectors.toList());
            log.info("content " + jsons.get(0).getContent());
            log.info("timestamp " + jsons.get(0).getTimestamp());
            if(jsons.size() == 0) {
                return new ResponseEntity<>(jsons, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(jsons, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
