package br.com.mateusandrade.services;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

import br.com.mateusandrade.model.Person;

@Service
public class PersonServices {
  private final AtomicLong counter = new AtomicLong();
  private Logger logger = Logger.getLogger(PersonServices.class.getName());

  public List<Person> findAll() {
    List<Person> persons = new ArrayList<>();
    
    logger.info("Finding all people!");
    for (int i = 0; i < 8; i++) {
      Person person = mockPerson(i);
      persons.add(person);
    }
    return persons;
  }

  public Person findById(String id) {
    logger.info("Finding one Person!");
    
    Person person = new Person();
    person.setId(counter.incrementAndGet());
    person.setFirstName("Mateus");
    person.setLastName("Andrade");
    person.setAddress("Canadá");
    person.setGender("Male");
    return person;
  }

  public Person create(Person person) {
    logger.info("Creating one Person!");
    return person;
  }

  
  public Person update(Person person) {
    logger.info("Updating one Person!");
    return person;
  }

  public void delete(String id) {
    logger.info("Deleting one Person!");
  }

  private Person mockPerson(int i) {
    Person person = new Person();
    person.setId(counter.incrementAndGet());
    person.setFirstName("Mateus" + i);
    person.setLastName("Andrade" + i);
    person.setAddress("Canadá" + i);
    person.setGender("Male" + i);
    return person;
  }
}
