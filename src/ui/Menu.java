package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import model.Game;

public class Menu {
	private Scanner scanner;
	public final static String opcionPlayers = "RM";
	private int positionA;
	private int positionB;
	private Game juego;
	public Menu() {
		scanner = new Scanner(System.in);
		juego = new Game();
		positionA = 0;
		positionB = 1;
	}
	public void IniciarJuego() throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException {
		System.out.println("*********************BIENVENIDOS*********************\n");
		int filas = 0;
		int columnas = 0;
		int enlaces = 0;
		int semillas = 0; // ladder
		int players = 2;

		boolean isTrue = true;
		while (isTrue) {
			System.out.println("Debes definir la cantidad de columnas");
			columnas = scanner.nextInt();
			System.out.println("Debes definir la cantidad de filas");
			filas = scanner.nextInt();
			System.out.println("Debes definir la cantidad de semillas");
			semillas = scanner.nextInt();
			if (columnas > 0 && filas > 0 && semillas > 0) {
				isTrue = false;
			} else {
				System.out.println("\nLo siento estos espacios deben ser mayor a 0 \n");
			}

		}
		System.out.println("Debes definir la cantidad de enlaces");
		enlaces = scanner.nextInt();

		String num4 = "";
		int numPlayers = 2;
		String out = "";

		num4 = players(out, numPlayers);
		players = numPlayers;

		int value = 0;
		if (enlaces == 0) {
			value = enlaces * 2;
		}
		int valueTo = columnas * filas;

		if (valueTo - 4 >= value) {

			juego.printBoard(columnas, filas, num4, value);
			juego.changeSemillas(semillas);
			int n = (int) (Math.random() * value) + 2;
			juego.enalcesPosition(filas, columnas, enlaces, n, valueTo);
			// System.out.println(juego.printB());

			juego.semillasPosition(filas, columnas, semillas, n, valueTo);
			// System.out.println(juego.printB());
			scanner.nextLine();
			// System.out.println(juego.printValue());
			boolean win = false;
			juego.changeSemillas(semillas);
			go(columnas, filas, enlaces, semillas, num4, players, 0, 'a', win);

		} else {
			System.out.println(
					"\nEl numero de serpientes y escalera es superior al numero de celdas o causa conflicto\n");
			// menu(num);
		}
	}
	public String players(String out, int numP) {
		if (numP >= 1) {
			out += opcionPlayers.substring(positionA, positionB);
			numP--;
			positionA++;
			positionB++;
			out = players(out, numP);
		}
		return out;
	}
	private void go(int columnas, int filas, int enlasces, int semillas, String num4, int players, int ini, char ch,
			boolean win) throws InterruptedException, FileNotFoundException, IOException, ClassNotFoundException {
		if (ini == 0) {

			boolean run = true;
			while (run) {
				System.out.println(juego.play(columnas, filas, enlasces, semillas, num4, players, ini, ch)
						+ " jugador  : " + "Rick");
				System.out
						.println("1. Tirar dado\r\n" + "2. Ver tablero\r\n" + "3. Ver enlaces\r\n" + "4. Marcador\r\n");
				int opcion = scanner.nextInt();

				switch (opcion) {
				case 1:
					// System.out.println("Enter para tirar dados");// giving the user a chance to
					// roll
					scanner.nextLine();// waiting for enter key
					int numMoves = juego.rollDice();
					System.out.println(numMoves + " <= resultado dado ");
					System.out.println("\n");

					if (juego.movePlayerPrev(juego.play(columnas, filas, enlasces, semillas, num4, players, ini, ch),
							numMoves) == true) {
						System.out.println("****  FIN DEL JUEGO  ****");
						win = true;
					} else {

						if (players > 1) {
							ini++;
						}
					}
					run = false;
					break;
				case 2:
					System.out.println(juego.printValue());

					break;
				case 3:
					System.out.println(juego.printB());

					break;

				case 4:

					System.out.println(juego.obtenerPuntos());
					break;

				}
			}
		} else {
			boolean run = true;
			while (run) {
				System.out.println(juego.play(columnas, filas, enlasces, semillas, num4, players, ini, ch)
						+ " jugador N  : " + "Morty");
				System.out
						.println("1. Tirar dado\r\n" + "2. Ver tablero\r\n" + "3. Ver enlaces\r\n" + "4. Marcador\r\n");
				int opcion = scanner.nextInt();

				switch (opcion) {
				case 1:
					
					System.out.println("Enter para tirar dados");// giving the user a chance to roll
					scanner.nextLine();// waiting for enter key
					int numMoves = juego.rollDice();
					System.out.println(numMoves + " <= resultado dado ");
					System.out.println("\n");
					if (juego.movePlayer(juego.play(columnas, filas, enlasces, semillas, num4, players, ini, ch),
							numMoves) == true) {

						win = true;
						System.out.println("****  FIN DEL JUEGO  ****");
					} else {
						ini++;
						if (ini == players) {
							ini = 0;

						}

					}
					run = false;
					break;
				case 2:
					System.out.println(juego.printValue());

					break;
				case 3:
					System.out.println(juego.printB());

					break;

				case 4:

					System.out.println(juego.obtenerPuntos());
					break;
				}
			}
		}
		if (win == false) {

			go(columnas, filas, enlasces, semillas, num4, players, ini, ch, win);
		}
	}
}