package it.unibs.fp.traffico;

/**
 * Classe Pedone
 * @author Magri Bortolo
 * @author Nembrini Marco
 * @author Oldani Federico
 * 
 */
public class Pedone extends Elemento {
	
	private final static int VELOCITA = 1;
	private final static int RESISTENZA = 2;
	private final static String SIMBOLO_PEDONE = "*";
	private final static Direzioni DIREZIONE = Direzioni.BASSO;
	
	/**
	 * Costruttore oggetto Pedone con posizione specificata
	 * @param coo
	 */
	public Pedone(Coordinate coo) {
		super(coo, DIREZIONE, VELOCITA, RESISTENZA, true);
	}
	
	/**
	 * Costruttore oggetto Pedone con posizione (0,0)
	 */
	public Pedone() {
		super(new Coordinate(0,0) ,DIREZIONE, VELOCITA, RESISTENZA, true);
	}
	
	/**
	 * Restituisce stringa rappresentante elemento Pedone
	 * @return stringa rappresentante elemento Pedone *
	 */
	public String toString() {
		return SIMBOLO_PEDONE;
	}

}