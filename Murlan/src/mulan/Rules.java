package mulan;

import java.util.ArrayList;

public class Rules 
{
	public boolean isGreater(Card one, Card two) {
		return one.getValue() > two.getValue();
	}
	
	public boolean isSameSize(ArrayList<Card> hand1, ArrayList<Card> hand2) {
		return hand1.size() == hand2.size();
	}
	
	public boolean isValid(ArrayList<Card> currentCards, ArrayList<Card> attemptedPlay) {
		if(!isSameSize(currentCards, attemptedPlay)) {
			return false;
		}//TODO: add case of BOMB and COLOR
	
		if(!areSame(attemptedPlay)) {
			return false;
		}
		
		if(!isGreater(attemptedPlay.get(0), currentCards.get(0))) {
			return false;
		}
		
		return true;
	}
	
	public boolean isBomb(ArrayList<Card> cards) {
		if(cards.size() != 4) {
			return false;
		}
		return areSame(cards);
	}
	
	public boolean areSame(ArrayList<Card> cards) {
		for(int i = 0; i < cards.size()-1;i++) {
			if(cards.get(i).getValue() != cards.get(i+1).getValue()) {
				return false;
			}
		}
		return true;
	}
}
