package no.hvl.dat107.entitet;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Avdeling")

public class Avdeling {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int avd_id;

    @OneToMany(mappedBy = "avdeling", fetch = FetchType.EAGER)
    private List<Ansatt> ansatte;

    @OneToOne
    @JoinColumn(name = "sjef_id", nullable = false, unique = true)
    private Ansatt sjef;

    @Column(nullable = false)
    private String navn;
    

    public int getAvdId() {
        return avd_id;
    }

    public void setAvdId(int avd_id) {
        this.avd_id = avd_id;
    }

    public Ansatt getSjef() {
        return sjef;
    }

    public void setSjef(Ansatt sjef) { 
    	
        if (sjef.getAvdeling().getAvdId() != this.avd_id) {
        	throw new IllegalArgumentException("Sjefen må jobbe i denne avdelingen");
        }
        this.sjef = sjef; 
    }

    public List<Ansatt> getAnsatte() {
        return ansatte;
    }

    public void setAnsatte(List<Ansatt> ansatte) {
        this.ansatte = ansatte;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

	@Override
	public String toString() {
		return "Avdeling [avd_id= " + avd_id + "Sjefen´s ansattid= " + sjef.getAnsatt_id() + "navn= " + navn + "]";
	}

}
