package za.co.poker;

import za.co.poker.utility.Card;

public interface IDeck {

	void shuffle();
	Card[] drawHand();
	
}
