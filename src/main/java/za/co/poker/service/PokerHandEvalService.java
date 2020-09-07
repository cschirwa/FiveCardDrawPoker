package za.co.poker.service;

import za.co.poker.utility.Card;
import za.co.poker.utility.Category;

public interface PokerHandEvalService {
	
	public Category evaluateHand(Card[] hand);
	
}
