package model;

public class Tablero {
	private Nodo first;
	private int numeroColumnas ;
	private int numeroFilas;
	private int semillas;
	private int enlaces;
	private int tamanioTablero;
	
	public Tablero(int row, int col, String players) {
		numeroColumnas = col;
		numeroFilas = row ;
		tamanioTablero = numeroColumnas * numeroFilas;
		semillas = 0;
		enlaces = 0;
		createMatrix(players);
	}
	
	public void createMatrix(String players) {
		
		first = new Nodo(1);
		first.setJugadores(players);
		
		createdBoard(first, 1);

	}
	private Nodo createdBoard(Nodo first1, int i) {
		if (i < tamanioTablero) {
			i++;
			Nodo current = new Nodo(i);
			first1.setNext(current);
			current.setPrev(first1);
			createdBoard(current, i);
		}
		return first1;
	}
	public String prePrint() {
		String out2 = "";
		String out = printBoard(out2, first, 1, 1, 0);
		return out;
	}
	public String printBoard(String out, Nodo first2, int num, int num2, int num3) {
		if (num3 < tamanioTablero - 2) {
			num3++;
			if (num2 == 1) {
				String out3 = "";
				String out2 = recordNext(first2, num, out3);
				out = out2 + "\n" + out;
				num2 = 2;
				first2 = recordNode(first2, 1, out);
				if (first2 != null) {
					out = printBoard(out, first2, num, num2, num3);
				}
			} else {
				String out3 = "";
				String out2 = recordPrev(first2, num, out3);
				out = out2 + "\n" + out;
				num2 = 1;
				first2 = recordNode(first2, 1, out);
				if (first2 != null) {
					out = printBoard(out, first2, num, num2, num3);
				}
			}
		}
		return out;
	}
	public String recordNext(Nodo first2, int num2, String out) {
		if (num2 <= numeroColumnas) {
			out = out + " " + first2.toString();
			first2 = first2.getNext();
			num2++;
			out = recordNext(first2, num2, out);
		}

		return out;
	}
	public Nodo recordNode(Nodo first2, int num2, String out) {
		if (num2 <= numeroColumnas) {
			first2 = first2.getNext();
			num2++;
			first2 = recordNode(first2, num2, out);
		}
		return first2;
	}
	public String recordPrev(Nodo first2, int num2, String out) {
		if (num2 <= numeroColumnas) {
			out = first2.toString() + " " + out;
			num2++;
			out = recordPrev(first2.getNext(), num2, out);
		}
		return out;
	}
	
	

	
	
}
