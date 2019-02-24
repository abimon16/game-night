package mulan;

public class Card {

	
	private int value;
	private String suit;
	
	public Card(int val, String newSuit) {
		setValue(val);
		suit = newSuit;
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
	
	@Override
	public String toString() {
		return String.format(value + " of "+ suit);
	}
}
