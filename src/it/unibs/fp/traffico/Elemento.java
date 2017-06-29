package it.unibs.fp.traffico;

public abstract class Elemento {
	
	private Coordinate coordinate;
	private Direzioni direzione;
	private int velocita;
	private int resistenza;
	private boolean solido;
	
	public Elemento(Direzioni direzione, int velocita, int resistenza, boolean solido) {
		this.direzione = direzione;
		this.velocita = velocita;
		this.resistenza = resistenza;
		this.solido = solido;
	}
	
	public Elemento(Coordinate coo, Direzioni direzione, int velocita, int resistenza, boolean solido) {
		this(direzione, velocita, resistenza, solido);
		this.coordinate = coo;
	}

	
	public Direzioni getDirezione() {
		return direzione;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public boolean prevaleSu(Elemento elemento2) {
		if (resistenza > elemento2.resistenza) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void modificaPosizione(Coordinate coo) {
		coordinate.setX(coo.getX());
		coordinate.setY(coo.getY());
	}
	
	public Coordinate getProssimaPosizione() {
		Coordinate nuovaPosizione = new Coordinate(coordinate.getY(), coordinate.getX());
		for (int i=0; i<velocita; i++)
			switch (direzione) {
			case AVANTI: 
				nuovaPosizione.incrementaX();
				break;
			case BASSO:
				nuovaPosizione.incrementaY();
				break;
			default:
				break;
			}
		return nuovaPosizione;	
	}
	
	public Coordinate getProssimaPosizione(int y, int x) {
		Coordinate nuovaPosizione = new Coordinate(y, x);
		for (int i=0; i<velocita; i++)
			switch (direzione) {
			case AVANTI: 
				nuovaPosizione.incrementaX();
				break;
			case BASSO:
				nuovaPosizione.incrementaY();
				break;
			default:
				break;
			}
		return nuovaPosizione;
	}
	
	public boolean collisioneCon(Elemento elemento2) {
		if (solido && elemento2.solido) {
			return true;
		}
		else {
			return false;
		}
	}

}
