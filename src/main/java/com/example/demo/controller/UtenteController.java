package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UnauthorizedException;
import com.example.demo.model.Token;
import com.example.demo.model.Utente;
import com.example.demo.service.TokenService;
import com.example.demo.service.UtenteService;
@CrossOrigin
@RestController
@RequestMapping("/utenti")
public class UtenteController {

	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private TokenService tokenService;
	
	@GetMapping
	public List <Utente> getAllUtente() {
		return utenteService.getAllUtente();
	}
	@PostMapping
	public Utente crateUtente (@RequestBody Utente utente) {
		return utenteService.crateUtente(utente);
	}
	@GetMapping("/{id}")
	public Utente getUtenteById(@PathVariable Long id){
		return utenteService.getUtenteById(id);
	}
	
	@PutMapping("/{id}")
	public Utente updateUtente(@PathVariable Long id, @RequestBody Utente utenteDetails) {
		return utenteService.updateUtente(id, utenteDetails);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUtente(@PathVariable Long id) {
		utenteService.deleteUtente(id);
	}
	
	@GetMapping("/searchByEmail")
	public Utente getUtenteByEmail(@RequestParam String email){
		return utenteService.getByEmail(email);
	}
	
	@GetMapping("/searchByEmailAndPassword")
	public List <Utente> getUtenteByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
		return utenteService.getUtenteByEmailAndPassword(email, password);
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> getAccess(@RequestHeader("Authorization") String token) {
		Token authToken = tokenService.findByToken(token);
		if (authToken!=null) {
			Utente utente = utenteService.getUtenteById(authToken.getUserId());
			if (utente!=null&&"ADMIN".equals(utente.getRuolo())) {
				ResponseEntity<String> risposta = null;
				risposta.status(HttpStatus.OK);
				return risposta;
			} else {
				throw new UnauthorizedException();
			}
		} else {
			throw new UnauthorizedException();
		}
	}
 }