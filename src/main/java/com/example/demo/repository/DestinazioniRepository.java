package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Destinazioni;

@Repository
public interface DestinazioniRepository extends JpaRepository<Destinazioni, Long> {
	List<Destinazioni> findByNome(String nome);
	
	List<Destinazioni> findByNomeContaining(String nomePart);
}
