package model;

import java.io.Serializable;

public class Players implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nickName;
	private String symbol;
	private int score;
	private Players left;
	private Players right;
	private String caracters;
	
	
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param n Player's name
	 * @param s player's symbol
	 * @param sc player's  score
	 */
	public  Players(String n,String s,int sc,String ca) {
		nickName = n;
		symbol= s;
		score= sc;
		caracters = ca;
	}
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return score
	 */
	public int getScore() {
		return score;
	}
	
	//________________________________
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param score: player score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	//________________________________
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	
	//________________________________
	
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param symbol: player symbol
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	//________________________________
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return nickName
	 */
	public String getNickName() {
		return nickName;
	}
	
	//________________________________
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param nickName:  name
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
	//________________________________
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return left
	 */
	public Players getLeft() {
		return left;
	}
	
	//________________________________
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return right
	 */
	public Players getRight() {
		return right;
	}
	
	//________________________________
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param 1: move one square to the left
	 */
	public void setLeft(Players l) {
		left = l;
	}
	
	//________________________________
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param r: move one square to the right
	 */
	public void setRight(Players r) {
		right = r;
	}
	
	//________________________________
	
	/**
	 * show player information on screen<br>
	 * <b> pre: we need the player's information </b> 
	 * @return a message showing all the information of the players
	 */
	public String data() {
		String out =	"Nombre: "+this.nickName+" Simbolo: "+symbol+" Puntaje: "+score+" Jugadores: "+caracters ;
		return out;
		
	}
	
	//________________________________
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return caracters
	 */
	public String getCaracters() {
		return caracters;
	}
	
	//________________________________
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param caracters: player token
	 */
	public void setCaracters(String caracters) {
		this.caracters = caracters;
	}
}
