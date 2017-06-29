package it.unibs.fp.traffico;

import it.unibs.fp.mylib.*;

/**
 * 
 * @author Magri Bortolo
 * @author Nembrini Marco
 * @author Oldani Federico
 * 
 */
public class Utilita {
	
	private static final String SALUTO_INIZIALE = "Benvenuto";
	private static final String FORMAT_MSG_SIM = "%nSi sono verificate %d collisioni.";
	
	/**
	 * Stampa un saluto di benvenuto
	 */
	public static void saluta() {
		System.out.println(BelleStringhe.incornicia(SALUTO_INIZIALE));
	}
	
	/**
	 * Stampa a video il passo di simulazione della strada specificando il numero di collisioni
	 * @param strada
	 */
	public static void mostraSimulazione(Strada strada) {
		int collisioni = strada.simula();
		System.out.println(strada.toString());
		System.out.printf(FORMAT_MSG_SIM, collisioni);
	}
	
	

}
