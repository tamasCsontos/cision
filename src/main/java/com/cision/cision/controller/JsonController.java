package com.cision.cision.controller;

import com.cision.cision.repository.JsonJpaEntity;
import com.cision.cision.services.JsonStore;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api")
@AllArgsConstructor
public class JsonController {


    private JsonStore jsonStore;

    @GetMapping("jsons")
    public ResponseEntity<List<Json>> getJsons() {
        return jsonStore.findAll();
    }

    @PostMapping("jsons")
    public ResponseEntity<JsonJpaEntity> createJson(@RequestBody Json json) {
            return jsonStore.save(json);
    }
}
