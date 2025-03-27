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
	
	public int getAvdId() {
		return avd_id;
	}

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
		return "Avdeling [avd_id= " + avd_id + "sjef id= " + sjef_id + "navn= " + navn + "]";
	}

}
