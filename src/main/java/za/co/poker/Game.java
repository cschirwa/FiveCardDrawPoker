package za.co.poker;

import za.co.poker.service.Impl.DeckServiceImpl;
import za.co.poker.service.Impl.PokerHandEvalServiceImpl;
import za.co.poker.utility.Card;

public class Game {

	private static PokerHandEvalServiceImpl pokerHandService = new PokerHandEvalServiceImpl();
	
	public static void main(String[] args){
		
		DeckServiceImpl deckService = new DeckServiceImpl();
		System.out.print("Your Hand : ");
		
		Card[] hand = deckService.drawHand();
		System.out.println();
		System.out.println(pokerHandService.evaluateHand(hand).getDescription());
		
	}
}
