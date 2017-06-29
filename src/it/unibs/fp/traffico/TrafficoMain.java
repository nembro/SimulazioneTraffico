package it.unibs.fp.traffico;

import it.unibs.fp.mylib.*;

public class TrafficoMain {
	
	private static final String MSG_SIM = "Procedere con la simulazione?";
	private static final String MSG_SIM_TERMINATA = "Simulazione terminata";
	public static void main(String[] args) {
		
		Utilita.saluta();
		
		Strada strada = new Strada(8,30);
		strada.riempiCasuale(28, 28);
		
		System.out.println(strada.toString());
		
		boolean stato = true;
		
		do {
			System.out.println("\n");
			Utilita.mostraSimulazione(strada);
			stato = InputDati.yesOrNo("\n" + MSG_SIM);
		} while (stato);
		
		System.out.println(MSG_SIM_TERMINATA);
		
		
		
		
	

		
		
		
		

	}

}
