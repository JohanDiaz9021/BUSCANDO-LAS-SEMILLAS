package model;

import java.util.Random;
import java.util.Scanner;

public class Game {

	public final static String SPLIT = " ";

	Scanner scanner = new Scanner(System.in);
	private int positionA;
	private int positionB;
	public final static String enlaces = "ABCDEFGHIJKLNOPQSTW";
	private Board board;
	

	public Game() {
		positionA = 0;
		positionB = 1;
	
	}

	/**
	 * just the board <br>
	 * <b> pre: the number of rows and columns </b>
	 * 
	 * @param col
	 * @param row
	 * @param players
	 * @return
	 */
	public String printBoard(int col, int row, String players, int value) {
		board = new Board(row, col, players, value);
		String out = board.prePrint();
		return out;
	}

	/**
	 * full board <br>
	 * <b> pre: all data </b>
	 * 
	 * @return
	 */

	public String printB() {
		String out = board.prePrint();
		return out;
	}

	/**
	 * // tablero con los valores <br>
	 * <b> pre: all data </b>
	 * 
	 * @return
	 */
	public String printValue() {
		String out = board.prePrint2();
		return out;
	}

	/**
	 * start the game <br>
	 * <b> pre: is in charge of playing </b>
	 * 
	 * @param columna
	 * @param fila
	 * @param enlaces
	 * @param semillas
	 * @param num4
	 * @param players
	 * @param ini
	 * @param ch
	 * @return out
	 */
	public String play(int columna, int fila, int enlaces, int semilla, String num4, int players, int ini, char ch) {
		String out = "";
		if (ini == 0) {
			ch = num4.charAt(num4.length() - players);
			out = (ch + "");
			ini++;
		} else {
			int value = players - ini;
			ch = num4.charAt(num4.length() - value);
			out = (ch + "");
			ini++;

			if (ini == players) {
				ini = 0;

			}
		}

		return out;
	}

	/**
	 * generate a random number from 1 to 6 <br>
	 * <b> pre: you need the library and the method to automatically generate </b>
	 * 
	 * @return num returns the number of the dice randomly
	 */
	public int rollDice() {
		Random rand = new Random();
		int num = rand.nextInt((6 - 1) + 1) + 1;

		return num;
	}

	/**
	 * print the board <br>
	 * <b> pre: rows and columns are needed </b>
	 * 
	 * @param fila
	 * @param columna
	 * @param fila1
	 * @param columna1
	 * @param cuadros
	 * @param out
	 * @param count
	 * @param out2
	 */
	public void printBoard(int fila, int columna, int fila1, int columna1, int cuadros, String out, int count,
			String out2) {
		if (cuadros >= 1) {
			if (fila >= fila1) {

				if (columna >= columna1) {
					columna1++;
					out = " " + count + " ";
					out2 = out2 + out;
				} else {

					fila1++;
					columna1 = 2;
				}
			}
			count++;
			cuadros--;
			printBoard(fila, columna, fila1, columna1, cuadros, out, count, out2);
		} else if (cuadros == 0) {

		}
	}

	/**
	 * returns the player's movement and symbol<br>
	 * <b> pre:is takes care of getting the board through recursion </b>
	 * 
	 * @return board
	 */
	public Board getboard() {
		return board;
	}

	/**
	 * returns the player's movement and symbol<br>
	 * <b> pre:is responsible for linking the positions of the seeds </b>
	 * 
	 * @param colum
	 * @param rows
	 * @param numEnlaces
	 * @param rand
	 * @param vale
	 */
	public void enalcesPosition(int colum, int rows, int numEnlaces, int rand, int value) {
		if (numEnlaces > 0) {
			int position = rand;
			int total = colum * rows;
			if (position > 1 && position < total) {
				String let = enlaces.substring(positionA, positionB);
				if (board.positionEnlaces(position, let) == false) {
					rand = (int) (Math.random() * value) + 2;
					enalcesPosition(colum, rows, numEnlaces, rand, value);
				} else {
					numEnlaces--;
					positionA++;
					positionB++;

					int mul = 1;
					int val = foundPostition(position, colum, mul);
					int positionMax = val * colum;
					int positionMin = 0;
					if (val > 1) {
						val = val - 1;
						positionMin = colum * val;
					} else {
						positionMin = 1;
					}
					enlacesPositionB(colum, rows, position, let, value, positionMax, positionMin);
					rand = (int) (Math.random() * value) + 2;
					enalcesPosition(colum, rows, numEnlaces, rand, value);
				}
			} else {
				rand = (int) (Math.random() * value) + 2;
				enalcesPosition(colum, rows, numEnlaces, rand, value);
			}
		}
	}

