package model;

public class Juego {
	private Tablero tablero ;
	
	public void CrearTablero(int numeroColum, int numeroFilas, int enlaces, int semillas) {
		tablero = new Tablero(numeroFilas, numeroColum,enlaces,semillas);
		
	}

}
