package za.co.poker.service.Impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import za.co.poker.entity.Card;
import za.co.poker.utility.Category;
import static za.co.poker.utility.Rank.*;
import static za.co.poker.utility.Suit.*;

class HandEvaluatorServiceImplTest {

	private final HandEvaluatorServiceImpl pokerService = new HandEvaluatorServiceImpl();

	@Test
	void testEvaluateStraightFlush() {

		// StraightFlush - A♣ K♦ Q❤ J♠ 10♣
		List<Card> hand = new ArrayList<>();
		hand.add(new Card(ACE, CLUBS));
		hand.add(new Card(KING, CLUBS));
		hand.add(new Card(QUEEN, CLUBS));
		hand.add(new Card(JACK, CLUBS));
		hand.add(new Card(TEN, CLUBS));
		System.out.print("Test: Straight Flush  ");
		for (Card card : hand)
			System.out.print(card + " ");
		System.out.println();
		assertEquals(Category.STRAIGHT_FLUSH, pokerService.evaluate(hand));
	}

	@Test
	void testEvaluateFourOfAKind() {
		// Four Of A Kind - A♣ A♦ A❤ A♠ 8♣
		List<Card> hand = new ArrayList<Card>();
		hand.add(new Card(ACE, CLUBS));
		hand.add(new Card(ACE, DIAMONDS));
		hand.add(new Card(ACE, HEARTS));
		hand.add(new Card(ACE, SPADES));
		hand.add(new Card(EIGHT, CLUBS));
		System.out.print("Test: Four Of A Kind  ");
		for (Card card : hand)
			System.out.print(card + " ");
		System.out.println();
		assertEquals(Category.FOUR_OF_A_KIND, pokerService.evaluate(hand));
	}

	@Test
	void testEvaluateFullHouse() {
		// Full House - A♣ A♦ A❤ 7♠ 7♣
		List<Card> hand = new ArrayList<Card>();
		hand.add(new Card(ACE, CLUBS));
		hand.add(new Card(ACE, DIAMONDS));
		hand.add(new Card(ACE, HEARTS));
		hand.add(new Card(SEVEN, SPADES));
		hand.add(new Card(SEVEN, CLUBS));
		System.out.print("Test: Full House      ");
		for (Card card : hand)
			System.out.print(card + " ");
		System.out.println();
		assertEquals(Category.FULL_HOUSE, pokerService.evaluate(hand));
	}

	@Test
	void testEvaluateThreeOfAKind() {
		// Three Of A Kind - 2♣ 2♦ 2❤ A♠ 8♣
		List<Card> hand = new ArrayList<Card>();
		hand.add(new Card(TWO, CLUBS));
		hand.add(new Card(TWO, DIAMONDS));
		hand.add(new Card(TWO, HEARTS));
		hand.add(new Card(ACE, SPADES));
		hand.add(new Card(EIGHT, CLUBS));
		System.out.print("Test: Three Of A Kind ");
		for (Card card : hand)
			System.out.print(card + " ");
		System.out.println();
		assertEquals(Category.THREE_OF_A_KIND, pokerService.evaluate(hand));
	}

	@Test
	void testEvaluateTwoPairs() {
		// 5♣ 3♦ 5❤ 3♠ 8❤
		List<Card> hand = new ArrayList<Card>();
		hand.add(new Card(FIVE, CLUBS));
		hand.add(new Card(THREE, DIAMONDS));
		hand.add(new Card(FIVE, HEARTS));
		hand.add(new Card(THREE, SPADES));
		hand.add(new Card(EIGHT, HEARTS));
		System.out.print("Test: Two Pairs       ");
		for (Card card : hand)
			System.out.print(card + " ");
		System.out.println();
		assertEquals(Category.TWO_PAIR, pokerService.evaluate(hand));
	}
	
	@Test
	void testEvaluatePair() {
		// One Pair - A♦ 8♣ 5♣ 3♠ A❤
		List<Card> hand = new ArrayList<Card>();
		hand.add(new Card(ACE, DIAMONDS));
		hand.add(new Card(EIGHT, CLUBS));
		hand.add(new Card(FIVE, CLUBS));
		hand.add(new Card(THREE, SPADES));
		hand.add(new Card(ACE, HEARTS));
		assertEquals(Category.ONE_PAIR, pokerService.evaluate(hand));
	}
	
	@Test
	void testEvaluateFlush() {
		// Flush Hand - A♣ 8♣ 5♣ 3♣ J♣
		List<Card> hand = new ArrayList<Card>();
		hand.add(new Card(ACE, CLUBS));
		hand.add(new Card(EIGHT, CLUBS));
		hand.add(new Card(FIVE, CLUBS));
		hand.add(new Card(THREE, CLUBS));
		hand.add(new Card(JACK, CLUBS));		
		System.out.print("Test: Flush           ");
		for (Card card : hand)
			System.out.print(card + " ");
		System.out.println();
		assertEquals(Category.FLUSH, pokerService.evaluate(hand));
	}
	
	@Test
	void testEvaluateStraight() {
		// Straight Hand - 4♠ 8♣ 5♠ 6♠ 7♠
		List<Card> hand = new ArrayList<Card>();
		hand.add(new Card(FOUR, SPADES));
		hand.add(new Card(EIGHT, CLUBS));
		hand.add(new Card(FIVE, SPADES));
		hand.add(new Card(SIX, SPADES));
		hand.add(new Card(SEVEN, SPADES));
		System.out.print("Test: Straight        ");
		for (Card card : hand)
			System.out.print(card + " ");
		System.out.println();
		assertEquals(Category.STRAIGHT, pokerService.evaluate(hand));
	}
}
