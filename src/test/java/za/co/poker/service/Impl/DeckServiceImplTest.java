package za.co.poker.service.Impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import za.co.poker.utility.Card;

class DeckServiceImplTest {

	@Test
	void testDrawHand() {
		DeckServiceImpl deckService = new DeckServiceImpl();
		Card[] hand = deckService.drawHand();
		assertEquals(5, hand.length);
	}

}
