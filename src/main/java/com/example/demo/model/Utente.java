package com.example.demo.model;

import java.time.LocalDate;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Utente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cognome;
	private String ruolo;
	private String email;
	private String password;
	private String confermaPassword;
	private LocalDate nascita;
	private boolean privacyLetta;
	
	@OneToMany(mappedBy="utenti")
	private List <Recensioni> recensione;
	@OneToMany(mappedBy="utenti")
	private List <Preventivo> preventivo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfermaPassword() {
		return confermaPassword;
	}
	public void setConfermaPassword(String confermaPassword) {
		this.confermaPassword = confermaPassword;
	}
	public LocalDate getNascita() {
		return nascita;
	}
	public void setNascita(LocalDate nascita) {
		this.nascita = nascita;
	}
	public boolean isPrivacyLetta() {
		return privacyLetta;
	}
	public void setPrivacyLetta(boolean privacyLetta) {
		this.privacyLetta = privacyLetta;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public List<Recensioni> getRecensione() {
		return recensione;
	}
	public void setRecensione(List<Recensioni> recensione) {
		this.recensione = recensione;
	}
	public List<Preventivo> getPreventivo() {
		return preventivo;
	}
	public void setPreventivo(List<Preventivo> preventivo) {
		this.preventivo = preventivo;
	}
	
}