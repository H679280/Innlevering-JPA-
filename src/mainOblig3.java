package no.stud.dat107.oblig3;

public class mainOblig3 {

	public static void main(String[] args) {
		AnsattDAO ansattDAO = new AnsattDAO();

		// Finn en ansatt med ID 1
		Ansatt ansatt = ansattDAO.finnAnsattMedId(1);
		System.out.println(ansatt);

		System.out.println("\nAlle ansatte:");
		ansattDAO.hentAlleAnsatte().forEach(System.out::println);

	}

}
