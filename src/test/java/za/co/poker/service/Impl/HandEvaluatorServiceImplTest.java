package za.co.poker.service.Impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import za.co.poker.utility.Card;
import za.co.poker.utility.Category;
import za.co.poker.utility.Util;

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
		System.out.print("Test: Straight Flush  ");
		for(Card card: sFlushHand)
			System.out.print(card+" ");
		System.out.println();
		assertEquals(Category.STRAIGHT_FLUSH, pokerService.evaluate(sFlushHand));
	
		//Four Of A Kind - A♣ A♦ A❤ A♠ 8♣
		Card[] fourHand = new Card[5];
		fourHand[0] = Card.ACE_CLUBS;
		fourHand[1] = Card.ACE_DIAMONDS;
		fourHand[2] = Card.ACE_HEARTS;
		fourHand[3] = Card.ACE_SPADES;
		fourHand[4] = Card.EIGHT_CLUBS;
		System.out.print("Test: Four Of A Kind  ");
		for(Card card: fourHand)
			System.out.print(card+" ");
		System.out.println();
		assertEquals(Category.FOUR_OF_A_KIND,pokerService.evaluate(fourHand));
	
		//Full House - A♣ A♦ A❤ 7♠ 7♣
		Card[] fullHand = new Card[5];
		fullHand[0] = Card.ACE_CLUBS;
		fullHand[1] = Card.ACE_DIAMONDS;
		fullHand[2] = Card.ACE_HEARTS;
		fullHand[3] = Card.SEVEN_SPADES;
		fullHand[4] = Card.SEVEN_CLUBS;
		System.out.print("Test: Full House      ");
		for(Card card: fullHand)
			System.out.print(card+" ");
		System.out.println();
		assertEquals(Category.FULL_HOUSE, pokerService.evaluate(fullHand));

		//Three Of A Kind - 2♣ 2♦ 2❤ A♠ 8♣
		Card[] threesHand = {
				Card.TWO_CLUBS, 
				Card.TWO_DIAMONDS, 
				Card.TWO_HEARTS, 
				Card.ACE_SPADES, 
				Card.EIGHT_CLUBS};
		System.out.print("Test: Three Of A Kind ");
		for(Card card: threesHand)
			System.out.print(card+" ");
		System.out.println();
		assertEquals(Category.THREE_OF_A_KIND, pokerService.evaluate(threesHand));

		//5♣ 3♦ 5❤ 3♠ 8❤
		Card[] twoPairHand = {Card.THREE_DIAMONDS, 
				Card.FIVE_CLUBS, 
				Card.FIVE_HEARTS, 
				Card.THREE_SPADES, 
				Card.EIGHT_HEARTS};
		System.out.print("Test: Two Pairs       ");
		for(Card card: twoPairHand)
			System.out.print(card+" ");
		System.out.println();
		assertEquals(Category.TWO_PAIR, pokerService.evaluate(twoPairHand));

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
		System.out.print("Test: Flush           ");
		for(Card card: flushHand)
			System.out.print(card+" ");
		System.out.println();
		assertEquals(Category.FLUSH, pokerService.evaluate(flushHand));

		//Straight Hand - 4♠ 8♣ 5♠ 6♠ 7♠
		Card[] straightHand = {
				Card.FOUR_HEARTS, 
				Card.EIGHT_CLUBS, 
				Card.FIVE_SPADES, 
				Card.SIX_SPADES, 
				Card.SEVEN_SPADES};
		System.out.print("Test: Straight        ");
		for(Card card: straightHand)
			System.out.print(card+" ");
		System.out.println();
		assertEquals(Category.STRAIGHT, pokerService.evaluate(straightHand));
	}
}
