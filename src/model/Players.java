package model;

import java.io.Serializable;

public class Players implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nickName;
	private String symbol;
	private double score;

	
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param n Player's name
	 * @param s player's symbol
	 * @param sc player's  score
	 */
	public  Players(String n,String s,Double sc) {
		nickName = s;
		symbol= n;
		score= sc;
	}
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return score
	 */
	public double getScore() {
		return score;
	}
	//________________________________
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param score: player score
	 */
	public void setScore(Double score) {
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
	 * show player information on screen<br>
	 * <b> pre: we need the player's information </b> 
	 * @return a message showing all the information of the players
	 */
	public String data() {
		String out =	"Nombre: "+this.nickName+" Simbolo: "+symbol+" Puntaje: "+score ;
		return out;
		
	}
	//________________________________

}