package mulan;

import java.util.ArrayList;
import java.util.Comparator;

public class Player 
{
	ArrayList<Card> hand;
	
	public Player() {
		hand = new ArrayList<Card>();
		hand.add(new Card(0,"Pass"));
	}
	
	public Player(ArrayList<Card> newHand) {
		hand = newHand;
		hand.add(0, new Card(0, "Pass"));
	}

	public void setHand(ArrayList<Card> newHand) {
		hand= newHand;
		hand.add(0, new Card(0, "Pass"));
	}
	
	public ArrayList<Card> getHand(){
		return hand;
	}
	
	public void addCard(Card newCard) {
		hand.add(newCard);
	}
	
	public String printHand() {
		String result = "";
		for(int i = 0; i < hand.size(); i++) {
			result += "\n"+i+": "+ hand.get(i).toString();
		}
		
		return result;
	}
}
