package za.co.poker.service;

import java.util.List;

import za.co.poker.entity.Card;
import za.co.poker.utility.Category;

public interface HandEvaluatorService {
	
	public Category evaluate(List<Card> hand);
	
}
