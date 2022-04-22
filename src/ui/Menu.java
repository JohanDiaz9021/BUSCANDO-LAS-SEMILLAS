package ui;

import java.io.Console;
import java.util.Scanner;

import model.Juego;

public class Menu {
	private Scanner scanner;
	private Juego juego;
	public void Menu () {
		scanner = new Scanner(System.in);
		juego = new Juego();
	}
	public void IniciarJuego() {
		System.out.println("*********************BIENVENIDOS*********************\n");
		int numeroColum=0;
		int numeroFilas=0;
		int semillas =0;
		boolean isTrue = true;
		while(isTrue) {
			System.out.println("Debes definir la cantidad de columnas");
			 numeroColum = scanner.nextInt();
			System.out.println("Debes definir la cantidad de filas");
			 numeroFilas = scanner.nextInt();
			System.out.println("Debes definir la cantidad de semillas");
			 semillas = scanner.nextInt();
			 if(numeroColum > 0 && numeroFilas > 0 && semillas > 0) {
				isTrue = false; 
			 }else {
				 System.out.println("\nLo siento estos espacios deben ser mayor a 0 \n");
			 }
			
		}
		System.out.println("Debes definir la cantidad de enlaces");
		int enlaces = scanner.nextInt();
		juego.CrearTablero(numeroColum, numeroFilas,enlaces,semillas);
		System.out.println(juego.printValue());
	}

}	
