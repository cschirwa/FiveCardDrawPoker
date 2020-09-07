package za.co.poker;

import static za.co.poker.constants.Constants.*;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import za.co.poker.utility.Card;
import za.co.poker.utility.Rank;
import za.co.poker.utility.Suit;
import za.co.poker.utility.Util;

public class Deck implements IDeck {

	private Random random = ThreadLocalRandom.current();
	
	Card[] hand = new Card[HAND_SIZE];

	/* Shuffle the deck upon construction */
	public Deck() {
		shuffle();
	}
	
	/*=============================================
	 *  Shuffling Algorithm can be defined here
	 *  ===========================================
	 */
	public void shuffle() {
		Util.print("Shuffling.... Shuffling... Shuffling...");
	}


	public Card[] drawHand() {
		for(int i = 0; i<HAND_SIZE; i++) {
			Card card = getRandomCard();
			if(isCardAlreadyInHand(card)) {
				{
					card = getRandomCard();
				} while(isCardAlreadyInHand(card));
			}
			hand[i] = card;
		}
		for (Card card : hand) {
			System.out.print(card + " ");
		}
		return hand;
	}

	private Card getRandomCard() {
		Rank rank = getRandomRank();
		Suit suit = getRandomSuit();
		return Card.valueOf(rank + "_" + suit);
	}

	/*Get random rank using rank ordinal*/
	private Rank getRandomRank() {
		int randomInt = random.nextInt(13);	//Based on 13 available ranks
		return Rank.values()[randomInt];
	}

	/*Get random rank using rank ordinal*/
	private Suit getRandomSuit() {
		int randomInt = random.nextInt(4);	//Based on 4 available suits
		return Suit.values()[randomInt];
	}
	
	/* ================================================
	 * Helper method to check if new card is already in 
	 * the hand. 
	 * ================================================
	 */
	private boolean isCardAlreadyInHand(Card card) {
		boolean isEmpty = true;
		
		for(int i=0;i<hand.length;i++) {
			if(hand[i]!=null) {
				isEmpty = false;
				break;
			}
		}
		if(isEmpty)
			return false;
		
		for(int i=0;i<hand.length;i++) {
			if(hand[i]==card) {
				return true;
			}
		}
		return false;
	}

}
