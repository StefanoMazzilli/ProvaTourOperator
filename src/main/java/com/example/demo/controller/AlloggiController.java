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
import com.example.demo.model.Alloggi;
import com.example.demo.repository.AlloggiRepository;

@CrossOrigin
@RestController
@RequestMapping("/alloggi")
public class AlloggiController {
	@Autowired
	private AlloggiRepository alloggiRepository;
	
	@GetMapping
	public List <Alloggi> getAllAlloggi() {
		return alloggiRepository.findAll ();
	}
	@PostMapping
	public Alloggi crateAlloggi (@RequestBody Alloggi alloggi) {
		return alloggiRepository.save(alloggi);
	}
	@GetMapping("/{id}")
	public Alloggi getAlloggiById(@PathVariable Long id){
		return alloggiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Alloggio non trovato"));
	}
	
	@PutMapping("/{id}")
	public Alloggi updateAlloggio(@PathVariable Long id, @RequestBody Alloggi alloggiDetails) {
		Alloggi alloggi = alloggiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Alloggio non trovato"));
		alloggi.setNome(alloggiDetails.getNome());
		alloggi.setDestinazione(alloggiDetails.getDestinazione());
		alloggi.setDescrizione(alloggiDetails.getDescrizione());
		alloggi.setPrezzo(alloggiDetails.getPrezzo());
		alloggi.setSconto(alloggiDetails.getSconto());
		alloggi.setStelle(alloggiDetails.getStelle());
		return alloggiRepository.save(alloggi);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		Alloggi alloggi = alloggiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Alloggio non trovato"));
		alloggiRepository.delete(alloggi);
	}
	@GetMapping("/searchByIdDestinazione")
	public List<Alloggi> getAllAlloggiBydestinazione_id(@RequestParam Long destinazione_id){
		return alloggiRepository.findAllBydestinazione_id(destinazione_id);
	}
	
}
