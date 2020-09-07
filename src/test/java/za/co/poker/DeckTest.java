package za.co.poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import za.co.poker.utility.Card;

class DeckTest {

	@Test
	void testDrawHand() {
		Deck deck = new Deck();
		Card[] hand = deck.drawHand();
		assertEquals(5, hand.length);
	}

}
