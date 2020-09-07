package za.co.poker.service;

import za.co.poker.utility.Card;
import za.co.poker.utility.Category;

import static za.co.poker.constants.Constants.*;

public class PokerHandEvalService implements PokerHandEval {

	/***********************************************************
	 * Methods used to determine a certain Poker hand
	 ***********************************************************/
	public Category evaluateHand(Card[] h) {
		if (isFlush(h) && isStraight(h))
			return Category.STRAIGHT_FLUSH;
		else if (isFourOfAKind(h))
			return Category.FOUR_OF_A_KIND;
		else if (isFullHouse(h))
			return Category.FULL_HOUSE;
		else if (isFlush(h))
			return Category.FLUSH;
		else if (isStraight(h))
			return Category.STRAIGHT;
		else if (isThreeOfAKind(h))
			return Category.THREE_OF_A_KIND;
		else if (isTwoPairs(h))
			return Category.TWO_PAIR;
		else if (isAPair(h))
			return Category.ONE_PAIR;
		else
			return Category.HIGH_CARD;
	}


	/***********************************************************
	 * Method used to determine if hand has 4 of a kind
	 ***********************************************************/
	private boolean isFourOfAKind(Card[] h) {
		boolean a1, a2;

		if (h.length != HAND_SIZE)
			return (false);

		sortByRank(h);

		a1 = h[0].getRank().ordinal() == h[1].getRank().ordinal()
				&& h[1].getRank().ordinal() == h[2].getRank().ordinal()
				&& h[2].getRank().ordinal() == h[3].getRank().ordinal();

		a2 = h[1].getRank().ordinal() == h[2].getRank().ordinal()
				&& h[2].getRank().ordinal() == h[3].getRank().ordinal()
				&& h[3].getRank().ordinal() == h[4].getRank().ordinal();

		return (a1 || a2);
	}

	/*
	 * ---------------------------------------------------------------- 
	 * isFullHouse(): true if h has Full House false otherwise false
	 * ----------------------------------------------------------------
	 */
	private boolean isFullHouse(Card[] h) {
		boolean a1, a2;

		if (h.length != HAND_SIZE)
			return (false);

		sortByRank(h);

		a1 = h[0].getRank().ordinal() == h[1].getRank().ordinal() && // x x x y y
				h[1].getRank().ordinal() == h[2].getRank().ordinal()
				&& h[3].getRank().ordinal() == h[4].getRank().ordinal();

		a2 = h[0].getRank().ordinal() == h[1].getRank().ordinal() && // x x y y y
				h[2].getRank().ordinal() == h[3].getRank().ordinal()
				&& h[3].getRank().ordinal() == h[4].getRank().ordinal();

		return (a1 || a2);
	}

