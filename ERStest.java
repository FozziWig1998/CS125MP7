
import java.util.ArrayList;
import java.util.Scanner;

public class ERStest {
	
	
	public static void main(String[] args) {
		
		ArrayList<Card> pile = new ArrayList<Card>(); 
		Game game = new Game(pile);
		
		boolean slappable = false;
		String keyPress = "";
		ArrayList<Card> playerDeck = new ArrayList<Card>();
		ArrayList<Card> computerDeck = new ArrayList<Card>();
		
		Deck deck = new Deck();
		deck.shuffle();
		for (int i = 0; i < 15; i ++) {
			playerDeck.add(deck.getDeck().get(i));
		}
		for (int j = 15; j < 30; j++) {
			computerDeck.add(deck.getDeck().get(j));
		}
		while(playerDeck.size() != 30 || computerDeck.size() != 30) {
			int turn = 0; // variable to see whos playing, computer = 0, player = 1
			if (turn % 2 == 0) {
				game.addCardToPile(computerDeck.remove(computerDeck.size() - 1));
				System.out.println("a " + pile.get(pile.size() - 1).FaceValue() + " of " + pile.get(pile.size() - 1).Suit() + " was placed." );
				slappable = game.slap();
			}
			if (turn % 2 == 1) {
				game.addCardToPile(playerDeck.remove(playerDeck.size() - 1));
				System.out.println("a " + pile.get(pile.size() - 1).FaceValue() + " of " + pile.get(pile.size() - 1).Suit() + " was placed." );
				slappable = game.slap();
			}
			long startTime = System.nanoTime();
			boolean toFinish = false;

			while (!toFinish) 
			{
				Scanner reader = new Scanner(System.in);
			    keyPress = reader.nextLine();
			    toFinish = (System.nanoTime() - startTime >= 3L);
			    reader.close();
			}
			//if player didnt do anything so computer gets hand
			if (keyPress.length() == 0 && slappable) {
				game.hand(computerDeck);
				System.out.println("the Computer gets the pile");
			}
			if (keyPress.length() != 0){
				game.hand(playerDeck);
				if (slappable) {
					System.out.println("the Player gets the pile");
				}
				
			}
			turn++;
			
		}
		if (playerDeck.size() == 30) {
			System.out.println("Player wins!");
		}
		else {
			System.out.println("Computer wins!");
		}
		
	}
	

}
