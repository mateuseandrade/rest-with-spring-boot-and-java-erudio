package br.com.mateusandrade.controllers;

import org.springframework.web.bind.annotation.RestController;
import br.com.mateusandrade.model.Person;
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
  public List<Person> findAll(){
    return service.findAll();
  }
  
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Person findById(@PathVariable Long id){
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
  public Person create(@RequestBody Person person){
    return service.create(person);
  }

  @PutMapping( 
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
  public Person update(@RequestBody Person person){
    return service.update(person);
  }
}
