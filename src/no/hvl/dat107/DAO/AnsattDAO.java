package no.hvl.dat107.DAO;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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

    
    
    // finnAnsattMedBN
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

