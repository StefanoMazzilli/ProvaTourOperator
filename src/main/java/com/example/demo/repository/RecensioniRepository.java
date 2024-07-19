package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Recensioni;

@Repository
public interface RecensioniRepository extends JpaRepository<Recensioni, Long> {

	List<Recensioni> findAllBydestinazione_id(Long destinazione_id);
}
