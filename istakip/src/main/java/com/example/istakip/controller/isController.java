package com.example.istakip.controller;

import com.example.istakip.domain.isDO;
import com.example.istakip.service.isService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/is")

public class isController {


    @Autowired
    private isService isservice;



    @PostMapping(path = "personel/{id}/isler", consumes = "application/json", produces = "application/json")
    public ResponseEntity<isDO> createis(@PathVariable(value = "id") Long id, @RequestBody isDO is) throws NotFoundException {
        isDO createdis = isservice.createIs(id, is);
        return ResponseEntity.ok(createdis);
    }

    @PutMapping(path = "personel/isler/{isId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<isDO> updateis(@PathVariable(value = "isId") Long isid, @RequestBody isDO is) {
        isDO updatedis=isservice.updateIs(isid,is);
        return ResponseEntity.ok(updatedis);

    }

    @GetMapping(path = "personel/isler/{isId}")
    public ResponseEntity<isDO> getisler(@PathVariable(value = "isId") Long isId){
        isDO getedis=isservice.getis(isId);
        return new ResponseEntity<>(getedis, HttpStatus.OK);
    }

    @DeleteMapping(path = "personel/isler/{isId}")
    public ResponseEntity<String> deletis(@PathVariable(value = "isId") Long isId){
        isservice.deleteIs(isId);
        return new ResponseEntity<>("İş id : "+ isId + " silindi.", HttpStatus.OK);
    }

    @GetMapping(path = "isler")
    public ResponseEntity<List<isDO>> getAllIs(){
        List<isDO> allis= isservice.getAllIs();
        return new ResponseEntity<>(allis, HttpStatus.OK);


    }


}