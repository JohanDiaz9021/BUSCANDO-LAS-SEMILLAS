package model;

public class Board {
	private Node first;
	private int filas;
	private int columnas;

	private int max;
	private int semillas;
	
	/**
	 * constructor method <br>
	 * <b> pre: we need the atributes </b> 
	 * @param n row numbers
	 * @param m column numbers
	 * @param players song artist
	 */
	public Board(int n, int m, String players) {
		filas=n;
		columnas = m;
		semillas =0;
		
		max = n * m;
		createMatrix(players);
	}

	
	/**
	 * depending on the option chosen, the program performs an option <br>
	 * <b> pre: the data that the user enters, columns, rows, players, siblos. </b> 
	 * @param players menu option
	 * 
	 */
	public void createMatrix(String players) {
	
		first = new Node(1);
		first.setPlayers(players);
		
		createdBoard(first, 1);

	}
	/**
	 * print matrices <br>
	 * <b> pre:the number of rows and columns </b>
	 * @return out
	 */
	
	public String prePrint() {
		String out2 = "";
		String out = printBoard(out2, first, 1, 1, 0);
		return out;
	}
	
	/**
	 * print the matrix with all the information <br>
	 * <b> pre: you need all the information of the columns rows and players  </b>
	 * @return out
	 */
	public String prePrint2() {
		String out2 = "";
		String out = printBoard2(out2, first, 1, 1, 0);
		return out;
	}

	/**
	 * create the board <br>
	 * <b> pre: need the number of rows and columns</b>
	 * @param first1
	 * @param i
	 * @return first1
	 */
	private Node createdBoard(Node first1, int i) {
		if (i < max) {
			i++;
			Node current = new Node(i);
			first1.setNext(current);
			current.setPrev(first1);
			createdBoard(current, i);
		}
		return first1;
	}
	/**
	 * print current board <br>
	 * <b> pre: dashboard data </b> 
	 * @param out
	 * @param first2
	 * @param num
	 * @param num2
	 * @param num3
	 * @return out
	 */
	public String printBoard(String out, Node first2, int num, int num2, int num3) {
		if (num3 < max - 2) {
			num3++;
			if (num2 == 1) {
				String out3 = "";
				String out2 = recordNext(first2, num, out3);
				out =   out  + "\n"+ out2;
				num2 = 2;
				first2 = recordNode(first2, 1, out);
				if (first2 != null) {
					out = printBoard(out, first2, num, num2, num3);
				}
			} else {
				String out3 = "";
				String out2 = recordPrev(first2, num, out3);
				out = out  + "\n"+ out2;
				num2 = 1;
				first2 = recordNode(first2, 1, out);
				if (first2 != null) {
					out = printBoard(out, first2, num, num2, num3);
				}
			}
		}
		return out;
	}
	
	
	/**
	 ** record of space next <br>
	 * <b> pre: make use this space </b>
	 * @param first2
	 * @param num2
	 * @param out
	 * @return the route returns to the right
	 */
	public String recordNext(Node first2, int num2, String out) {
		if (num2 <= columnas) {
			out = out + "" + first2.toString();
			first2 = first2.getNext();
			num2++;
			out = recordNext(first2, num2, out);
		}

		return out;
	}

	
	/**
	 * record of space previuos <br>
	 * <b> pre: make use this space </b>
	 * @param first2
	 * @param num2
	 * @param out
	 * @return 
	 */
	public String recordPrev(Node first2, int num2, String out) {
		if (num2 <= columnas) {
			out = first2.toString() + "" + out;
			num2++;
			out = recordPrev(first2.getNext(), num2, out);
		}
		return out;
	}
	
	
	/**
	 * record of nodo <br>
	 * <b> pre: make use of nodo </b>  
	 * @param first2
	 * @param num2
	 * @param out
	 * @return the nodo record
	 */
	public Node recordNode(Node first2, int num2, String out) {
		if (num2 <= columnas) {
			first2 = first2.getNext();
			num2++;
			first2 = recordNode(first2, num2, out);
		}
		return first2;
	}
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return numRows
	 */
	public int getFilas() {
		return filas;
	}
	
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param numRows: position
	 */
	public void setFilas(int numRows) {
		this.filas = numRows;
	}
	
	
	/**
	 * set the position of the snake <br>
	 * <b> pre: constructor method </b> 
	 * @param position  snake position
	 * @param let
	 * @return out 
	 */
	public boolean positionEnlaces(int position, String let) {
		boolean out = positionEnlaces(first.getNext(), position, let);
		return out;
	}

