package za.co.poker.service;

import za.co.poker.utility.Card;
import za.co.poker.utility.Category;

public interface PokerHandEval {
	
	public Category evaluateHand(Card[] hand);
	
	boolean isFlush(Card[] hand);
	boolean isStraight(Card[] hand);
	boolean isFourOfAKind(Card[] hand);
	boolean isFullHouse(Card[] hand);
	boolean isThreeOfAKind(Card[] hand);
	boolean isTwoPairs(Card[] hand);
	boolean isAPair(Card[] hand);
}
