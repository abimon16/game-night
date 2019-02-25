package mulan;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	public Game() {
		deck = new Deck();
		deck.generateDeck();
		deck.shuffleDeck();
		
		players = new ArrayList<Player>();
	}

	public Game(int numPlayers) {
		deck = new Deck();
		deck.generateDeck();
		deck.shuffleDeck();
		
		players = new ArrayList<Player>();
		addPlayers(numPlayers);
	}
	private Deck deck;
	private ArrayList<Player> players;
	
	public void addPlayers(int numPlayers) {
		for(int i = 0; i < numPlayers; i++) {
			players.add(new Player());
		}
	}
	
	public Deck getDeck() {
		return deck;
	}
	
	public void printDeck() {
		deck.printDeck();
	}
	
	public void dealCards() {	
		int j = 0;
		for(int i = 0; i < deck.getDeck().size(); i++) {
			if(j >= players.size()) {
				j = 0;
			}
			players.get(j).addCard(deck.getDeck().get(i));
			j++;
		}
	};
	
	public void newGame(int numPlayers) {
		addPlayers(numPlayers);
		dealCards();
		System.out.println(printHands());
	}
	
	
	public void playGame(Scanner scan) {
		Rules rules = new Rules();

		int currentPlayer = 0;
		ArrayList<Card> currentHand = new ArrayList<Card>();
		ArrayList<Card> previousHand = new ArrayList<Card>();
		while(true) {
			System.out.println("Player " + (currentPlayer + 1) + ", please pick one or more cards to play.");
			 while(scan.hasNextInt()){
		         try{
		        	 currentHand.add(players.get(currentPlayer).getHand().get(scan.nextInt()));
		        }
		         catch(ArrayIndexOutOfBoundsException ex) {
		        	 System.out.println("Sorry, you don't seem to have that card.");
		        	 currentHand.clear();
		        	 continue;
		         }
			 }//end get hand while
			 
			 if((previousHand.size() <= 0 && !rules.isPass(currentHand)) || rules.isValid(previousHand, currentHand)){
				System.out.println("Player "+ (currentPlayer + 1) + "played: ");
				for(int i = 0; i < currentHand.size(); i++) {
					System.out.println(currentHand.get(i).toString());
				}
				if(currentPlayer ==players.size()-1) {
					currentPlayer = 0;
				}
				else {
					currentPlayer++;
				}
				previousHand = currentHand;
				currentHand.clear();
			 }
			 else {
				 System.out.println("Sorry, you can't choose those cards.");
				 for(int i = 0; i < currentHand.size(); i++) {
						System.out.println(currentHand.get(i).toString());
				 }
			 }
			 
			 scan.nextLine();
		}
	}
	
	public String printHands() {
		String result = "";
		
		for(int i = 0; i < players.size(); i++) {
			result += "\nPlayer " + (i+1) + ":\n" + players.get(i).printHand();
		}
		
		return result;
	}
	
	public int getNumPlayers(Scanner scan) {
		while(true) {
			System.out.println("How many players do you want?");
			
			int numPlayers = scan.nextInt();
			if(numPlayers <= 1 || numPlayers > 4) {
				System.out.println("Sorry, you need to provide between 2-4 players.");
			}
			else {
				return numPlayers;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int currentChoice = 0;
		Game game = new Game();
		while(true) {
			System.out.println("Welcome to Murlan, please make a selection:");
			System.out.println("1. Read the rules.");
			System.out.println("2. Start a new game.");
			System.out.println("3. Quit.");
			currentChoice = input.nextInt();
			switch(currentChoice) {
			case 1:
				System.out.println("Read rules");
				break;
			case 2:
				int numPlayers = game.getNumPlayers(input);
				game.newGame(numPlayers);
				game.playGame(input);
				break;
			case 3:
				System.out.println("Goodbye!");
				input.close();
				return;
			default:
				System.out.println("Sorry, invalid selection:");
			}
		}
	}

}
