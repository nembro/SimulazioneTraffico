package it.unibs.fp.traffico;

public class Auto extends Elemento {
	
	private final static int VELOCITA = 2;
	private final static int RESISTENZA = 1;
	private final static String SIMBOLO_AUTO = ">";
	private final static Direzioni DIREZIONE = Direzioni.AVANTI;
	
	public Auto(Coordinate coo) {
		super(coo, DIREZIONE, VELOCITA, RESISTENZA, true);
	}
	
	public Auto() {
		super(new Coordinate(0,0),DIREZIONE, VELOCITA, RESISTENZA, true);
	}
	
	public String toString() {
		return SIMBOLO_AUTO;
	}

}
