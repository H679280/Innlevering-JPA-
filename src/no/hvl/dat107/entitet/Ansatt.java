package no.hvl.dat107.entitet;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"Ansatt\"", schema = "Firma")

public class Ansatt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int ansatt_id;
	@Column(nullable = false, unique = true)
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private LocalDate ansettelsesdato;
	private String stilling;
	private double manedslonn;
	
	@ManyToOne
	private Avdeling avdeling; 
	
	@ManyToOne(targetEntity = Prosjekt.class)
	private Prosjekt prosjekt;

	
	public int getAnsatt_id() {
		return getAnsatt_id();
	}

	public void setAnsatt_id(int ansatt_id) {
		this.ansatt_id = ansatt_id;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public LocalDate getAnsettelsesdato() {
		return ansettelsesdato;
	}

	public void setAnsettelsesdato(LocalDate ansettelsesdato) {
		this.ansettelsesdato = ansettelsesdato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public double getManedslonn() {
		return manedslonn;
	}

	public void setManedslonn(double manedslonn) {
		this.manedslonn = manedslonn;
	}
	
	public Avdeling getAvdeling() {
		return avdeling;
	}

	@Override
	public String toString() {
		return "Ansatt [ansatt_id=" + ansatt_id + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn="
				+ etternavn + ", ansettelsesdato=" + ansettelsesdato + ", stilling=" + stilling + ", manedslonn="
				+ manedslonn + "]";
	}

}
