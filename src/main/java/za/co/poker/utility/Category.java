package za.co.poker.utility;

public enum Category {
	
	HIGH_CARD("High Card"),
	ONE_PAIR("Is A Pair"),
	TWO_PAIR("Two Pairs"),
	THREE_OF_A_KIND("Three Of A Kind"),
	STRAIGHT("Straight"),
	FLUSH("Flush"),
	FULL_HOUSE("Full House"),
	FOUR_OF_A_KIND("Four Of A Kind"),
	STRAIGHT_FLUSH("Straight Flush");

	Category(String desc) {
		this.description = desc;
	}
	
	private String description;
	
	public String getDescription() {
		return description;
	}
}
