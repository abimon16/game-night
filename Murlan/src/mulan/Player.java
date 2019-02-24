package mulan;

import java.util.ArrayList;

public class Player 
{
	ArrayList<Card> hand;
	
	public Player() {
		hand = new ArrayList<Card>();
	}
	
	public Player(ArrayList<Card> newHand) {
		hand = newHand;
	}

	public void setHand(ArrayList<Card> newHand) {
		hand= newHand;
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
