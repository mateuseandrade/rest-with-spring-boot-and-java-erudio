package br.com.mateusandrade.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;
import br.com.mateusandrade.exceptions.ResourceNotFoundException;
import br.com.mateusandrade.model.Person;
import br.com.mateusandrade.repositories.PersonRepository;

@Service
public class PersonServices {
  private Logger logger = Logger.getLogger(PersonServices.class.getName());

  @Autowired
  PersonRepository repository;

  public List<Person> findAll() {
    logger.info("Finding all people!");
    return repository.findAll();
  }

  public Person findById(Long id) {
    logger.info("Finding one Person!");
    return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
  }

  public Person create(Person person) {
    logger.info("Creating one Person!");
    return repository.save(person);
  }

  
  public Person update(Person person) {
    logger.info("Updating one Person!");

    Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
   
    entity.setFirstName(person.getFirstName());
    entity.setLastName(person.getLastName());
    entity.setAddress(person.getAddress());
    entity.setGender(person.getGender());

    return repository.save(person);
  }

  public void delete(Long id) {
    logger.info("Deleting one Person!");
    Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
   repository.delete(entity);
  }
}
