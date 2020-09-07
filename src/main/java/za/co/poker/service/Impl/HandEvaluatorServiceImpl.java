package za.co.poker.service.Impl;

import za.co.poker.utility.Card;
import za.co.poker.utility.Category;

import static za.co.poker.constants.Constants.*;

import za.co.poker.service.HandEvaluatorService;

public class HandEvaluatorServiceImpl implements HandEvaluatorService {

	/***********************************************************
	 * Methods used to determine a certain Poker hand
	 ***********************************************************/
	public Category evaluate(Card[] hand) {
		if (isFlush(hand) && isStraight(hand))
			return Category.STRAIGHT_FLUSH;
		else if (isFourOfAKind(hand))
			return Category.FOUR_OF_A_KIND;
		else if (isFullHouse(hand))
			return Category.FULL_HOUSE;
		else if (isFlush(hand))
			return Category.FLUSH;
		else if (isStraight(hand))
			return Category.STRAIGHT;
		else if (isThreeOfAKind(hand))
			return Category.THREE_OF_A_KIND;
		else if (isTwoPairs(hand))
			return Category.TWO_PAIR;
		else if (isAPair(hand))
			return Category.ONE_PAIR;
		else
			return Category.HIGH_CARD;
	}


	/***********************************************************
	 * Method used to determine if hand has 4 of a kind
	 ***********************************************************/
	private boolean isFourOfAKind(Card[] hand) {
		boolean a1, a2;

		if (hand.length != HAND_SIZE)
			return (false);

		sortByRank(hand);

		a1 = hand[0].getRank().ordinal() == hand[1].getRank().ordinal()
				&& hand[1].getRank().ordinal() == hand[2].getRank().ordinal()
				&& hand[2].getRank().ordinal() == hand[3].getRank().ordinal();

		a2 = hand[1].getRank().ordinal() == hand[2].getRank().ordinal()
				&& hand[2].getRank().ordinal() == hand[3].getRank().ordinal()
				&& hand[3].getRank().ordinal() == hand[4].getRank().ordinal();

		return (a1 || a2);
	}

	/*
	 * ---------------------------------------------------------------- 
	 * isFullHouse(): true if h has Full House false otherwise false
	 * ----------------------------------------------------------------
	 */
	private boolean isFullHouse(Card[] hand) {
		boolean a1, a2;

		if (hand.length != HAND_SIZE)
			return (false);

		sortByRank(hand);

		a1 = hand[0].getRank().ordinal() == hand[1].getRank().ordinal() && // x x x y y
				hand[1].getRank().ordinal() == hand[2].getRank().ordinal()
				&& hand[3].getRank().ordinal() == hand[4].getRank().ordinal();

		a2 = hand[0].getRank().ordinal() == hand[1].getRank().ordinal() && // x x y y y
				hand[2].getRank().ordinal() == hand[3].getRank().ordinal()
				&& hand[3].getRank().ordinal() == hand[4].getRank().ordinal();

		return (a1 || a2);
	}

	/*
	 * ------------------------------------------------------------------------------ 
	 * isThreeOfAKind(): true if hand has 3of a kind false otherwise
	 **** 
	 * Note: use isThreeOfAKind() ONLY if you know the hand does not have 4 of a kind
	 * -----------------------------------------------------------------------------*/
	private boolean isThreeOfAKind(Card[] hand) {
		boolean a1, a2, a3;

		if (hand.length != HAND_SIZE)
			return (false);

		if (isFourOfAKind(hand) || isFullHouse(hand))
			return (false); // The hand is not 3 of a kind (but better)

		/*
		 * ---------------------------------------------------------- 
		 * Now we know the
		 * hand is not 4 of a kind or a full house
		 * ----------------------------------------------------------
		 */
		sortByRank(hand);

		a1 = hand[0].getRank().ordinal() == hand[1].getRank().ordinal()
				&& hand[1].getRank().ordinal() == hand[2].getRank().ordinal();

		a2 = hand[1].getRank().ordinal() == hand[2].getRank().ordinal()
				&& hand[2].getRank().ordinal() == hand[3].getRank().ordinal();

		a3 = hand[2].getRank().ordinal() == hand[3].getRank().ordinal()
				&& hand[3].getRank().ordinal() == hand[4].getRank().ordinal();

		return (a1 || a2 || a3);
	}

	/*
	 * ----------------------------------------------------------------------------- 
	 * isTwoPairs(): true if hand has 2 pairs false otherwise
	 **** 
	 * Note: use isTwoPairs() ONLY if you know the hand does not have 3 of a kind or
	 * better 
	 * -----------------------------------------------------------------------------
	 */
	private boolean isTwoPairs(Card[] hand) {
		boolean a1, a2, a3;

		if (hand.length != HAND_SIZE)
			return (false);

		if (isFourOfAKind(hand) || isFullHouse(hand) || isThreeOfAKind(hand))
			return (false); // The hand is not 2 pairs (but better)

		sortByRank(hand);

		a1 = hand[0].getRank().ordinal() == hand[1].getRank().ordinal()
				&& hand[2].getRank().ordinal() == hand[3].getRank().ordinal();

		a2 = hand[0].getRank().ordinal() == hand[1].getRank().ordinal()
				&& hand[3].getRank().ordinal() == hand[4].getRank().ordinal();

		a3 = hand[1].getRank().ordinal() == hand[2].getRank().ordinal()
				&& hand[3].getRank().ordinal() == hand[4].getRank().ordinal();

		return (a1 || a2 || a3);
	}

