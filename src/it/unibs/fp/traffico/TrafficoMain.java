package it.unibs.fp.traffico;

import it.unibs.fp.mylib.*;

/**
 * 
 * @author Magri Bortolo
 * @author Nembrini Marco
 * @author Oldani Federico
 * 
 */
public class TrafficoMain {
	
	private static final String MSG_SIM = "Procedere con la simulazione?";
	private static final String MSG_SIM_TERMINATA = "Simulazione terminata";
	private static final String NEW_LINE = "\n";
	public static void main(String[] args) {
		
		Utilita.saluta();
		
		Strada strada = new Strada(8,30);
		strada.riempiCasuale();
		
		System.out.println(strada.toString());
		
		boolean stato = true;
		
		do {
			System.out.println(NEW_LINE);
			Utilita.mostraSimulazione(strada);
			stato = InputDati.yesOrNo(NEW_LINE + MSG_SIM);
		} while (stato);
		
		System.out.println(MSG_SIM_TERMINATA);


	}

}
