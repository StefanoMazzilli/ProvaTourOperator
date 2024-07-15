package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Utente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private String confermaPassword;
	private Date nascita;
	private boolean privacyLetta;
	
	@OneToOne(mappedBy="recensioni")
	private Long recnesioni_id;
	@OneToMany(mappedBy="preventivo")
	private Long preventivo_id;
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
	public Date getNascita() {
		return nascita;
	}
	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}
	public boolean isPrivacyLetta() {
		return privacyLetta;
	}
	public void setPrivacyLetta(boolean privacyLetta) {
		this.privacyLetta = privacyLetta;
	}
	public Long getRecnesioni_id() {
		return recnesioni_id;
	}
	public void setRecnesioni_id(Long recnesioni_id) {
		this.recnesioni_id = recnesioni_id;
	}
	public Long getPreventivo_id() {
		return preventivo_id;
	}
	public void setPreventivo_id(Long preventivo_id) {
		this.preventivo_id = preventivo_id;
	}
	
	
}
