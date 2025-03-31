package no.hvl.dat107.DAO;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat107.entitet.Ansatt;

public class AnsattDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("firmaPU");

    public Ansatt finnAnsattMedId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Ansatt.class, id);
        } finally {
            em.close();
        }
    }

    public Ansatt finnAnsattMedBN(String brukernavn) {
    	EntityManager em = emf.createEntityManager();
    	try {
    		return em.createQuery("SELECT a from Ansatt a WHERE a.brukernavn = :brukernavn", Ansatt.class).getSingleResult();
    	} finally {
    		em.close();
    	}
    }
    
    
   // oppdaterStilling
    // oppdaterLonn
    // leggTilNyAnsatt
    public List<Ansatt> hentAlleAnsatte() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT a FROM Ansatt2 a", Ansatt.class).getResultList();
        } finally {
            em.close();
        }
    }
}