	/**
	 * is the position of a part of the snake end / beginning<br>
	 * <b> pre: the number of snakes to be created, a free space </b>  
	 * @param first2
	 * @param position
	 * @param let
	 * @return
	 */
	private boolean positionEnlaces(Node first2, int position, String let) {

		boolean out = false;
		if (first2.getPos() == position) {

			if (first2.getEnlace().equals(" ")) {
				if (first2.getSemilla().equals(" ")) {
					first2.setEnlace(let);

					out = true;
				}
			}

		} else {

			out = positionEnlaces(first2.getNext(), position, let);
		}

		return out;
	}
	
	
	/**
	 * print the board <br>
	 * <b> pre: the data is needed to create it  </b> 
	 * @param out
	 * @param first2
	 * @param num
	 * @param num2
	 * @param num3
	 * @return out the board
	 */
	public String printBoard2(String out, Node first2, int num, int num2, int num3) {
		if (num3 < max - 2) {
			num3++;
			if (num2 == 1) {
				String out3 = "";
				String out2 = recordNext2(first2, num, out3);
				out =    out +"\n" +out2;
				num2 = 2;
				first2 = recordNode(first2, 1, out);
				if (first2 != null) {
					out = printBoard2(out, first2, num, num2, num3);
				}
			} else {
				String out3 = "";
				String out2 = recordPrev2(first2, num, out3);
				out =  out +"\n" +out2;
				num2 = 1;
				first2 = recordNode(first2, 1, out);
				if (first2 != null) {
					out = printBoard2(out, first2, num, num2, num3);
				}
			}
		}
		return out;
	}
    
	
	
	/**
	 * remember the next move <br>
	 * <b> pre: make the move  </b> 
	 * @param first2
	 * @param num2
	 * @param out
	 * @return out 
	 */
	public String recordNext2(Node first2, int num2, String out) {
		if (num2 <= columnas) {
			out = out + "" + first2.toString2();
			first2 = first2.getNext();
			num2++;
			out = recordNext2(first2, num2, out);
		}

		return out;
	}
	
	
	
