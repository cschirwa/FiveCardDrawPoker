package za.co.poker.service.Impl;

import za.co.poker.utility.Category;
import static za.co.poker.constants.Constants.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import za.co.poker.entity.Card;
import za.co.poker.service.HandEvaluatorService;

public class HandEvaluatorServiceImpl implements HandEvaluatorService {

	/***********************************************************
	 * Methods used to determine a certain Poker hand
	 ***********************************************************/
	public Category evaluate(List<Card> hand) {

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
	private static boolean isFourOfAKind(List<Card> hand) {
		boolean a1, a2;

		sortByRank(hand);

		a1 = hand.get(0).getRank().ordinal() == hand.get(1).getRank().ordinal()
				&& hand.get(1).getRank().ordinal() == hand.get(2).getRank().ordinal()
				&& hand.get(2).getRank().ordinal() == hand.get(3).getRank().ordinal();

		a2 = hand.get(1).getRank().ordinal() == hand.get(2).getRank().ordinal()
				&& hand.get(2).getRank().ordinal() == hand.get(3).getRank().ordinal()
				&& hand.get(3).getRank().ordinal() == hand.get(4).getRank().ordinal();

		return (a1 || a2);
	}

	/*
	 * ----------------------------------------------------------------
	 * isFullHouse(): true if h has Full House false otherwise false
	 * ----------------------------------------------------------------
	 */
	private static boolean isFullHouse(List<Card> hand) {
		boolean a1, a2;

		sortByRank(hand);

		a1 = hand.get(0).getRank().ordinal() == hand.get(1).getRank().ordinal() && // x x x y y
				hand.get(1).getRank().ordinal() == hand.get(2).getRank().ordinal()
				&& hand.get(3).getRank().ordinal() == hand.get(4).getRank().ordinal();

		a2 = hand.get(0).getRank().ordinal() == hand.get(1).getRank().ordinal() && // x x y y y
				hand.get(2).getRank().ordinal() == hand.get(3).getRank().ordinal()
				&& hand.get(3).getRank().ordinal() == hand.get(4).getRank().ordinal();

		return (a1 || a2);
	}

	/*
	 * -----------------------------------------------------------------------------
	 * - isThreeOfAKind(): true if hand has 3of a kind false otherwise
	 **** 
	 * Note: use isThreeOfAKind() ONLY if you know the hand does not have 4 of a
	 * kind
	 * -----------------------------------------------------------------------------
	 */
	private static boolean isThreeOfAKind(List<Card> hand) {
		boolean a1, a2, a3;

		if (isFourOfAKind(hand) || isFullHouse(hand))
			return (false); // The hand is not 3 of a kind (but better)

		/*
		 * ---------------------------------------------------------- Now we know the
		 * hand is not 4 of a kind or a full house
		 * ----------------------------------------------------------
		 */
		sortByRank(hand);

		a1 = hand.get(0).getRank().ordinal() == hand.get(1).getRank().ordinal()
				&& hand.get(1).getRank().ordinal() == hand.get(2).getRank().ordinal();

		a2 = hand.get(1).getRank().ordinal() == hand.get(2).getRank().ordinal()
				&& hand.get(2).getRank().ordinal() == hand.get(3).getRank().ordinal();

		a3 = hand.get(2).getRank().ordinal() == hand.get(3).getRank().ordinal()
				&& hand.get(3).getRank().ordinal() == hand.get(4).getRank().ordinal();

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
	private static boolean isTwoPairs(List<Card> hand) {
		boolean a1, a2, a3;

		if (isFourOfAKind(hand) || isFullHouse(hand) || isThreeOfAKind(hand))
			return (false); // The hand is not 2 pairs (but better)

		sortByRank(hand);

		a1 = hand.get(0).getRank().ordinal() == hand.get(1).getRank().ordinal()
				&& hand.get(2).getRank().ordinal() == hand.get(3).getRank().ordinal();

		a2 = hand.get(0).getRank().ordinal() == hand.get(1).getRank().ordinal()
				&& hand.get(3).getRank().ordinal() == hand.get(4).getRank().ordinal();

		a3 = hand.get(1).getRank().ordinal() == hand.get(2).getRank().ordinal()
				&& hand.get(3).getRank().ordinal() == hand.get(4).getRank().ordinal();

		return (a1 || a2 || a3);
	}

	/*
	 * -----------------------------------------------------------------------------
	 * ---- isAPair(): true if hand has one pair false otherwise
	 **** 
	 * Note: use isTwoPairs() ONLY if you know the hand does not have 2 pairs or
	 * better
	 * -----------------------------------------------------------------------------
	 * -----
	 */
	private static boolean isAPair(List<Card> hand) {
		boolean a1, a2, a3, a4;

		if (isFourOfAKind(hand) || isFullHouse(hand) || isThreeOfAKind(hand) || isTwoPairs(hand))
			return (false); // The hand is not one pair (but better)

		sortByRank(hand);

		a1 = hand.get(0).getRank().ordinal() == hand.get(1).getRank().ordinal();
		a2 = hand.get(1).getRank().ordinal() == hand.get(2).getRank().ordinal();
		a3 = hand.get(2).getRank().ordinal() == hand.get(3).getRank().ordinal();
		a4 = hand.get(3).getRank().ordinal() == hand.get(4).getRank().ordinal();

		return (a1 || a2 || a3 || a4);
	}

	/*
	 * -------------------------------------------------------------- isFlush():
	 * true if h has a flush false otherwise
	 * --------------------------------------------------------------
	 */
	private static boolean isFlush(List<Card> hand) {

		sortBySuit(hand);

		return (hand.get(0).getSuit() == hand.get(4).getSuit()); // All cards has same suit
	}

	/*
	 * --------------------------------------------------------------- isStraight():
	 * true if h is a Straight false otherwise
	 * ---------------------------------------------------------------
	 */
	private static boolean isStraight(List<Card> hand) {
		int i, testRank;

		sortByRank(hand);

		/*
		 * =========================== Check if hand has an Ace
		 * ===========================
		 */
		if (hand.get(4).getRank().ordinal() == 12) {
			/*
			 * ================================= Check straight using an Ace
			 * =================================
			 */
			boolean a = hand.get(0).getRank().ordinal() == 0 && hand.get(1).getRank().ordinal() == 1
					&& hand.get(2).getRank().ordinal() == 2 && hand.get(3).getRank().ordinal() == 3;
			boolean b = hand.get(0).getRank().ordinal() == 8 && hand.get(1).getRank().ordinal() == 9
					&& hand.get(2).getRank().ordinal() == 10 && hand.get(3).getRank().ordinal() == 11;

			return (a || b);
		} else {
			/*
			 * =========================================== General case: check for
			 * increasing values ===========================================
			 */
			testRank = hand.get(0).getRank().ordinal() + 1;

			for (i = 1; i < HAND_SIZE; i++) {
				if (hand.get(i).getRank().ordinal() != testRank)
					return (false); // Straight failed...

				testRank++;
			}

			return (true); // Straight found !
		}
	}

	/*
	 * =========================================================== Helper methods
	 * ===========================================================
	 */

	/*
	 * --------------------------------------------- Sort hand by rank:
	 * 
	 * smallest ranked card first ....
	 * 
	 * (Finding a straight is easier that way)
	 * ---------------------------------------------
	 */
	private static void sortByRank(List<Card> hand) {
		hand.sort((Card c1, Card c2) -> c1.getRank().ordinal() - c2.getRank().ordinal());
	}

	/*
	 * --------------------------------------------- 
	 * Sort hand by suit:
	 * smallest suit card first ....
	 * (Finding a flush is eaiser that way)
	 * ---------------------------------------------
	 */
	private static void sortBySuit(List<Card> hand) {
		hand.sort((Card c1, Card c2) -> c1.getSuit().ordinal() - c2.getSuit().ordinal());
	}

}
