package it.unibs.fp.traffico;

import it.unibs.fp.mylib.*;

/**
 * Classe Strada
 * @author Magri Bortolo
 * @author Nembrini Marco
 * @author Oldani Federico
 * 
 */
public class Strada {
	
	private static final double PROB_AUTO = 0.1;
	private static final double PROB_PEDONE = 0.1;
	private static final String SIMBOLO_DEL_CARREGGIATA = "//";
	private static final String NEW_LINE = "\n";
	
	private Elemento [][] strada;
	
	public Strada(int corsie, int lunghezza) {
		strada = new Elemento[corsie][lunghezza];
	}
	
	/**
	 * Simula di un passo l'andamento degli elementi che popolano la strada
	 * @return il numero di collisioni avvenute
	 */
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
	
	/**
	 * Inizializza la strada con elementi di tipo Vuoto
	 * @param strada
	 */
	public static void inizializzaAVuoto(Elemento [][] strada) {
		for(int i=0; i<strada.length; i++) {
			for(int j=0; j<strada[i].length; j++)
				strada[i][j]=new Vuoto(new Coordinate(j,i));
		}
	}
	
	/**
	 * Riempie la starda in maniera casuale dato il numero di pedoni e di auto;
	 * @param nPedoni
	 * @param nAuto
	 * @throws IllegalArgumentException nel caso il numero di auto e di pedoni sia maggiore dei posti a disposizione
	 */
	public void riempiCasuale(int nPedoni, int nAuto) throws IllegalArgumentException {
		if (nPedoni+nAuto > strada.length*strada[0].length)
			throw new IllegalArgumentException();
		inizializzaAVuoto(strada);
		for (int i=0; i<nPedoni; i++) {
			int cooY = NumeriCasuali.estraiIntero(0, strada.length-1);
			int cooX = NumeriCasuali.estraiIntero(0, strada[cooY].length-1);
			if(strada[cooY][cooX] instanceof Vuoto)
				strada[cooY][cooX]= new Pedone(new Coordinate(cooY,cooX));
			else
				i--;
		}
		for (int i=0; i<nAuto; i++) {
			int cooY = NumeriCasuali.estraiIntero(0, strada.length-1);
			int cooX = NumeriCasuali.estraiIntero(0, strada[cooY].length-1);
			if(strada[cooY][cooX] instanceof Vuoto)
				strada[cooY][cooX]= new Auto(new Coordinate(cooY,cooX));
			else
				i--;
		}
	}
	
	/**
	 * Riempie casualmente la strada con pedoni e auto
	 */
	public void riempiCasuale() {
		int areaStrada = strada.length*strada[0].length;
		int pedoni = 0;
		int auto = 0;
		
		for (int i=0; i<areaStrada; i++) {
			double casuale = Math.random();
			if (casuale < PROB_AUTO) {
				auto++;
			}
			else
			if (casuale < PROB_PEDONE+PROB_AUTO) {
				pedoni++;
			}
		}
		
		riempiCasuale(pedoni, auto);
	}
	
	/**
	 * Genera una stringa, di lunghezza variabile, rappresentante la delimitazione della carreggiata della strada
	 * @return
	 */
	private String generaDelineatoreBanchina() {
		StringBuffer stringa = new StringBuffer();
			for (int i=0; i<strada[0].length; i++) {
				stringa.append(SIMBOLO_DEL_CARREGGIATA);
			}
			stringa.append(NEW_LINE);
			return stringa.toString();
	}
	
	/**
	 * Genera una stringa rappresentante la strada
	 * @return Stringa rappresentante la strada
	 */
	public String toString() {
		StringBuffer stringaStrada = new StringBuffer();
		stringaStrada.append(generaDelineatoreBanchina());
		for (int i=0; i<strada.length; i++) {
			for (int j=0; j<strada[i].length; j++) {
				stringaStrada.append(strada[i][j].toString() + " ");
			}
			stringaStrada.append(NEW_LINE);
		}
		stringaStrada.append(generaDelineatoreBanchina());
		return stringaStrada.toString();
	}

}
