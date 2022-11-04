package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Professeur;

@Repository
public interface IProfesseurRepository extends JpaRepository<Professeur, Integer> {

}
