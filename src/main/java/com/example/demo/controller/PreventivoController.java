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

import com.example.demo.model.Preventivo;
import com.example.demo.repository.PreventivoRepository;
@CrossOrigin
@RestController
@RequestMapping("/preventivo")
public class PreventivoController {
	@Autowired
	private PreventivoRepository preventivoRepository;
	
	@GetMapping
	public List <Preventivo> getAllPreventivo() {
		return preventivoRepository.findAll ();
	}
	@PostMapping
	public Preventivo cratePreventivo (@RequestBody Preventivo preventivo) {
		return preventivoRepository.save(preventivo);
	}
	@GetMapping("/{id}")
	public Preventivo getPreventivoById(@PathVariable Long id){
		return preventivoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Preventivo non trovato"));
	}
	
	@PutMapping("/{id}")
	public Preventivo updatePreventivo(@PathVariable Long id, @RequestBody Preventivo preventivoDetails) {
		Preventivo preventivo = preventivoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Preventivo non trovato"));
		preventivo.setNome(preventivoDetails.getNome());
		preventivo.setCognome(preventivoDetails.getCognome());
		preventivo.setDestinazione(preventivoDetails.getDestinazione());
		preventivo.setEmail(preventivoDetails.getEmail());
		preventivo.setGiorni(preventivoDetails.getGiorni());
		preventivo.setMinoriPresenti(preventivoDetails.isMinoriPresenti());
		preventivo.setNascita(preventivoDetails.getNascita());
		preventivo.setPartenza(preventivoDetails.getPartenza());
		preventivo.setPrezzoElaborato(preventivoDetails.getPrezzoElaborato());
		preventivo.setSistemazione(preventivoDetails.getSistemazione());
		preventivo.setUtente(preventivoDetails.getUtente());
		preventivo.setViaggiatori(preventivoDetails.getViaggiatori());
		return preventivoRepository.save(preventivo);
	}
	@DeleteMapping("/{id}")
	public void deletePreventivo(@PathVariable Long id) {
		Preventivo preventivo = preventivoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Preventivo non trovato"));
		preventivoRepository.delete(preventivo);		
	}
	@GetMapping("/searchByDestinazione")
	public List<Preventivo> getPreventivoBydestinazione(@RequestParam String destinazione){
		return preventivoRepository.findByDestinazione(destinazione);
	}

}
