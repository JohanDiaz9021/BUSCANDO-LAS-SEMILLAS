package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.util.Scanner;

import model.Game;
import model.Players;

public class Menu {
	private Scanner scanner;
	private Game juego;
	private long inicio;
	private long finali;
	private ArrayList<Players> players;
	private final static String SAVE_PLAYER = "data/player.txt";

	public Menu() throws FileNotFoundException, ClassNotFoundException, IOException {
		
		players = new ArrayList<Players>();
		
		scanner = new Scanner(System.in);
		juego = new Game();

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
			inicio = System.currentTimeMillis();
			loadData();
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
					"\nEl numero de Semillas y Enlaces es superior al numero de celdas o causa conflicto\n");
			// menu(num);
		}
	}

	public String players(String out, int numP) {
		out="R"+"M";
		return out;
	}

	private void go(int columnas, int filas, int enlasces, int semillas, String num4, int players, int ini, char ch,
			boolean win) throws InterruptedException, FileNotFoundException, IOException, ClassNotFoundException {
		juego.printValue();
		if(win == false) {
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
						System.out.println("Desea que su ficha\n" + "1. Avance\n" + "2. Retroceda\n");
						int opcion2 = scanner.nextInt();
						switch (opcion2) {
						case 1:
							if (juego.movePlayer("R",
									numMoves) == true) {
								win = true;
								System.out.println("****  FIN DEL JUEGO  ****");
								double tiempo = (double) ((finali - inicio) / 1000);
								guardarJugador(tiempo);
								System.out.println("GANADORES : \n" + jugadores());
								win = true;
								finali = System.currentTimeMillis();
							} else {

								if (players > 1) {
									ini++;
								}
							}
							break;

						case 2:
							if (juego.movePlayerPrev(
									juego.play(columnas, filas, enlasces, semillas, num4, players, ini, ch),
									numMoves) == true) {
								win = true;
								System.out.println("****  FIN DEL JUEGO  ****");
								double tiempo = (double) ((finali - inicio) / 1000);
								guardarJugador(tiempo);
								System.out.println("GANADORES : \n" + jugadores());
								
								finali = System.currentTimeMillis();
							} else {

								if (players > 1) {
									ini++;
								}
							}
							break;
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
				if (win == false) {
					boolean run = true;
					while (run) {
						System.out.println(juego.play(columnas, filas, enlasces, semillas, num4, players, ini, ch)
								+ " jugador N  : " + "Morty");
						System.out.println(
								"1. Tirar dado\r\n" + "2. Ver tablero\r\n" + "3. Ver enlaces\r\n" + "4. Marcador\r\n");
						int opcion = scanner.nextInt();

						switch (opcion) {
						case 1:

							System.out.println("Enter para tirar dados");// giving the user a chance to roll
							scanner.nextLine();// waiting for enter key
							int numMoves = juego.rollDice();
							System.out.println(numMoves + " <= resultado dado ");
							System.out.println("\n");
							System.out.println("Desea que su ficha\n" + "1. Avance\n" + "2. Retroceda\n");
							int opcion2 = scanner.nextInt();
							switch (opcion2) {
							case 1:
								if (juego.movePlayer(
										"M",
										numMoves) == true) {
									
									win = true;
									finali = System.currentTimeMillis();
									System.out.println("****  FIN DEL JUEGO  ****");
									double tiempo = (double) ((finali - inicio) / 1000);
									guardarJugador(tiempo);
									System.out.println("GANADORES : \n" + jugadores());
								} else {
									ini++;
									if (ini == players) {
										ini = 0;

									}

								}
								break;

							case 2:
								if (juego.movePlayerPrev(
										juego.play(columnas, filas, enlasces, semillas, num4, players, ini, ch),
										numMoves) == true) {

									win = true;
									finali = System.currentTimeMillis();
									System.out.println("****  FIN DEL JUEGO  ****");
									double tiempo = (double) ((finali - inicio) / 1000);
									guardarJugador(tiempo);
									System.out.println("GANADORES : \n" + jugadores());
								} else {
									ini++;
									if (ini == players) {
										ini = 0;

									}

								}
								break;
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
			}
			if (win == false) {
				
				go(columnas, filas, enlasces, semillas, num4, players, ini, ch, win);
			}
		}
	}

	
	
	
	
	
	private void guardarJugador(double tiempo) throws FileNotFoundException, IOException {
		String name = "";
		if (juego.rick() > juego.morty()) {
			System.out.println("El ganador fue : Rick obtuvo" + juego.rick());
			scanner.nextLine();
			System.out.println("Escriba Su nombre ");
			name = scanner.nextLine();
			double puntaje = juego.rick() * 120 - tiempo;
			recorridoDeGuardar("Rick", name, puntaje);
		} else {
			if (juego.rick() < juego.morty()) {
				System.out.println("El ganador fue  Morty  obtuvo " + juego.morty());
				scanner.nextLine();
				System.out.println("Escriba Su nombre ");
				
				name = scanner.nextLine();
				double puntaje = juego.rick() * 120 - tiempo;
				recorridoDeGuardar("Morty", name, puntaje);
			} else {
				System.out.println(" COMO HAN EMPATADO NO SE GUARDAN ");
				
			}
		}
		saveData();
	}

	private void recorridoDeGuardar(String string, String name, double puntaje) throws FileNotFoundException, IOException {
		boolean found = true;
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getNickName().equals(name)) {
				players.get(i).setScore(players.get(i).getScore() + puntaje);
				found = false;
			}
		}
		if (found == true) {
			Players player1 = new Players(string, name, puntaje);
			players.add(player1);
		}
		BurbujaColObj(players);
		saveData();
	}
	
	public static void BurbujaColObj(ArrayList<Players> jugador) throws FileNotFoundException, IOException {       
	    Players aux;
	    for(int i = 0;i < jugador.size()-1;i++){
	        for(int j = 0;j < jugador.size()-i-1;j++){
	            // El if de abajo va a determinar si el primero es menor que el segundo
	            // y si es true, se va a realizar el swap con una variable aux para
	            // mover los objetos del array
	            if(jugador.get(j+1).getScore() >  jugador.get(j).getScore()){    
	                aux = jugador.get(j+1);
	                jugador.set(j+1,jugador.get(j));
	                jugador.set(j,aux);
	            }
	        }
	    }
	    
	}
	
	
	public String jugadores() {
		String out = "";
		for(int i = 0;i < players.size() && i< 5; i++) {
			out+= "Jugador "+ players.get(i).getNickName() +" Puntuacion :" + players.get(i).getScore()+"\n";
		}
		return out;
	}
	public long getInicio() {
		return inicio;
	}

	public void setInicio(long inicio) {
		this.inicio = inicio;
	}

	public long getFinali() {
		return finali;
	}

	public void setFinali(long finali) {
		this.finali = finali;
	}

	/**
	 * save the information of the winners <br>
	 * <b> pre: there need to be winners </b>
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public  void saveData() throws FileNotFoundException, IOException {
		ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(SAVE_PLAYER));
		ob.writeObject(players);
		ob.close();
	}

	public ArrayList<Players> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Players> players) {
		this.players = players;
	}

	/**
	 * if the player exists, load the information <br>
	 * <b> pre: that the player has information or that there is </b>
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void loadData() throws IOException, ClassNotFoundException {
		File f = new File(SAVE_PLAYER);
		if (f.exists()) {
			ObjectInputStream ob = new ObjectInputStream(new FileInputStream(f));
			players = (ArrayList<Players>) ob.readObject();
			ob.close();
		}
	}
}