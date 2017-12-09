import java.util.ArrayList;

/*
 * this checks if you can slap the pile and does everything that the game should be checking
 */
public class Game {
		/*
		 * ------- everything that happens next only happens until one of the player deck has all of the cards----------
We need a variable that keeps track of turns
The computer starts by placing their first card from their pile to the flipped pile (this removes the card from the player’s pile and adds the card to the flipped pile)//since we do this a lot, this should be a method called flip in the game class
Now call the method from the game class that checks if you can slap;
If true, the computer should wait 2 seconds before “slapping” thus adding the flipped pile to the end of its pile and now the flipped pile has no cards
If false but the player presses the space or presses a key within 5 seconds you do the two for stupid
Then you continue
Next player places their card and we call the the method from the game class that checks if you can slap 
Thats all we should be doing in the loop

		 */
		
		private ArrayList<Card> flippedCards;
		
		public Game(ArrayList<Card> pile) {
			flippedCards = pile;
		}
		
		public void addCardToPile(Card newCard) {
			flippedCards.add(newCard);
		}
		
		public boolean slap() {
			if (flippedCards.size() > 1) {
				//doubles
				if (flippedCards.get(flippedCards.size() - 1).getFaceValue() == flippedCards.get(flippedCards.size() - 2).getFaceValue()) {
				return true;
				}
			}
			if (flippedCards.size() > 2) {
			//sandwich
				if(flippedCards.get(flippedCards.size() - 1).getFaceValue() == flippedCards.get(flippedCards.size() - 3).getFaceValue()) {
					return true;
				}
				//increments
				else if (flippedCards.get(flippedCards.size() - 1).getFaceValue() == flippedCards.get(flippedCards.size() - 2).getFaceValue() + 1 
						&& flippedCards.get(flippedCards.size() - 2).getFaceValue() == flippedCards.get(flippedCards.size() - 3).getFaceValue() + 1) {
					return true;
				}
				//decrements
				else if (flippedCards.get(flippedCards.size() - 1).getFaceValue() + 1 == flippedCards.get(flippedCards.size() - 2).getFaceValue() 
						&& flippedCards.get(flippedCards.size() - 2).getFaceValue() + 1 == flippedCards.get(flippedCards.size() - 3).getFaceValue()) {
					return true;
				} 
			}
			return false;
		}
		
		public void hand(ArrayList<Card> playerOne) {
			if (this.slap())  {
				for (int i = 0; i < flippedCards.size(); i++) {
					playerOne.add(flippedCards.get(i));
				}
			} else {
				for (int i = 0; i < 2; i++) {
					flippedCards.add(i,playerOne.get(i));
				}
			}
		}
				
}

