package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Preventivo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private Date nascita;
	private String partenza;
	private String sistemazione;
	private int giorni;
	private int viaggiatori;
	private boolean minoriPresenti;
	private double prezzoElaborato;
	
	@ManyToOne
	@JoinColumn(name="destinazioni_id")
	private Destinazioni destinazione;
	
	@ManyToOne
	@JoinColumn(name="utenti_id")
	private Utente utente;
	
	//getters e setters

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

	public Date getNascita() {
		return nascita;
	}

	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}

	public String getPartenza() {
		return partenza;
	}

	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}

	public String getSistemazione() {
		return sistemazione;
	}

	public void setSistemazione(String sistemazione) {
		this.sistemazione = sistemazione;
	}

	public int getGiorni() {
		return giorni;
	}

	public void setGiorni(int giorni) {
		this.giorni = giorni;
	}

	public int getViaggiatori() {
		return viaggiatori;
	}

	public void setViaggiatori(int viaggiatori) {
		this.viaggiatori = viaggiatori;
	}

	public boolean isMinoriPresenti() {
		return minoriPresenti;
	}

	public void setMinoriPresenti(boolean minoriPresenti) {
		this.minoriPresenti = minoriPresenti;
	}

	public double getPrezzoElaborato() {
		return prezzoElaborato;
	}

	public void setPrezzoElaborato(double prezzoElaborato) {
		this.prezzoElaborato = prezzoElaborato;
	}

	public Destinazioni getDestinazione() {
		return destinazione;
	}

	public void setDestinazione(Destinazioni destinazione) {
		this.destinazione = destinazione;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	
}
