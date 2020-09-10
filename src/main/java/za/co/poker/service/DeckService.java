package za.co.poker.service;

import java.util.List;

import za.co.poker.entity.Card;

public interface DeckService {

	void shuffle();
	List<Card> drawHand();
	
}
