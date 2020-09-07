package za.co.poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import za.co.poker.service.DeckServiceImpl;
import za.co.poker.utility.Card;

class DeckServiceImplTest {

	@Test
	void testDrawHand() {
		DeckServiceImpl deck = new DeckServiceImpl();
		Card[] hand = deck.drawHand();
		assertEquals(5, hand.length);
	}

}
