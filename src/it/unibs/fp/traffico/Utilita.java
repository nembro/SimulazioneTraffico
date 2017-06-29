package it.unibs.fp.traffico;

import it.unibs.fp.mylib.*;

public class Utilita {
	
	private static final String SALUTO_INIZIALE = "Benvenuto";
	private static final String FORMAT_MSG_SIM = "%nSi sono verificate %d collisioni.";
	
	
	public static void saluta() {
		System.out.println(BelleStringhe.incornicia(SALUTO_INIZIALE));
	}
	
	public static void mostraSimulazione(Strada strada) {
		int collisioni = strada.simula();
		System.out.println(strada.toString());
		System.out.printf(FORMAT_MSG_SIM, collisioni);
	}
	
	

}
