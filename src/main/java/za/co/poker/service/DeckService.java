package za.co.poker.service;

import za.co.poker.utility.Card;

public interface DeckService {

	void shuffle();
	Card[] drawHand();
	
}
