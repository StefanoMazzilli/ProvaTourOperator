package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Recensioni;

@Repository
public interface RecensioniRepository extends JpaRepository<Recensioni, Long> {

}
