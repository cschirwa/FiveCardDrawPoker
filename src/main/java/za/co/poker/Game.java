package za.co.poker;

import java.util.List;

import za.co.poker.entity.Card;
import za.co.poker.service.Impl.DeckServiceImpl;
import za.co.poker.service.Impl.HandEvaluatorServiceImpl;

public class Game {

	private static HandEvaluatorServiceImpl handEvaluatorSvc = new HandEvaluatorServiceImpl();
	
	public static void main(String[] args){
		
		DeckServiceImpl deckService = new DeckServiceImpl();
		System.out.print("Your Hand : ");
		
		List<Card> hand = deckService.drawHand();
		System.out.println();
		System.out.println(handEvaluatorSvc.evaluate(hand).getDescription());
		
	}
}
