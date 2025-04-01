package no.hvl.dat107.DAO;



import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import no.hvl.dat107.entitet.Ansatt.*;

//Skal det ikkje være implementasjon av ein interface??
import jakarta.persistence.TypedQuery;
import no.hvl.dat107.entitet.Ansatt;
import no.hvl.dat107.entitet.Avdeling;


public class AnsattDAO {
	private EntityManager em;
	
	public AnsattDAO(EntityManager em) {
		this.em = em;
	}
	
    public Ansatt finnAnsattMedId(int id) {
    	return em.find(Ansatt.class, id);
        
        }
 

    public Ansatt finnAnsattMedBN(String brukernavn) {
    	TypedQuery<Ansatt> q = em.createQuery("SELECT a FROM Ansatt a WHERE a.brukernavn = :brukernavn", Ansatt.class);
    	q.setParameter("brukernavn",brukernavn);
    	return q.getSingleResult();
    }
    
    
    public static void oppdaterStilling(String nystilling) {
   
    	String q1 = "UPDATE Ansatt SET stilling =" + nystilling + "WHERE ansatt_id=" + getAnsatt_id();
    	try {
    		//TODO
    		
    	} finally {
    		    	}
    }
    
    public static void oppdaterLonn(int nylonn) {
    	//TODO
    }

   
    
   // oppdaterStilling
    public void oppdaterAnsatt(int id, String stilling,double nyLonn) {
        em.getTransaction().begin();
        Ansatt a = em.find(Ansatt.class, id);
        if (a != null) {
            a.setStilling(stilling);
            a.setManedslonn(nyLonn);
        }
        em.getTransaction().commit();
    }
    
    // leggTilNyAnsatt
	public void leggTilAnsatt(Ansatt Ansatt, Avdeling avd) {
		em.getTransaction().begin();
        em.persist(Ansatt);
        em.getTransaction().commit();
	}

    public List<Ansatt> hentAlleAnsatte() {
    	return em.createQuery("SELECT a FROM Ansatt a", Ansatt.class).getResultList();
        }
    }


