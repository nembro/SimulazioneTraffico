package it.unibs.fp.traffico;

import it.unibs.fp.mylib.*;

public class Strada {
	
	
	private Elemento [][] strada;
	
	public Strada(int corsie, int lunghezza) {
		strada = new Elemento[corsie][lunghezza];
	}
	
	
	public int simula() {
		int collisioni = 0;
		Elemento [][] nuovaStrada = new Elemento[strada.length][strada[0].length];
		inizializzaAVuoto(nuovaStrada);
		for (int i=0; i<strada.length; i++) {
			for (int j=0; j<strada[i].length; j++) {
				if (strada[i][j].getProssimaPosizione().staDentro(strada.length, strada[0].length)) {
					int nuovaX = strada[i][j].getProssimaPosizione().getX();
					int nuovaY = strada[i][j].getProssimaPosizione().getY();
					if (strada[i][j].collisioneCon(nuovaStrada[nuovaY][nuovaX])) {
						collisioni++;
					}
					if (strada[i][j].prevaleSu(nuovaStrada[nuovaY][nuovaX])) {
						nuovaStrada[nuovaY][nuovaX] = strada[i][j];
						strada[i][j].modificaPosizione(new Coordinate(nuovaY,nuovaX));
					}
				}
			}
		}
		strada = nuovaStrada;
		
		return collisioni;
		
	}
	
	private static void inizializzaAVuoto(Elemento [][] strada) {
		for(int i=0; i<strada.length; i++) {
			for(int j=0; j<strada[i].length; j++)
				strada[i][j]=new Vuoto(new Coordinate(j,i));
		}
	}
	
	public void riempiCasuale(int nPedoni, int nAuto) {
		inizializzaAVuoto(strada);
		for (int i=0; i<nPedoni; i++) {
			int cooY = NumeriCasuali.estraiIntero(0, strada.length-1);
			int cooX = NumeriCasuali.estraiIntero(0, strada[cooY].length-1);
			strada[cooY][cooX]= new Pedone(new Coordinate(cooY,cooX));
		}
		for (int i=0; i<nAuto; i++) {
			int cooY = NumeriCasuali.estraiIntero(0, strada.length-1);
			int cooX = NumeriCasuali.estraiIntero(0, strada[cooY].length-1);
			strada[cooY][cooX]= new Auto(new Coordinate(cooY,cooX));
		}
	}
	
	public void riempiCasuale() {
		int pedoni = NumeriCasuali.estraiIntero(5, strada.length-1);
	}
	
	private String generaDelineatoreBanchina() {
		StringBuffer stringa = new StringBuffer();
			for (int i=0; i<strada[0].length; i++) {
				stringa.append("//");
			}
			stringa.append("\n");
			return stringa.toString();
	}
	
	public String toString() {
		StringBuffer stringaStrada = new StringBuffer();
		stringaStrada.append(generaDelineatoreBanchina());
		for (int i=0; i<strada.length; i++) {
			for (int j=0; j<strada[i].length; j++) {
				stringaStrada.append(strada[i][j].toString() + " ");
			}
			stringaStrada.append("\n");
		}
		stringaStrada.append(generaDelineatoreBanchina());
		return stringaStrada.toString();
	}

}
