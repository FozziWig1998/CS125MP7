
public class Card {
		private int suit; //1 represents diamonds, 2 represents clubs, 3 represents spades and 4 represents hearts
		private int faceValue; // J, Q, K, A will be 11, 12, 13 and 14
		
		public Card(int newSuit, int newFaceValue) {
			this.suit = newSuit;
			this.faceValue = newFaceValue;
			
		}
		public int getSuit() {
			return suit;
		}
		public int getFaceValue() {
			return faceValue;
		}
		
		public String Suit() {
			if (suit == 1) {
				return "diamonds";
			}
			else if (suit == 2) {
				return "clubs";
			}
			else if (suit == 3) {
				return "spades";
			}
			else {
				return "hearts";
			}
		}
		public String FaceValue() {
			if (faceValue < 11) {
				return String.valueOf(faceValue);
			}
			else if (faceValue == 11) {
				return "Jack";
			}
			else if (faceValue == 12) {
				return "Queen";
			}
			else if (faceValue == 13) {
				return "King";
			}
			else {
				return "Ace";
			}
		}
}

