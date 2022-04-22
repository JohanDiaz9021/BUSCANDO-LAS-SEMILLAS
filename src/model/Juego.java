package model;

public class Juego {
	private Tablero tablero ;
	private int positionA;
	private int positionB;
	public final static String enlacesPrincipales = "ABCDEFGHIJKLMÑOPQRSTW";
	
	public Juego() {
		positionA = 0;
		positionB = 1;
	}
	
	public String printBoard(int col, int row, String players) {
		tablero = new Tablero(row, col, players);
		String out = tablero.prePrint();
		return out;
	}
}
