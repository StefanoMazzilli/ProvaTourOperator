package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
	List <Utente> findByEmailAndPassword(String email, String password);
	Utente findByEmail(String email);
	


}