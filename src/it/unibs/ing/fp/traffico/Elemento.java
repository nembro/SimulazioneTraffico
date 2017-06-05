package it.unibs.ing.fp.traffico;

public abstract class Elemento {
	
	private Coordinate coordinate;
	private Direzioni direzione;
	private int velocita;
	private int resistenza;
	
	public Elemento(Coordinate coo, Direzioni direzione, int velocita, int resistenza) {
		this.coordinate = coo;
		this.direzione = direzione;
		this.velocita = velocita;
		this.resistenza = resistenza;
	}
	
	public int getResistenza() {
		return resistenza;
	}
	
	public boolean prevaleSu(Elemento elemento2) {
		if (resistenza > elemento2.getResistenza()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public abstract Coordinate getProssimaPosizione();
	
	public boolean CollisioneCon(Elemento elemento2) {
		if (getProssimaPosizione().equals(elemento2.getProssimaPosizione())) {
			return true;
		}
		else {
			return false;
		}
	}

}
