package no.hvl.dat107.entitet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Avdeling")



public class Avdeling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avd_id;

	@Column(nullable = false, unique = true)
	private String sjef_id;
	
	private String navn;

	public String getSjefId() {
		return sjef_id;
	}
	
	public String getNavn() {
		return navn; 
	}
	
	public void setNavn(String navn) {
		this.navn=navn; 
	}


	@Override
	public String toString() {
		
	}

}
