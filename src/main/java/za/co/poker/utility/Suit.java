package za.co.poker.utility;

public enum Suit {
	DIAMONDS("\u2666"),
	CLUBS("\u2663"),
	HEARTS("\u2764"),
	SPADES("\u2660");
	
	private Suit(String symbol) {
		this.symbol = symbol;
	}
	
	private final String symbol;
	public String getSymbol() {
		return symbol;
	}
}
