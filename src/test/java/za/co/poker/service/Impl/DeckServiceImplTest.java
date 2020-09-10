package za.co.poker.service.Impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import za.co.poker.entity.Card;

class DeckServiceImplTest {

	@Test
	void testDrawHand() {
		DeckServiceImpl deckService = new DeckServiceImpl();
		List<Card> hand = deckService.drawHand();
		assertEquals(5, hand.size());
	}

}
