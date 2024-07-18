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
import com.example.demo.model.Recensioni;
import com.example.demo.repository.RecensioniRepository;
@CrossOrigin
@RestController
@RequestMapping("/recensioni")
public class RecensioniController {
	@Autowired
	private RecensioniRepository recensioniRepository;
	
	@GetMapping
	public List <Recensioni> getAllRecensioni() {
		return recensioniRepository.findAll ();
	}
	@PostMapping
	public Recensioni crateRecensione (@RequestBody Recensioni recensioni) {
		return recensioniRepository.save(recensioni);
	}
	@GetMapping("/{id}")
	public Recensioni getRecensioneById(@PathVariable Long id){
		return recensioniRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Recensione non trovata"));
	}
	
	@PutMapping("/{id}")
	public Recensioni updateRecensione(@PathVariable Long id, @RequestBody Recensioni recensioniDetails) {
		Recensioni recensioni = recensioniRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Recensione non trovata"));
		recensioni.setDestinazione(recensioniDetails.getDestinazione());
		recensioni.setTesto(recensioniDetails.getTesto());
		recensioni.setUtente(recensioniDetails.getUtente());
		recensioni.setVoto(recensioniDetails.getVoto());
		return recensioniRepository.save(recensioni);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRecensione(@PathVariable Long id) {
		Recensioni recensioni = recensioniRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Recensione non trovata"));
		recensioniRepository.delete(recensioni);
	}
	@GetMapping("/searchByDestinazione")
	public List<Recensioni> getRecensioniBydestinazione(@RequestParam String destinazione){
		return recensioniRepository.findByDestinazione(destinazione);
	}
	
	
}
