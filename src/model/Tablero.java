package model;

public class Tablero {
	private Nodo first;
	private int numeroColumnas ;
	private int numeroFilas;
	private int semillas;
	private int enlaces;
	private int tamanioTablero;
	public Tablero(int numeroFilas, int numeroColum, int enlaces2, int semillas2) {
		setNumeroColumnas(numeroColum);
		this.setNumeroFilas(numeroFilas);
		setEnlaces(enlaces2);
		setSemillas(semillas2);
		tamanioTablero = numeroColum*numeroFilas;
		crearPrimerNodo();
	}
	private void crearPrimerNodo() {
		first = new Nodo(1);
		int posicionRick  = (int) (Math.random() * tamanioTablero);
		int posicionMorty  = (int) (Math.random() * tamanioTablero);
		if(posicionMorty == 1) {
			first.setJugadores("M");
		}
		if(posicionRick ==1) {
			first.setJugadores("R");
		}
		
		
		first.setPrev(crearTablero(first, 1,posicionMorty,posicionRick));
		first.getPrev().setNext(first);
		
	}
	private Nodo crearTablero(Nodo first2, int i, int posicionMorty, int posicionRick) {
		if (i < tamanioTablero) {
			i++;
			Nodo nuevo = new Nodo(i);
			if(i == posicionMorty) {
				nuevo.setJugadores("M");
			}
			if(i == posicionRick) {
				nuevo.setJugadores("R");
			}
			first2.setNext(nuevo);
			nuevo.setPrev(first2);
			crearTablero(nuevo, i, posicionMorty,  posicionRick);
		}
		return first2;
	}
	public int getNumeroFilas() {
		return numeroFilas;
	}
	public void setNumeroFilas(int numeroFilas) {
		this.numeroFilas = numeroFilas;
	}
	public int getNumeroColumnas() {
		return numeroColumnas;
	}
	public void setNumeroColumnas(int numeroColumnas) {
		this.numeroColumnas = numeroColumnas;
	}
	public int getEnlaces() {
		return enlaces;
	}
	public void setEnlaces(int enlaces) {
		this.enlaces = enlaces;
	}
	public int getSemillas() {
		return semillas;
	}
	public void setSemillas(int semillas) {
		this.semillas = semillas;
	}
	public void imprimir() {
		String texto = "";
		imprimirTablero(texto, first, 1, 1, 0);
		
	}
	private String imprimirTablero(String texto, Nodo first2, int i, int j, int k) {
		if (k < tamanioTablero - 2) {
			k++;
			if (j == 1) {
				String out3 = "";
				String out2 = recorridoSiguiente(first2, i, out3);
				texto = out2 + "\n" + texto;
				j = 2;
				first2 = recorridoNodos(first2, 1, texto);
				if (first2 != null) {
					texto = imprimirTablero(texto, first2, i, j, k);
				}
			} else {
				String out3 = "";
				String out2 = recorridoPrevio(first2, i, out3);
				texto = out2 + "\n" + texto;
				j = 1;
				first2 = recorridoNodos(first2, 1, texto);
				if (first2 != null) {
					texto = imprimirTablero(texto, first2, i, j, k);
				}
			}
		}
		return texto;
	}
	public String recorridoSiguiente(Nodo first2, int num2, String out) {
		if (num2 <= numeroColumnas) {
			out = out + " " + first2.toString();
			first2 = first2.getNext();
			num2++;
			out = recorridoSiguiente(first2, num2, out);
		}

		return out;
	}
	public Nodo recorridoNodos(Nodo first2, int num2, String out) {
		if (num2 <= numeroColumnas) {
			first2 = first2.getNext();
			num2++;
			first2 = recorridoNodos(first2, num2, out);
		}
		return first2;
	}
	
	public String recorridoPrevio(Nodo first2, int num2, String out) {
		if (num2 <= numeroColumnas) {
			out = first2.toString() + " " + out;
			num2++;
			out = recorridoPrevio(first2.getNext(), num2, out);
		}
		return out;
	}

}
