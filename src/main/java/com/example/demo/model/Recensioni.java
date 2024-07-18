
package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Recensioni {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String testo;
	private int voto;
	@ManyToOne
	@JoinColumn(name="utente_id")
	private Utente utente;
	@ManyToOne
	@JoinColumn(name="destinazioni_id")
	private Destinazioni destinazione;
	
	/*
	 * 	@Entity
		@Table(name = "users")
		public class User {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private Long id;
	    //... 
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "address_id", referencedColumnName = "id")
	    private Address address;
	 */
	
	//getters e setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Destinazioni getDestinazione() {
		return destinazione;
	}
	public void setDestinazione(Destinazioni destinazione) {
		this.destinazione = destinazione;
	}
	
}