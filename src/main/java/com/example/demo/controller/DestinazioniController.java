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
import com.example.demo.model.Destinazioni;
import com.example.demo.repository.DestinazioniRepository;
@CrossOrigin
@RestController
@RequestMapping("/destinazioni")
public class DestinazioniController {
	
	@Autowired
	private DestinazioniRepository destinazioneRepository;
	
	@GetMapping
	public List<Destinazioni> getAllDestinazioni() {
		return destinazioneRepository.findAll();
	}
	
	@PostMapping
	public Destinazioni createDestinazione(@RequestBody Destinazioni destinazione) {
		return destinazioneRepository.save(destinazione);
	}
	@GetMapping("/{id}")
	public Destinazioni getDestinazioneById(@PathVariable Long id){
		return destinazioneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Destinazione non trovata"));
	}
	
	@PutMapping("/{id}")
	public Destinazioni updateDestinazione(@PathVariable Long id, @RequestBody Destinazioni destinazioneDetails) {
		Destinazioni destinazione = destinazioneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Destinazione non trovata"));
		destinazione.setNome(destinazioneDetails.getNome());
		return destinazioneRepository.save(destinazione);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDestinazione(@PathVariable Long id) {
		Destinazioni destinazione = destinazioneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Destinazione non trovata"));
		destinazioneRepository.delete(destinazione);
	}
	
	@GetMapping("/searchByNome")
	public List<Destinazioni> getDestinazioniByNome(@RequestParam String name){
		return destinazioneRepository.findByNome(name);
	}
	@GetMapping("/searchByNomeContaining")
	public List<Destinazioni> getDestinazioneByNomeContaining(@RequestParam String nomePart) {
		return destinazioneRepository.findByNomeContaining(nomePart);
	}
	
}