	/**
	 * remember previous movements<br>
	 * <b> pre: having previously moved </b>  
	 * @param first2
	 * @param num2
	 * @param out
	 * @return
	 */
	public String recordPrev2(Node first2, int num2, String out) {
		if (num2 <= columnas) {
			out = first2.toString2() + "" + out;
			num2++;
			out = recordPrev2(first2.getNext(), num2, out);
		}
		return out;
	}
	
	
	/**
	 * Find the player on the board<br>
	 * <b> pre: We need the game to have started </b>  
	 * @param symbol
	 * @param position
	 * @return returns, if it finds the desired player
	 */
	public boolean foundPlayer(String symbol, int position) {
		boolean out1 =false;
		boolean out = movePlayer(foundPlayer(first, symbol, position), position, symbol, out1);
		return out;
	}
	/**
	 * Find the player on the board<br>
	 * <b> pre: We need the game to have started </b>  
	 * @param node node where the player is
	 * @param symbol player symbol
	 * @param position postion player
	 * @return returns the node where the player is located
	 */
	private Node foundPlayer(Node node, String symbol, int position) {
		if (node.getPos() + position <= max) {
			if (node.getPlayers().indexOf(symbol) != -1) {
				String player = node.getPlayers();
				player = player.replace(symbol, "");
				node.setPlayers(player);
			} else {
				node = foundPlayer(node.getNext(), symbol, position);
			}
		}
		return node;
	}
	
	
	/**
	 * move the player token<br>
	 * <b> pre:you need to correctly define the board  </b>  
	 * @param node next nodo
	 * @param position postion player
	 * @param symbol player symbol
	 * @param out false/throw
	 * @return out allows the movement of the player's token
	 */
	private boolean movePlayer(Node node, int position, String symbol, boolean out) {

		if (node.getPos() + position <= max) {
			if (position >= 1) {
				if (node.getNext() != null) {
				
					if (node.getNext().getPos() == max) {
						
						
						out= true;
					}
					position--;
					
					out =movePlayer(node.getNext(), position, symbol, out);
					
				}
			} else {
				if (node.getPos() == max) {
					out= true;
				}
				if (node.getEnlace() != " ") {
					
					if(foundEnlace(node.getPrev(), node.getEnlace(),symbol)==false) {
						
						String player = node.getPlayers();
						node.setPlayers(symbol + player);
					}
				} else {
					if (node.getSemilla() != " ") {
						
						if(foundSemilla(node.getNext(), node.getSemilla(),symbol)==false) {
							
							String player = node.getPlayers();
							node.setPlayers(symbol + player);
							
						}
					} else {
						String player = node.getPlayers();
						node.setPlayers(symbol + player);
					}
				}
			}

		}
		return out;
	}
	
	
	
	/**
	 * position of the ladder beginning/end <br>
	 * <b> pre:  need two squares to connect </b>  
	 * @param position
	 * @param let
	 * @return returns if it finds the snake position
	 */
	public boolean positionSemillas(int position, String let) {
		boolean out = positionSemillas(first.getNext(), position, let);
		return out;
	}
	
	
	/**
	 * position of the ladder beginning/end <br>
	 * <b> pre: need two squares to connect </b> 
	 * @param first2
	 * @param position position ladder
	 * @param let
	 * @return returns if it finds the ladder position
	 */
	private boolean positionSemillas(Node first2, int position, String let) {

		boolean out = false;
		if (first2.getPos() == position) {

			if (first2.getSemilla().equals(" ")) {
				if (first2.getEnlace().equals(" ")) {
					first2.setSemilla(let);

					out = true;
				}
			}

		} else {

			out = positionSemillas(first2.getNext(), position, let);
		}

		return out;
	}
	
	
	/**
	 * method of going forward in search of stairs <br>
	 * <b> pre: the location of the ladder </b>  
	 * @param first2
	 * @param let
	 * @param symbol
	 * @return returns if it finds the ladder
	 */
	public boolean foundSemilla(Node first2, String let,String symbol) {
		boolean out = false;
		
		return out;
	}
	
	
	
	/**
	 * method to go back in search of the snake <br>
	 * <b> pre: the location of the snake </b> 
	 * @param first2
	 * @param let
	 * @param symbol
	 * @return returns if it finds the snake
	 */
	public boolean foundEnlace(Node first2, String let,String symbol) {
		boolean out = false;
		if (first2.getEnlace().equals(let)) {
			
			String lader = first2.getPlayers();
			first2.setPlayers(symbol + lader);
			out = true;
		} else {
			if (first2.getPrev() != null) {
				out = foundEnlace(first2.getPrev(), let,symbol);
			}
		}
		return out;
	}
	
	
	
	/**
	 * get method <br>
	 * <b> pre: constructor method </b>  
	 * @return laders
	 */
	public int getSemillas() {
		return semillas;
	}
	
	
	/**
	 * set method <br>
	 * <b> pre: constructor method </b> 
	 * @param laders: ladders
	 */
	public void setSemillas(int semillas) {
		this.semillas = semillas;
	}
}
