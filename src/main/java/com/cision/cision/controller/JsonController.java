package com.cision.cision.controller;

import com.cision.cision.services.JsonStore;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
@AllArgsConstructor
public class JsonController {


    private JsonStore jsonStore;

    @GetMapping("/jsons")
    public ResponseEntity<List<Json>> getJsons() {
        List<Json> jsons = null;
        //jsonStore.findAll();}
        return new ResponseEntity<>(jsons, HttpStatus.OK);

    }

    @PostMapping("/jsons")
    public ResponseEntity<Json> createJson(@RequestBody Json json) {
        return new ResponseEntity<>(null,HttpStatus.OK);
    

    }
}
