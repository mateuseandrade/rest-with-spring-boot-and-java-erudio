package br.com.mateusandrade.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mateusandrade.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}