	/*
	 * --------------------------------------------------------------------------------- 
	 * isAPair(): true if hand has one pair false otherwise
	 **** 
	 * Note: use isTwoPairs() ONLY if you know the hand does not have 2 pairs or better
	 * ----------------------------------------------------------------------------------
	 */
	private boolean isAPair(Card[] hand) {
		boolean a1, a2, a3, a4;

		if (hand.length != HAND_SIZE)
			return (false);

		if (isFourOfAKind(hand) || isFullHouse(hand) || isThreeOfAKind(hand) || isTwoPairs(hand))
			return (false); // The hand is not one pair (but better)

		sortByRank(hand);

		a1 = hand[0].getRank().ordinal() == hand[1].getRank().ordinal();
		a2 = hand[1].getRank().ordinal() == hand[2].getRank().ordinal();
		a3 = hand[2].getRank().ordinal() == hand[3].getRank().ordinal();
		a4 = hand[3].getRank().ordinal() == hand[4].getRank().ordinal();

		return (a1 || a2 || a3 || a4);
	}

	/*
	 * -------------------------------------------------------------- 
	 * isFlush(): true if h has a flush false otherwise 
	 * --------------------------------------------------------------
	 */
	private boolean isFlush(Card[] hand) {
		if (hand.length != HAND_SIZE)
			return (false);

		sortBySuit(hand);

		return (hand[0].getSuit() == hand[4].getSuit()); // All cards has same suit
	}

	/*
	 * --------------------------------------------------------------- 
	 * isStraight(): true if h is a Straight false otherwise 
	 * ---------------------------------------------------------------
	 */
	private boolean isStraight(Card[] hand) {
		int i, testRank;

		if (hand.length != HAND_SIZE)
			return (false);

		sortByRank(hand);

		/*
		 * =========================== 
		 * Check if hand has an Ace
		 * ===========================
		 */
		if (hand[4].getRank().ordinal() == 12) {
			/*
			 * ================================= 
			 * Check straight using an Ace
			 * =================================
			 */
			boolean a = hand[0].getRank().ordinal() == 0 && hand[1].getRank().ordinal() == 1 && hand[2].getRank().ordinal() == 2
					&& hand[3].getRank().ordinal() == 3;
			boolean b = hand[0].getRank().ordinal() == 8 && hand[1].getRank().ordinal() == 9
					&& hand[2].getRank().ordinal() == 10 && hand[3].getRank().ordinal() == 11;

			return (a || b);
		} else {
			/*=========================================== 
			 * General case: check for increasing values 
			 * ===========================================
			 */
			testRank = hand[0].getRank().ordinal() + 1;

			for (i = 1; i < HAND_SIZE; i++) {
				if (hand[i].getRank().ordinal() != testRank)
					return (false); // Straight failed...

				testRank++;
			}

			return (true); // Straight found !
		}
	}

	/* =========================================================== 
	 * Helper methods
	 * ===========================================================
	 */

	/*
	 * --------------------------------------------- 
	 * Sort hand by rank:
	 * 
	 * smallest ranked card first ....
	 * 
	 * (Finding a straight is easier that way)
	 * ---------------------------------------------
	 */
	private void sortByRank(Card[] hand) {
		int i, j, min_j;

		/*
		 * --------------------------------------------------- 
		 * The selection sort
		 * algorithm 
		 * ---------------------------------------------------
		 */
		for (i = 0; i < hand.length; i++) {
			/*
			 * --------------------------------------------------- 
			 * Find array element with
			 * min. value among hand[i], hand[i+1], ..., hand[n-1]
			 * ---------------------------------------------------
			 */
			min_j = i; // Assume elem i (hand[i]) is the minimum

			for (j = i + 1; j < hand.length; j++) {
				if (hand[j].getRank().ordinal() < hand[min_j].getRank().ordinal()) {
					min_j = j; // We found a smaller minimum, update min_j
				}
			}

			/*
			 * --------------------------------------------------- 
			 * Swap a[i] and a[min_j]
			 * ---------------------------------------------------
			 */
			Card help = hand[i];
			hand[i] = hand[min_j];
			hand[min_j] = help;
		}
	}

	/*
	 * --------------------------------------------- 
	 * Sort hand by suit:
	 * 
	 * smallest suit card first ....
	 * 
	 * (Finding a flush is eaiser that way)
	 * ---------------------------------------------
	 */
	private void sortBySuit(Card[] hand) {
		int i, j, min_j;

		/*
		 * --------------------------------------------------- 
		 * The selection sort
		 * algorithm 
		 * ---------------------------------------------------
		 */
		for (i = 0; i < hand.length; i++) {
			/*
			 * --------------------------------------------------- 
			 * Find array element with
			 * min. value among hand[i], hand[i+1], ..., hand[n-1]
			 * ---------------------------------------------------
			 */
			min_j = i; // Assume elem i (hand[i]) is the minimum

			for (j = i + 1; j < hand.length; j++) {
				if (hand[j].getSuit().ordinal() < hand[min_j].getSuit().ordinal()) {
					min_j = j; // We found a smaller minimum, update min_j
				}
			}
			
			/*
			 * --------------------------------------------------- 
			 * Swap a[i] and a[min_j]
			 * ---------------------------------------------------
			 */
			Card help = hand[i];
			hand[i] = hand[min_j];
			hand[min_j] = help;
		}
	}


}
