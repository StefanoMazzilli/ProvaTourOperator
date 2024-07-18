package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;
@CrossOrigin
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
	@GetMapping("/{id}")
	public Utente getUtenteById(@PathVariable Long id){
		return utenteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Utente non trovato"));
	}
	
	@PutMapping("/{id}")
	public Utente updateUtente(@PathVariable Long id, @RequestBody Utente utenteDetails) {
		Utente utente = utenteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Utente non trovato"));
		utente.setNome(utenteDetails.getNome());
		utente.setCognome(utenteDetails.getCognome());
		utente.setConfermaPassword(utenteDetails.getConfermaPassword());
		utente.setEmail(utenteDetails.getEmail());
		utente.setNascita(utenteDetails.getNascita());
		utente.setPassword(utenteDetails.getPassword());
		utente.setPrivacyLetta(utenteDetails.isPrivacyLetta());
		return utenteRepository.save(utente);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUtente(@PathVariable Long id) {
		Utente utente = utenteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Utente non trovato"));
		utenteRepository.delete(utente);
	}
	
	@GetMapping("/searchByEmail")
	public List<Utente> getUtenteByEmail(@RequestParam String email){
		return utenteRepository.findByEmail(email);
	}
	
	@GetMapping("/searchByEmailAndPassword")
	public List <Utente> getUtenteByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
		return utenteRepository.findByEmailAndPassword(email, password);
	}
}
