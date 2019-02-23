package mulan;

public class Card {

	
	private int value;
	private String suit;
	
	public Card(int val, String newSuit) {
		setValue(val);
		newSuit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public void setSuit(String newSuit) {
		suit = newSuit;
	}
	
}
