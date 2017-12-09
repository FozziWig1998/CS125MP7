import java.util.ArrayList;

public class Deck {

	private ArrayList<Card> myDeck = new ArrayList<Card>(30);
	
	public Deck() {
		myDeck.add(new Card(1, 7));
		myDeck.add(new Card(2, 7));
		for (int i = 0; i < 4; i++) {
			for (int j = 8; j < 15; j++) {
				myDeck.add(new Card(i, j));
			}
		}
	}
	
	
	
	public void shuffle() {
		int numOfSwaps = 15 + (int) (Math.random() * 50);
		for(int i = 0; i < numOfSwaps; i++) {
		int cardOne = (int) ( Math.random() *  30);
		int cardTwo = (int) ( Math.random() *  30);//its fine if cardOne and Two are the same
		Card temp = myDeck.get(cardTwo);
		myDeck.set(cardTwo, myDeck.get(cardOne));
		myDeck.set(cardOne, temp);
		}
	}



	public ArrayList<Card> getDeck() {
		// TODO Auto-generated method stub
		return myDeck;
	}

}
