package mulan;

import java.util.*;

public class Deck {

	private final int NUMBER_PER_SUIT = 13;
	private ArrayList<Card> deck;
	
	public Deck() {
		setDeck(new ArrayList<Card>());
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}
	
	public void generateDeck() {
		for(int i = 3; i < NUMBER_PER_SUIT+3; i++ ) {
			deck.add(new Card(i, "Hearts"));
			deck.add(new Card(i, "Diamonds"));
			deck.add(new Card(i, "Spades"));
			deck.add(new Card(i, "Clubs"));
		}
		deck.add(new Card(17, "Black"));
		deck.add(new Card(18, "Red"));
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public void clearDeck() {
		deck.clear();
	}
	
	public void printDeck() {
		for(int i = 0; i < deck.size(); i++) {
			System.out.println(i + ": " +deck.get(i).toString());
		}
	}
		
}
