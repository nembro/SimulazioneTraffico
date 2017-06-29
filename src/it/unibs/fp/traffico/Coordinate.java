package it.unibs.fp.traffico;

public class Coordinate {
	
	private int x;
	private int y;
	
	private static final String FORMAT_TOSTRING = "RIGA:%d;COLONNA:%d";
	
	
	public Coordinate(int y, int x) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	

	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	
	
	public boolean equals(Coordinate coo) {
		if (x==coo.getX() && y==coo.getY()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean staDentro(int y, int x) {
		return ((this.y < y) && (this.x < x));
	}
	
	public int getRiga() {
		return getY();
	}
	
	public int getColonna() {
		return getX();
	}
	
	public String toString() {
		return String.format(FORMAT_TOSTRING, y+1, x+1);
	}
	
	public void incrementaX() {
		x++;
	}
	
	public void incrementaY() {
		y++;
	}
	
	
	
	

}
