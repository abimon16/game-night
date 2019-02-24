package mulan;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	public Game(int numPlayers) {
		deck = new Deck();
		deck.generateDeck();
		deck.shuffleDeck();
		
		players = new ArrayList<Player>();
		for(int i = 0; i < numPlayers; i++) {
			players.add(new Player());
		}
	}
	private Deck deck;
	private ArrayList<Player> players;
	
	public Deck getDeck() {
		return deck;
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
	
	public static void main(String[] args) {
		Game game = new Game(2);
		game.getDeck().printDeck();
		
		game.dealCards();
		
		System.out.println("Player 1");
		System.out.println(game.players.get(0).printHand());
		
		System.out.println("Player 2");
		System.out.println(game.players.get(1).printHand());
		
		Rules rules = new Rules();
		int currentPlayer = 0;
		Scanner input = new Scanner(System.in);
		int choice = 0;
		int choice1 = 0;
		while(true) {
			System.out.println("Player "+(currentPlayer+1) + "Please play a card");
			choice = input.nextInt();
			System.out.println("Player "+(currentPlayer+2) + "Please play a card");
			choice1 = input.nextInt();
			
			if(rules.isGreater(game.players.get(1).getHand().get(choice1), 
					game.players.get(0).getHand().get(choice))){
				System.out.println("Is greater");
			
			}
			else {
				break;
			}
		}
		
		
	}

}
