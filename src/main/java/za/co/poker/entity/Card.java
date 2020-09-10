package za.co.poker.entity;

import za.co.poker.utility.Rank;
import za.co.poker.utility.Suit;

public class Card implements Comparable<Card> {

	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank, Suit suit){
		this.rank = rank;
		this.suit = suit;
	}
	public Rank getRank() {
		return rank;
	}
	public Suit getSuit() {
		return suit;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	@Override
	public String toString() {
		return this.rank.getSymbol()+this.suit.getSymbol();
	}
	@Override
	public int compareTo(Card o) {
		return o.getRank().ordinal() - this.getRank().ordinal();
	}
}
