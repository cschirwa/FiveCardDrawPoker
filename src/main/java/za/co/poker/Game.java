package za.co.poker;

import java.util.concurrent.TimeUnit;

import za.co.poker.utility.Card;
import za.co.poker.service.DeckServiceImpl;
import za.co.poker.service.PokerHandEvalService;

public class Game {

	private static PokerHandEvalService pokerHandService = new PokerHandEvalService();
	
	public static void main(String[] args) throws InterruptedException {
		
		DeckServiceImpl deckService = new DeckServiceImpl();
//		TimeUnit.MILLISECONDS.sleep(1500);
		System.out.print("Your Hand : ");
		
		Card[] hand = deckService.drawHand();
		System.out.println();
		System.out.println(pokerHandService.evaluateHand(hand).getDescription());
		
	}
}
