package it.unibs.fp.traffico;

/**
 * Classe elemento Vuoto
 * @author Magri Bortolo
 * @author Nembrini Marco
 * @author Oldani Federico
 * 
 */
public class Vuoto extends Elemento {
	
	private final static int VELOCITA = 0;
	private final static int RESISTENZA = 0;
	private final static String SIMBOLO_VUOTO = " ";
	private final static Direzioni DIREZIONE = Direzioni.INDEFINITA;
	
	/**
	 * Costruttore oggetto Vuoto con posizione specificata
	 * @param coo
	 */
	public Vuoto(Coordinate coo) {
		super(coo, DIREZIONE, VELOCITA, RESISTENZA, false);
	}
	
	/**
	 * Costruttore oggetto Vuoto con posizione (0,0)
	 */
	public Vuoto() {
		super(DIREZIONE, VELOCITA, RESISTENZA, false);
	}
	
	/**
	 * Restituisce stringa rappresentante elemento Vuoto
	 * @return stringa rappresentante elemento Vuoto
	 */
	public String toString() {
		return SIMBOLO_VUOTO;
	}

	
}