package it.unibs.fp.traffico;

public class Vuoto extends Elemento {
	
	private final static int VELOCITA = 0;
	private final static int RESISTENZA = 0;
	private final static String SIMBOLO_VUOTO = " ";
	private final static Direzioni DIREZIONE = Direzioni.INDEFINITA;
	
	public Vuoto(Coordinate coo) {
		super(coo, DIREZIONE, VELOCITA, RESISTENZA, false);
	}
	
	public Vuoto() {
		super(DIREZIONE, VELOCITA, RESISTENZA, false);
	}
	
	public String toString() {
		return SIMBOLO_VUOTO;
	}

}