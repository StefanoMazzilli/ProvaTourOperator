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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Contatto;

import com.example.demo.repository.ContattoRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/contatti")
public class ContattoController {
	
	@Autowired
    private ContattoRepository contattoRepository;
	
	@GetMapping
    public List<Contatto> getAllContatti() {
        return contattoRepository.findAll();
    }
	
	@GetMapping("/{id}")
	public Contatto getContattoById(@PathVariable Long id) {
		return contattoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Messaggio non trovato con Id " + id));
	}
	
	@PostMapping
	public Contatto createContatto(@RequestBody Contatto contatto) {
		return contattoRepository.save(contatto);
	}
	
	@PutMapping("/{id}")
	 public Contatto updateContatto(@PathVariable Long id, @RequestBody Contatto contattoDetails) {
        Contatto contatto = contattoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Messaggio non trovato con Id " + id));

        contatto.setNome(contattoDetails.getNome());
        contatto.setCognome(contattoDetails.getCognome());
        contatto.setEmail(contattoDetails.getEmail());
        contatto.setTelefono(contattoDetails.getTelefono());
        contatto.setCommento(contattoDetails.getCommento());

        return contattoRepository.save(contatto);
    }
	
	@DeleteMapping("/{id}")
    public void deleteContatto(@PathVariable Long id) {
        contattoRepository.deleteById(id);
    }


}
