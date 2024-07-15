package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Destinazioni {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	@OneToMany(mappedBy="recensioni")
	private Recensioni recensione;
	@OneToMany(mappedBy="preventivo")
	private Preventivo preventivo;
	
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
	public Recensioni getRecensione() {
		return recensione;
	}
	public void setRecensione(Recensioni recensione) {
		this.recensione = recensione;
	}
	public Preventivo getPreventivo() {
		return preventivo;
	}
	public void setPreventivo(Preventivo preventivo) {
		this.preventivo = preventivo;
	}
	
	
}
