package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Recensioni;
import com.example.demo.repository.RecensioniRepository;

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
	public Recensioni crateUtente (@RequestBody Recensioni recensioni) {
		return recensioniRepository.save(recensioni);
	}
}
