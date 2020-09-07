package za.co.poker;

import za.co.poker.service.Impl.DeckServiceImpl;
import za.co.poker.service.Impl.HandEvaluatorServiceImpl;
import za.co.poker.utility.Card;

public class Game {

	private static HandEvaluatorServiceImpl handEvaluatorSvc = new HandEvaluatorServiceImpl();
	
	public static void main(String[] args){
		
		DeckServiceImpl deckService = new DeckServiceImpl();
		System.out.print("Your Hand : ");
		
		Card[] hand = deckService.drawHand();
		System.out.println();
		System.out.println(handEvaluatorSvc.evaluate(hand).getDescription());
		
	}
}
