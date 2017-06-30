package it.unibs.fp.traffico;

/**
 * Classe Auto
 * @author Magri Bortolo
 * @author Nembrini Marco
 * @author Oldani Federico
 * 
 */
public class Auto extends Elemento {
	
	private final static int VELOCITA = 2;
	private final static int RESISTENZA = 1;
	private final static String SIMBOLO_AUTO = ">";
	private final static Direzioni DIREZIONE = Direzioni.AVANTI;
	
	/**
	 * Costruttore oggetto Auto con posizione specificata
	 * @param coo
	 */
	public Auto(Coordinate coo) {
		super(coo, DIREZIONE, VELOCITA, RESISTENZA, true);
	}
	
	/**
	 * Costruttore oggetto Vuoto con posizione (0,0)
	 */
	public Auto() {
		super(new Coordinate(0,0),DIREZIONE, VELOCITA, RESISTENZA, true);
	}
	
	/**
	 * Restituisce stringa rappresentante elemento Auto
	 * @return stringa rappresentante elemento Auto >
	 */
	public String toString() {
		return SIMBOLO_AUTO;
	}

}
