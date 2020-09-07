package za.co.poker.service.Impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import za.co.poker.utility.Card;
import za.co.poker.utility.Category;

class HandEvaluatorServiceImplTest {

	private final HandEvaluatorServiceImpl pokerService = new HandEvaluatorServiceImpl();

	@Test
	void testEvaluateHand() {					
		
		//StraightFlush - A♣ K♦ Q❤ J♠ 10♣
		Card[] sFlushHand = new Card[5];			
		sFlushHand[0] = Card.ACE_CLUBS;
		sFlushHand[1] = Card.KING_CLUBS;
		sFlushHand[2] = Card.QUEEN_CLUBS;
		sFlushHand[3] = Card.JACK_CLUBS;
		sFlushHand[4] = Card.TEN_CLUBS;
		assertEquals(Category.STRAIGHT_FLUSH, pokerService.evaluate(sFlushHand));
	
		//Four Of A Kind - A♣ A♦ A❤ A♠ 8♣
		Card[] fourHand = new Card[5];
		fourHand[0] = Card.ACE_CLUBS;
		fourHand[1] = Card.ACE_DIAMONDS;
		fourHand[2] = Card.ACE_HEARTS;
		fourHand[3] = Card.ACE_SPADES;
		fourHand[4] = Card.EIGHT_CLUBS;
		assertEquals(Category.FOUR_OF_A_KIND,pokerService.evaluate(fourHand));
	
		//Full House - A♣ A♦ A❤ 7♠ 7♣
		Card[] fullHand = new Card[5];
		fullHand[0] = Card.ACE_CLUBS;
		fullHand[1] = Card.ACE_DIAMONDS;
		fullHand[2] = Card.ACE_HEARTS;
		fullHand[3] = Card.SEVEN_SPADES;
		fullHand[4] = Card.SEVEN_CLUBS;
		assertEquals(Category.FULL_HOUSE, pokerService.evaluate(fullHand));

		//Three Of A Kind - 2♣ 2♦ 2❤ A♠ 8♣
		Card[] ThreesHand = {
				Card.TWO_CLUBS, 
				Card.TWO_DIAMONDS, 
				Card.TWO_HEARTS, 
				Card.ACE_SPADES, 
				Card.EIGHT_CLUBS};
		assertEquals(Category.THREE_OF_A_KIND, pokerService.evaluate(ThreesHand));

		//5♣ 3♦ 5❤ 3♠ 8❤
		Card[] TwoPairHand = {Card.THREE_DIAMONDS, 
				Card.FIVE_CLUBS, 
				Card.FIVE_HEARTS, 
				Card.THREE_SPADES, 
				Card.EIGHT_HEARTS};
		assertEquals(Category.TWO_PAIR, pokerService.evaluate(TwoPairHand));

		//One Pair - A♦ 8♣ 5♣ 3♠ A❤ 
		Card[] isPairhand = {Card.ACE_DIAMONDS, 
				Card.EIGHT_CLUBS, 
				Card.FIVE_CLUBS, 
				Card.THREE_SPADES, 
				Card.EIGHT_HEARTS};
		assertEquals(Category.ONE_PAIR ,pokerService.evaluate(isPairhand));

		//Flush Hand - A♣ 8♣ 5♣ 3♣ J♣
		Card[] flushHand = {Card.ACE_CLUBS, 
				Card.EIGHT_CLUBS, 
				Card.FIVE_CLUBS, 
				Card.THREE_CLUBS, 
				Card.JACK_CLUBS};
		assertEquals(Category.FLUSH, pokerService.evaluate(flushHand));

		//Straight Hand - 4♠ 8♣ 5♠ 6♠ 7♠
		Card[] straightHand = {
				Card.FOUR_HEARTS, 
				Card.EIGHT_CLUBS, 
				Card.FIVE_SPADES, 
				Card.SIX_SPADES, 
				Card.SEVEN_SPADES};
		assertEquals(Category.STRAIGHT, pokerService.evaluate(straightHand));
	}
}
