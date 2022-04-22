package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	private static  Menu menu;

	public Main() throws FileNotFoundException, ClassNotFoundException, IOException {
		menu = new Menu();

	}
	public static void main (String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		Main main = new Main();
		main.loadMenu();

		
	}
	private void loadMenu() {
		menu.IniciarJuego();
		
	}

}
