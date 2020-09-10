package za.co.poker.service.Impl;

import static za.co.poker.constants.Constants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import za.co.poker.entity.Card;
import za.co.poker.service.DeckService;
import za.co.poker.utility.Rank;
import za.co.poker.utility.Suit;
import za.co.poker.utility.Util;

public class DeckServiceImpl implements DeckService {

	private Random random = ThreadLocalRandom.current();
 
	private List<Card> deck;

	/* Generate deck and
	 * Shuffle the deck upon construction 
	 * ==============================================*/
	public DeckServiceImpl() {
		deck = generateDeck();
		shuffle();
	}

	private static List<Card> generateDeck() {
		List<Card> deck = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(rank, suit));
			}
		}
		return deck;
	}

	/*
	 * ============================================= 
	 * Shuffling Algorithm can be
	 * defined here
	 * 
	 * ===========================================
	 */
	public void shuffle() {
		Util.print("Shuffling.... Shuffling... Shuffling...");
		for (int i = 0; i < deck.size(); i++) {
			int index = random.nextInt(deck.size());
			Card tempCard = deck.get(i);
			deck.set(i, deck.get(index));
			deck.set(index, tempCard);
		}

	}

	public List<Card> drawHand() {
		List<Card> hand = new ArrayList<>();
		for (int i = 0; i < HAND_SIZE; i++) {
			hand.add(deck.get(i));
			deck.remove(i);
		}
		for(Card card: hand) {
			System.out.print(card + " ");
		}
		return hand;
	}


}
