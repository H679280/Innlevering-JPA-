package no.hvl.dat107.g;
import no.hvl.dat107.entitet.*;

import jakarta.persistence.EntityManager;
import java.util.Scanner;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat107.DAO.AnsattDAO;
import no.hvl.dat107.DAO.AvdelingDAO;



public class Main2{
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("FirmaPU");
	private static EntityManager em = emf.createEntityManager();
	private static AnsattDAO ansattDAO = new AnsattDAO(em);
	private static AvdelingDAO avdelingDAO = new AvdelingDAO();
	private static Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		boolean run = true; 
		while(run) {
			System.out.println("1:Søk ansatt ID\n2: Søk ansatt brukernavn\n3: List ansatte \n4: Oppdater stilling/lønn\n5: Legg til ansatt\n6: Søk avdeling ID\n7: List ansatte i avdeling\n8: Bytt avdeling\n9: Legg til avdeling\n10: Avslutt");
		    int valg = scanner.nextInt();
		    
		    switch (valg) {
            case 1 -> finnAnsattId();
            case 2 -> finnAnsattBrukernavn();
            case 3 -> listAnsatte();
            case 4 -> oppdaterAnsatt();
            case 5 -> leggTilAnsatt();
            case 10 -> run = false;
		}
		    
		    em.close();
	        emf.close();
	}}
		
		private static void finnAnsattId() {
        System.out.print("Ansatt ID: ");
        int id = scanner.nextInt();
        Ansatt ansatt = ansattDAO.finnAnsattMedId(id);
        System.out.println(ansatt);
    }
    
    private static void finnAnsattBrukernavn() {
        System.out.print("Brukernavn: ");
        String brukernavn = scanner.next();
        Ansatt ansatt = ansattDAO.finnAnsattMedBN(brukernavn);
        System.out.println(ansatt);
    }
    
    private static void listAnsatte() {
        ansattDAO.hentAlleAnsatte().forEach(System.out::println);
    }
    
    private static void oppdaterAnsatt() {
        System.out.print("Ansatt ID: ");
        int id = scanner.nextInt();
        System.out.print("Ny stilling: ");
        String stilling = scanner.next();
        System.out.print("Ny lønn: ");
        double lonn = scanner.nextDouble();
        ansattDAO.oppdaterAnsatt(id, stilling, lonn);
    }
    
    private static void leggTilAnsatt() {
        System.out.print("Brukernavn: ");
        String brukernavn = scanner.next();
        System.out.print("Navn: ");
        String navn = scanner.next();
        System.out.print("Stilling: ");
        String stilling = scanner.next();
        System.out.print("Lønn: ");
        double lonn = scanner.nextDouble();
        System.out.print("Avdeling ID: ");
        int avdId = scanner.nextInt();
        Avdeling avd = avdelingDAO.finnAvdelingMedId(avdId);
        ansattDAO.leggTilAnsatt(new Ansatt());
    }
	
}