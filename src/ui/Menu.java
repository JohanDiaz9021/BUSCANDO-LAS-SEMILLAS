package ui;


import java.util.Scanner;

import model.Game;


public class Menu {
	private Scanner scanner;
	public final static String opcionPlayers = "RM";
	private int positionA;
	private int positionB;
	private Game juego;
	public Menu () {
		scanner = new Scanner(System.in);
		juego = new Game();
		positionA = 0;
		positionB = 1;
	}
	public void IniciarJuego() {
		System.out.println("*********************BIENVENIDOS*********************\n");
		int filas = 0;
		int columnas = 0;
		int enlaces = 0;
		int semillas = 0; //ladder
		int players = 2;
		
		boolean isTrue = true;
		while(isTrue) {
			System.out.println("Debes definir la cantidad de columnas");
			 columnas = scanner.nextInt();
			System.out.println("Debes definir la cantidad de filas");
			 filas = scanner.nextInt();
			System.out.println("Debes definir la cantidad de semillas");
			 semillas = scanner.nextInt();
			 if(columnas > 0 && filas > 0 && semillas > 0) {
				isTrue = false; 
			 }else {
				 System.out.println("\nLo siento estos espacios deben ser mayor a 0 \n");
			 }
			
		}
		System.out.println("Debes definir la cantidad de enlaces");
		 enlaces = scanner.nextInt();
		
		 
		 
		 
		 String num4 = "";
		 int numPlayers = 2;
			String out = "";
			
			num4 =players(out,numPlayers );
			players = numPlayers;
			
		
		int value = 0;
		if (enlaces == 0) {
			value = enlaces * 2;
		} 
		int valueTo = columnas * filas;

		if (valueTo - 4 >= value) {

			juego.printBoard(columnas, filas, num4);

			int n = (int) (Math.random() * value) + 2;
			juego.enalcesPosition(filas, columnas, enlaces, n, valueTo);
			System.out.println(juego.printB());
			
			juego.semillasPosition(filas, columnas, semillas, n, valueTo);
			System.out.println(juego.printB());
			scanner.nextLine();
			System.out.println(juego.printValue());
			boolean win = false;
			//m(columns, rows, snakes, ladder, num4, players, 0, 'a', win);

		} else {
			System.out.println(
					"\nEl numero de serpientes y escalera es superior al numero de celdas o causa conflicto\n");
			//menu(num);
		}

	}
	public String players(String out, int numP) {
		if(numP >= 1) {
			out+=opcionPlayers.substring(positionA, positionB);
			numP--;
			positionA++;
			positionB++;
			out=players(out, numP);
		}
		return out;
	}
	
	

}	
