package br.com.mateusandrade.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.mateusandrade.data.vo.v1.PersonVO;
import br.com.mateusandrade.services.PersonServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/person")
public class PersonController {
  
  @Autowired
  private PersonServices service;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<PersonVO> findAll(){
    return service.findAll();
  }
  
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public PersonVO findById(@PathVariable Long id){
    return service.findById(id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id){
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping( 
  produces = MediaType.APPLICATION_JSON_VALUE,
  consumes = MediaType.APPLICATION_JSON_VALUE)
  public PersonVO create(@RequestBody PersonVO person){
    return service.create(person);
  }

  @PutMapping( 
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
  public PersonVO update(@RequestBody PersonVO person){
    return service.update(person);
  }
}
