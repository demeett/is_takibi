package com.example.istakip.controller;


import com.example.istakip.domain.PersonelDO;
import com.example.istakip.service.PersonelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/is")
public class PersonelController {
    @Autowired
    private PersonelService personelService;

    @GetMapping("/hello")

    String hello(){
        return "Spring hello";
    }
    @PostMapping(path = "/personel", consumes = "application/json",produces = "application/json")
    public ResponseEntity<PersonelDO> createPersonel(@RequestBody PersonelDO personelDO){
        PersonelDO createdPersonel=personelService.createPersonel(personelDO);
        return new ResponseEntity<>(createdPersonel, HttpStatus.CREATED);

    }

    @PutMapping(path = "/personel", consumes = "application/json",produces = "application/json")
    public ResponseEntity<PersonelDO> updatePersonel(@RequestBody PersonelDO personelDO){
        PersonelDO updatedPersonel=personelService.updatePersonel(personelDO);
        return new ResponseEntity<>(updatedPersonel, HttpStatus.CREATED);
    }

    @GetMapping(path = "/personels/{personelId}")
    public ResponseEntity<PersonelDO> getPersonel(@PathVariable(value="personelId") Long personelId){
        PersonelDO personel=personelService.getPersonel(personelId);
        return new ResponseEntity<>(personel, HttpStatus.OK);
    }
    @DeleteMapping(path = "/personels/{personelId}")
    public ResponseEntity<String > deletePersonel(@PathVariable(value = "personelId") Long personelId){
        personelService.deletePersonel(personelId);
        return new ResponseEntity<>("Personel with  id: "+ personelId+ " is deleted.", HttpStatus.OK);
    }




}