	/*
	 * ------------------------------------------------------------------------------ 
	 * isThreeOfAKind(): true if hand has 3of a kind false otherwise
	 **** 
	 * Note: use isThreeOfAKind() ONLY if you know the hand does not have 4 of a kind
	 * -----------------------------------------------------------------------------*/
	private boolean isThreeOfAKind(Card[] h) {
		boolean a1, a2, a3;

		if (h.length != HAND_SIZE)
			return (false);

		if (isFourOfAKind(h) || isFullHouse(h))
			return (false); // The hand is not 3 of a kind (but better)

		/*
		 * ---------------------------------------------------------- 
		 * Now we know the
		 * hand is not 4 of a kind or a full house
		 * ----------------------------------------------------------
		 */
		sortByRank(h);

		a1 = h[0].getRank().ordinal() == h[1].getRank().ordinal()
				&& h[1].getRank().ordinal() == h[2].getRank().ordinal();

		a2 = h[1].getRank().ordinal() == h[2].getRank().ordinal()
				&& h[2].getRank().ordinal() == h[3].getRank().ordinal();

		a3 = h[2].getRank().ordinal() == h[3].getRank().ordinal()
				&& h[3].getRank().ordinal() == h[4].getRank().ordinal();

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
	private boolean isTwoPairs(Card[] h) {
		boolean a1, a2, a3;

		if (h.length != HAND_SIZE)
			return (false);

		if (isFourOfAKind(h) || isFullHouse(h) || isThreeOfAKind(h))
			return (false); // The hand is not 2 pairs (but better)

		sortByRank(h);

		a1 = h[0].getRank().ordinal() == h[1].getRank().ordinal()
				&& h[2].getRank().ordinal() == h[3].getRank().ordinal();

		a2 = h[0].getRank().ordinal() == h[1].getRank().ordinal()
				&& h[3].getRank().ordinal() == h[4].getRank().ordinal();

		a3 = h[1].getRank().ordinal() == h[2].getRank().ordinal()
				&& h[3].getRank().ordinal() == h[4].getRank().ordinal();

		return (a1 || a2 || a3);
	}

	/*
	 * --------------------------------------------------------------------------------- 
	 * isAPair(): true if hand has one pair false otherwise
	 **** 
	 * Note: use isTwoPairs() ONLY if you know the hand does not have 2 pairs or better
	 * ----------------------------------------------------------------------------------
	 */
	private boolean isAPair(Card[] h) {
		boolean a1, a2, a3, a4;

		if (h.length != HAND_SIZE)
			return (false);

		if (isFourOfAKind(h) || isFullHouse(h) || isThreeOfAKind(h) || isTwoPairs(h))
			return (false); // The hand is not one pair (but better)

		sortByRank(h);

		a1 = h[0].getRank().ordinal() == h[1].getRank().ordinal();
		a2 = h[1].getRank().ordinal() == h[2].getRank().ordinal();
		a3 = h[2].getRank().ordinal() == h[3].getRank().ordinal();
		a4 = h[3].getRank().ordinal() == h[4].getRank().ordinal();

		return (a1 || a2 || a3 || a4);
	}

	/*
	 * -------------------------------------------------------------- 
	 * isFlush(): true if h has a flush false otherwise 
	 * --------------------------------------------------------------
	 */
	private boolean isFlush(Card[] h) {
		if (h.length != HAND_SIZE)
			return (false);

		sortBySuit(h);

		return (h[0].getSuit() == h[4].getSuit()); // All cards has same suit
	}

	/*
	 * --------------------------------------------------------------- 
	 * isStraight(): true if h is a Straight false otherwise 
	 * ---------------------------------------------------------------
	 */
	private boolean isStraight(Card[] h) {
		int i, testRank;

		if (h.length != HAND_SIZE)
			return (false);

		sortByRank(h);

		/*
		 * =========================== 
		 * Check if hand has an Ace
		 * ===========================
		 */
		if (h[4].getRank().ordinal() == 12) {
			/*
			 * ================================= 
			 * Check straight using an Ace
			 * =================================
			 */
			boolean a = h[0].getRank().ordinal() == 0 && h[1].getRank().ordinal() == 1 && h[2].getRank().ordinal() == 2
					&& h[3].getRank().ordinal() == 3;
			boolean b = h[0].getRank().ordinal() == 8 && h[1].getRank().ordinal() == 9
					&& h[2].getRank().ordinal() == 10 && h[3].getRank().ordinal() == 11;

			return (a || b);
		} else {
			/*=========================================== 
			 * General case: check for increasing values 
			 * ===========================================
			 */
			testRank = h[0].getRank().ordinal() + 1;

			for (i = 1; i < HAND_SIZE; i++) {
				if (h[i].getRank().ordinal() != testRank)
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
	private void sortByRank(Card[] h) {
		int i, j, min_j;

		/*
		 * --------------------------------------------------- 
		 * The selection sort
		 * algorithm 
		 * ---------------------------------------------------
		 */
		for (i = 0; i < h.length; i++) {
			/*
			 * --------------------------------------------------- 
			 * Find array element with
			 * min. value among h[i], h[i+1], ..., h[n-1]
			 * ---------------------------------------------------
			 */
			min_j = i; // Assume elem i (h[i]) is the minimum

			for (j = i + 1; j < h.length; j++) {
				if (h[j].getRank().ordinal() < h[min_j].getRank().ordinal()) {
					min_j = j; // We found a smaller minimum, update min_j
				}
			}

			/*
			 * --------------------------------------------------- 
			 * Swap a[i] and a[min_j]
			 * ---------------------------------------------------
			 */
			Card help = h[i];
			h[i] = h[min_j];
			h[min_j] = help;
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
	private void sortBySuit(Card[] h) {
		int i, j, min_j;

		/*
		 * --------------------------------------------------- 
		 * The selection sort
		 * algorithm 
		 * ---------------------------------------------------
		 */
		for (i = 0; i < h.length; i++) {
			/*
			 * --------------------------------------------------- 
			 * Find array element with
			 * min. value among h[i], h[i+1], ..., h[n-1]
			 * ---------------------------------------------------
			 */
			min_j = i; // Assume elem i (h[i]) is the minimum

			for (j = i + 1; j < h.length; j++) {
				if (h[j].getSuit().ordinal() < h[min_j].getSuit().ordinal()) {
					min_j = j; // We found a smaller minimum, update min_j
				}
			}
			
			/*
			 * --------------------------------------------------- 
			 * Swap a[i] and a[min_j]
			 * ---------------------------------------------------
			 */
			Card help = h[i];
			h[i] = h[min_j];
			h[min_j] = help;
		}
	}


}
