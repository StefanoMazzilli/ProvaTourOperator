package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

	@Autowired
	private UtenteRepository utenteRepository;
	
	@GetMapping
	public List <Utente> getAllUtente() {
		return utenteRepository.findAll ();
	}
	@PostMapping
	public Utente crateUtente (@RequestBody Utente utente) {
		return utenteRepository.save(utente);
	}
	
	@GetMapping
	public List <Utente> getUtenteByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
		return utenteRepository.findByEmailAndPassword(email, password);
	}
}
