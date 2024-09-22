package br.com.mateusandrade.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.mateusandrade.data.vo.v1.PersonVO;
import br.com.mateusandrade.data.vo.v2.PersonVOV2;
import br.com.mateusandrade.services.PersonServices;
import br.com.mateusandrade.util.MediaType;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
  
  @Autowired
  private PersonServices service;

  @GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
  public List<PersonVO> findAll(){
    return service.findAll();
  }
  
  @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
  public PersonVO findById(@PathVariable Long id){
    return service.findById(id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id){
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping( 
  produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
  consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
  public PersonVO create(@RequestBody PersonVO person){
    return service.create(person);
  }

  @PostMapping( 
    value = "/v2",
    produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
    consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public PersonVOV2 createV2(@RequestBody PersonVOV2 person){
      return service.createV2(person);
    }

  @PutMapping( 
    produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
    consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
  public PersonVO update(@RequestBody PersonVO person){
    return service.update(person);
  }
}
