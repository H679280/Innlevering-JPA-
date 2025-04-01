package no.hvl.dat107.entitet;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Prosjekt")
public class Prosjekt {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int prosjekt_id;

    @OneToMany(mappedBy = "prosjekt", fetch = FetchType.EAGER)
    private List<Ansatt> ansatte;

    @Column(nullable = false)
    private String prosjektnavn;
    private String beskrivelse;

    
    
    public int getProsjektID() {
    	
    	return prosjekt_id;
    }
    
    public void setProsjektID(int id) {
    	this.prosjekt_id = id;
    }
    
    public String getProsjektNavn() {
    	return prosjektnavn;
    }
    
    public void setProsjektNavn(String navn) {
    	this.prosjektnavn = navn;
    }
    
    public String getBeskrivelse() {
    	return beskrivelse;
    }
    
    public void setBeskrivelse(String bsk) {
    	this.beskrivelse = bsk;
    }
 
    public List<Ansatt> getAnsatte() {
        return ansatte;
    }

    public void setAnsatte(List<Ansatt> ansatte) {
        this.ansatte = ansatte;
    }
    
 

//Utskrift av liste av deltagere med rolle og timer
	@Override
	public String toString() {
		return "Prosjekt [prosjekt_id= " + prosjekt_id + "prosjektnavn="+ prosjektnavn + "Liste over ansatte  " + ansatte + "]";
	}

}


