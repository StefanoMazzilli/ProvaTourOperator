package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;

@Service
public class UtenteService {
	
	@Autowired
	private UtenteRepository utenteRepo;
	
	public Utente getByEmail(String email) {
		return utenteRepo.findByEmail(email);
	}
	
	public List <Utente> getAllUtente() {
		return utenteRepo.findAll ();
	}
	public Utente crateUtente (Utente utente) {
		return utenteRepo.save(utente);
	}
	public Utente getUtenteById(Long id){
		return utenteRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Utente non trovato"));
	}
	public Utente updateUtente(Long id, Utente utenteDetails) {
		Utente utente = utenteRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Utente non trovato"));
		utente.setNome(utenteDetails.getNome());
		utente.setCognome(utenteDetails.getCognome());
		utente.setConfermaPassword(utenteDetails.getConfermaPassword());
		utente.setEmail(utenteDetails.getEmail());
		utente.setNascita(utenteDetails.getNascita());
		utente.setPassword(utenteDetails.getPassword());
		utente.setPrivacyLetta(utenteDetails.isPrivacyLetta());
		return utenteRepo.save(utente);
	}
	
	public void deleteUtente(Long id) {
		Utente utente = utenteRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Utente non trovato"));
		utenteRepo.delete(utente);
	}
	
	public Utente getUtenteByEmail(String email){
		return utenteRepo.findByEmail(email);
	}
	
	public List <Utente> getUtenteByEmailAndPassword(String email, String password) {
		return utenteRepo.findByEmailAndPassword(email, password);
	}
}
