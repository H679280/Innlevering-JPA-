package no.hvl.dat107.DAO;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat107.entitet.Avdeling;

public class AvdelingDAO {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FirmaPU");
	
	public Avdeling finnAvdelingMedId(int id) {
	EntityManager em = emf.createEntityManager();
		try {
			Avdeling avdeling = em.find(Avdeling.class,id);
			return avdeling; 
		} finally {
			em.close();
		}
	}
	// Liste
	
	// oppdatere avdeling 
}
