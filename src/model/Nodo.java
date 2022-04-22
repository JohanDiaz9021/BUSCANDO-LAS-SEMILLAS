package model;

public class Nodo {
	private String jugadores;
	private String semilla;
	private String enlace;
	private int posicion;	
	private Nodo next;
	private Nodo prev;
	public Nodo(int posicion) {
		this.posicion = posicion;
		semilla =" ";
		enlace=" ";
		jugadores =" ";
	}
	
	
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public String getJugadores() {
		return jugadores;
	}
	public void setJugadores(String jugadores) {
		this.jugadores = jugadores;
	}
	public String getSemilla() {
		return semilla;
	}
	public void setSemilla(String semilla) {
		this.semilla = semilla;
	}
	public String getEnlace() {
		return enlace;
	}
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
	public Nodo getNext() {
		return next;
	}
	public void setNext(Nodo next) {
		this.next = next;
	}
	public Nodo getPrev() {
		return prev;
	}
	public void setPrev(Nodo prev) {
		this.prev = prev;
	}

}
