package za.co.poker.service;

import za.co.poker.utility.Card;
import za.co.poker.utility.Category;

public interface HandEvaluatorService {
	
	public Category evaluate(Card[] hand);
	
}
