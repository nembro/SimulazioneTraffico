package it.unibs.fp.traffico;

/**
 * Classe Elemento
 * @author Magri Bortolo
 * @author Nembrini Marco
 * @author Oldani Federico
 * 
 */
public abstract class Elemento {
	
	
	private Coordinate coordinate;
	private Direzioni direzione;
	private int velocita;
	private int resistenza;
	private boolean solido;
	
	/**
	 * Costruttore oggetto Elemento
	 * @param direzione
	 * @param velocita
	 * @param resistenza
	 * @param solido
	 */
	public Elemento(Direzioni direzione, int velocita, int resistenza, boolean solido) {
		this.direzione = direzione;
		this.velocita = velocita;
		this.resistenza = resistenza;
		this.solido = solido;
	}
	
	/**
	 * Costruttore oggetto Elemento
	 * @param coo
	 * @param direzione
	 * @param velocita
	 * @param resistenza
	 * @param solido
	 */
	public Elemento(Coordinate coo, Direzioni direzione, int velocita, int resistenza, boolean solido) {
		this(direzione, velocita, resistenza, solido);
		this.coordinate = coo;
	}

	/**
	 *
	 * @return direzione
	 */
	public Direzioni getDirezione() {
		return direzione;
	}
	
	/**
	 * Restituisce le cordinate dell'elemento
	 * @return oggetto Coordinate
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	/**
	 * Confronta due oggetti di tipo Elemento per determinare chi possiede una resistenza maggiore
	 * @param elemento2
	 * @return <i>true</i> se ha maggiore resistenza rispetto ad elemento2, <i>false</i> altrimenti 
	 */
	public boolean prevaleSu(Elemento elemento2) {
		if (resistenza > elemento2.resistenza) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Modifica le coordinate
	 * @param coo nuove cordinate
	 */
	public void modificaPosizione(Coordinate coo) {
		coordinate.setX(coo.getX());
		coordinate.setY(coo.getY());
	}
	
	/**
	 * Restituisce la prossima posizione dell'Elemento
	 * @return nuovaPosizione (le nuoveCoordinate)
	 */
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
	
	/**
	 * Restituisce la prossima posizione dell'Elemento
	 * @param x cordinata X attuale
	 * @param y coordinata Y attuale
	 * @return nuovaPosizione (le nuoveCoordinate)
	 */
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
	
	/**
	 * Verifica se avviene una collisione tra due elementi in base al fatto
	 * che siano classificati come <i>solido</i> o meno
	 * la verifica avviene indipendentemente dalla posizione!
	 * @param elemento2
	 * @return <i>true</i> se si verifica una collisione, <i>false</i> altrimenti
	 */
	public boolean collisioneCon(Elemento elemento2) {
		if (solido && elemento2.solido) {
			return true;
		}
		else {
			return false;
		}
	}

}
