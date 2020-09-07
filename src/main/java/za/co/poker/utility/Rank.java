package za.co.poker.utility;

public enum Rank implements Rankable {
	
	TWO("2"),
	THREE("3"),
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	SEVEN("7"),
	EIGHT("8"),
	NINE("9"),
	TEN("10"),
	JACK("J"),
	QUEEN("Q"),
	KING("K"),
	ACE("A");
	
	private Rank(String symbol) {
		this.symbol = symbol;
	}
	
	private String symbol;
	public String getSymbol() {
		return symbol;
	}
}
