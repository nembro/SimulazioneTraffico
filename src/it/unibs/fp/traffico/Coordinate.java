package it.unibs.fp.traffico;

/**
 * 
 * @author Magri Bortolo
 * @author Nembrini Marco
 * @author Oldani Federico
 * 
 */
public class Coordinate {
	
	private int x;
	private int y;
	
	private static final String FORMAT_TOSTRING = "RIGA:%d;COLONNA:%d";
	
	/**
	 * Costruttore oggetto Coordinate
	 * @param y
	 * @param x
	 */
	public Coordinate(int y, int x) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Restituisce valore della coordinata x
	 * @return x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Restituisce valore della coordinata y
	 * @return y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Imposta il valore della coordinata x
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Imposta il valore della coordinata y
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Confronta due coordinate
	 * @param coo altra coordinata
	 * @return <i>true</i> se uguali, <i>false</i> altrimenti
	 */
	public boolean equals(Coordinate coo) {
		if (x==coo.getX() && y==coo.getY()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Verifica che delle coordinate non siano maggiori di quelle passate come argomento
	 * @param y
	 * @param x
	 * @return <i>true</i> se interno, <i>false</i> altrimenti
	 */
	public boolean staDentro(int y, int x) {
		return ((this.y < y) && (this.x < x));
	}
	
	/**
	 * Restituisce valore della riga (coordinata y)
	 * @return y
	 */
	public int getRiga() {
		return getY();
	}
	
	/**
	 * Restituisce valore della coordinata colonna (coordinata x)
	 * @return x
	 */
	public int getColonna() {
		return getX();
	}
	
	/**
	 * Genera stringa riportante informazioni sulla coordinata nel seguente formato: RIGA:<i>riga</i>;COLONNA:<i>colonna</i>
	 * numerazione righe e colonne a partire da 1
	 */
	public String toString() {
		return String.format(FORMAT_TOSTRING, y+1, x+1);
	}
	
	/**
	 * Incrementa il valore della x di un'unità
	 */
	public void incrementaX() {
		x++;
	}
	
	/**
	 * Incrementa il valore della y di un'unità
	 */
	public void incrementaY() {
		y++;
	}
	
	
	
	

}
