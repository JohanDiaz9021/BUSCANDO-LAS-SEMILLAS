package model;

public class Node {
	private String players;
	private int row;
	private int col;
	private String semillas;
	private String enlaces;
	private int pos;
	private Node next;
	private Node prev;
	
	
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param po position 
	 */
	public Node(int po) {
		pos = po;
		semillas = " ";
		enlaces = " ";
		players = "";
	}

	//________________________________
	 /**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return row
	 */
	public int getRow() {
		return row;
	}
	
	//________________________________
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return col
	 */
	public int getCol() {
		return col;
	}
	
	//________________________________
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return 'A' + col
	 */
	public char getNameCol() {
		return (char) ('A' + col);
	}

	
	
	//________________________________
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return next
	 */
	
	public Node getNext() {
		return next;
	}
	
	
	//________________________________
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param n: next nodo
	 */
	public void setNext(Node n) {
		next = n;
	}
	
	
	//________________________________
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return prev
	 */
	public Node getPrev() {
		return prev;
	}
	
	
	//________________________________
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param p: previous nodo
	 */
	public void setPrev(Node p) {
		prev = p;
	}
	
	
	

	/**
	 * shoe information about 1 space where the position , the snake or the ladder is located <br>
	 * <b> pre: the data of the position, that ladder or snake </b>  
	 * @return A message with position, ladder or snake
	 */
	public String toString() {
		return "[" + pos + enlaces+semillas + "\t]";
	}
	
	
	//________________________________
	
	/**
	 * shoe information about 1 space where the  player, the snake or the ladder is located <br>
	 * <b> pre: the data of the position, that ladder or snake </b>  
	 * @return A message with player, ladder or snake
	 */
	public String toString2() {
		return "[" + players+enlaces+semillas + "\t]";
	}
	
	//________________________________
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return pos
	 */
	public int getPos() {
		return pos;
	}
	
	//________________________________
	
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param pos: position
	 */
	public void setPos(int pos) {
		this.pos = pos;
	}
	
	//________________________________
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return snake
	 */
	public String getEnlace() {
		return enlaces;
	}
	
	//________________________________
	
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param snakeColum: snake position in column
	 */
	public void setEnlace(String snakeColum) {
		this.enlaces = snakeColum;
	}
	
	//________________________________
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return lader
	 */
	public String getSemilla() {
		return semillas;
	}
	
	//________________________________
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param lader: the ladder
	 */
	public void setSemilla(String lader) {
		this.semillas = lader;
	}
	
	//________________________________
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return players
	 */
	public String getPlayers() {
		return players;
	}
	
	//________________________________
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param players: where is the player
	 */
	public void setPlayers(String players) {
		this.players = players;
	}
}
