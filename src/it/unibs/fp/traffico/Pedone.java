package it.unibs.fp.traffico;

public class Pedone extends Elemento {
	
	private final static int VELOCITA = 1;
	private final static int RESISTENZA = 2;
	private final static String SIMBOLO_PEDONE = "*";
	private final static Direzioni DIREZIONE = Direzioni.BASSO;
	
	public Pedone(Coordinate coo) {
		super(coo, DIREZIONE, VELOCITA, RESISTENZA, true);
	}
	
	public Pedone() {
		super(new Coordinate(0,0) ,DIREZIONE, VELOCITA, RESISTENZA, true);
	}
	
	public String toString() {
		return SIMBOLO_PEDONE;
	}

}