	/**
	 * returns the player's movement and symbol<br>
	 * <b> pre: is responsible for linking the positions of the seeds </b>
	 * 
	 * @param position
	 * @param col
	 * @param value
	 * @return value
	 */
	public int foundPostition(int position, int col, int value) {
		int num = col * value;
		if (num < position) {
			value++;
			value = foundPostition(position, col, value);
		}
		return value;
	}

	/**
	 * returns the player's movement and symbol<br>
	 * <b> pre: is responsible for linking the positions of the seedsB </b>
	 * 
	 * @param colum
	 * @param rows
	 * @param posA
	 * @param let
	 * @param value
	 * @param positionMax
	 * @param positionMin
	 */
	public void enlacesPositionB(int colum, int rows, int posA, String let, int value, int positionMax,
			int positionMin) {
		int position = (int) (Math.random() * value) + 2;
		int total = colum * rows;
		if (position > 1 && position < total) {
			if (position < positionMin || position > positionMax) {
				if (board.positionEnlaces(position, let) == false) {
					enlacesPositionB(colum, rows, posA, let, value, positionMax, positionMin);
				}
			} else {
				enlacesPositionB(colum, rows, posA, let, value, positionMax, positionMin);
			}
		} else {
			enlacesPositionB(colum, rows, posA, let, value, positionMax, positionMin);
		}
	}

	/**
	 * returns the player's movement and symbol<br>
	 * <b> pre: takes care of seed positions </b>
	 * 
	 * @param position
	 * @param colum
	 * @param rows
	 * @param numSemillas
	 * @param rand
	 * @param value
	 * @param total
	 */
	public void semillasPosition(int colum, int rows, int numSemillas, int rand, int value) {
		if (numSemillas > 0) {

			int position = rand;
			int total = colum * rows;
			if (position > 1 && position < total) {

				String let = "*";
				if (board.positionSemillas(position, let) == false) {
					rand = (int) (Math.random() * value) + 2;
					semillasPosition(colum, rows, numSemillas, rand, value);
				} else {
					numSemillas--;
					int mul = 1;
					int val = foundPostition(position, colum, mul);

					if (val > 1) {
						val = val - 1;

					}
					rand = (int) (Math.random() * value) + 2;
					semillasPosition(colum, rows, numSemillas, rand, value);
				}
			} else {
				rand = (int) (Math.random() * value) + 2;
				semillasPosition(colum, rows, numSemillas, rand, value);
			}
		}
	}

	/**
	 * returns the player's movement and symbol<br>
	 * <b> pre: you need to have entered each player's symbol </b>
	 * 
	 * @param symbol
	 * @param position
	 * @return lm.foundPlayer(symbol, position)
	 */
	public boolean movePlayer(String symbol, int position) {
		
		return board.foundPlayer(symbol, position);

	}

	public boolean movePlayerPrev(String symbol, int position) {
		return board.foundPlayerPrev(symbol, position);

	}

	/**
	 * returns the player's score and symbol<br>
	 * <b> pre: takes care of changing the seeds</b>
	 * 
	 * @param newNumSemillas
	 */
	public void changeSemillas(int newNumSemillas) {
		board.setSemillas(newNumSemillas);
	}

	/**
	 * returns the player's score and symbol<br>
	 * <b> pre: the points of both players are obtained</b>
	 * 
	 * @return out
	 */
	public String obtenerPuntos() {
		String out = "";
		out = "Puntos de Rick " + board.getPlayerR() + "\n";
		out += "Puntos de Morty " + board.getPlayerM() + "\n";
		return out;
	}

	public int rick() {
	int out =	board.getPlayerR();
	return out;
	}

	public int morty() {
		int out =	board.getPlayerM();
		return out;
	}
}
