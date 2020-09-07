package za.co.poker.service;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import za.co.poker.utility.Card;
import za.co.poker.utility.Category;

class PokerHandEvalServiceTest {

	private final PokerHandEvalService pokerService = new PokerHandEvalService();
	
	@Test
	void testEvaluateHand() {						//A♣ A♦ A❤ A♠ 8♣
		Card[] hand = new Card[5];
		hand[0] = Card.ACE_CLUBS;
		hand[1] = Card.ACE_DIAMONDS;
		hand[2] = Card.ACE_HEARTS;
		hand[3] = Card.ACE_SPADES;
		hand[4] = Card.EIGHT_CLUBS;
		assertEquals(Category.FOUR_OF_A_KIND, pokerService.evaluateHand(hand));
	}

	@Test
	void testIsFourOfAKind() {							//A♣ A♦ A❤ A♠ 8♣
		Card[] hand = new Card[5];
		hand[0] = Card.ACE_CLUBS;
		hand[1] = Card.ACE_DIAMONDS;
		hand[2] = Card.ACE_HEARTS;
		hand[3] = Card.ACE_SPADES;
		hand[4] = Card.EIGHT_CLUBS;
		assertTrue(pokerService.isFourOfAKind(hand));
	}

	@Test
	void testIsFullHouse() {							//A♣ A♦ A❤ 7♠ 7♣
		Card[] hand = new Card[5];
		hand[0] = Card.ACE_CLUBS;
		hand[1] = Card.ACE_DIAMONDS;
		hand[2] = Card.ACE_HEARTS;
		hand[3] = Card.SEVEN_SPADES;
		hand[4] = Card.SEVEN_CLUBS;
		assertTrue(pokerService.isFullHouse(hand));
	}

	@Test
	void testIsThreeOfAKind() {							//2♣ 2♦ 2❤ A♠ 8♣
		Card[] hand = {
				Card.TWO_CLUBS, 
				Card.TWO_DIAMONDS, 
				Card.TWO_HEARTS, 
				Card.ACE_SPADES, 
				Card.EIGHT_CLUBS};
		assertTrue(pokerService.isThreeOfAKind(hand));
	}

	@Test
	void testIsTwoPairs() {								//5♣ 3♦ 5❤ 3♠ 8❤
		Card[] hand = {Card.THREE_DIAMONDS, 
				Card.FIVE_CLUBS, 
				Card.FIVE_HEARTS, 
				Card.THREE_SPADES, 
				Card.EIGHT_HEARTS};
		assertTrue(pokerService.isTwoPairs(hand));
	}

	@Test
	void testIsAPair() {								//A♦ 8♣ 5♣ 3♠ A❤ 
		Card[] hand = {Card.ACE_DIAMONDS, 
				Card.EIGHT_CLUBS, 
				Card.FIVE_CLUBS, 
				Card.THREE_SPADES, 
				Card.EIGHT_HEARTS};
		assertTrue(pokerService.isAPair(hand));
	}

	@Test
	void testIsFlush() {								//A♣ 8♣ 5♣ 3♣ J♣
		Card[] hand = {Card.ACE_CLUBS, 
				Card.EIGHT_CLUBS, 
				Card.FIVE_CLUBS, 
				Card.THREE_CLUBS, 
				Card.JACK_CLUBS};
		assertTrue(pokerService.isFlush(hand));
	}

	@Test
	void testIsStraight() {								//4♠ 8♠ 5♠ 6♠ 7♠
		Card[] hand = {
				Card.FOUR_SPADES, 
				Card.EIGHT_SPADES, 
				Card.FIVE_SPADES, 
				Card.SIX_SPADES, 
				Card.SEVEN_SPADES};
		assertTrue(pokerService.isStraight(hand));
	}

}
