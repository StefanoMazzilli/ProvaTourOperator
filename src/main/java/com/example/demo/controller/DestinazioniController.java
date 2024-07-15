package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Destinazioni;
import com.example.demo.repository.DestinazioniRepository;

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
}
