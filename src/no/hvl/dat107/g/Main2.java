package no.hvl.dat107.g;


import jakarta.persistence;
import jakarta.persistence.EntityManagerFactory;


public class Main2{
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ansattPU");
	private static EntityManager em = emf.createEntityManager();
	private static AnsattDAO ansattDAO = new AnsattDAO(em);
	private static AvdelingDAO avdelingDAO = new AvdelingDAO(em);
	private static Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		boolean run = true; 
		while(run) {
			System.out.println("1:Søk ansatt ID\n2: Søk ansatt brukernavn\n3: List ansatte \n4: Oppdater stilling/lønn\n5: Legg til ansatt\n6: Søk avdeling ID\n7: List ansatte i avdeling\n8: Bytt avdeling\n9: Legg til avdeling\n10: Avslutt");
		}
	}
	
	
}