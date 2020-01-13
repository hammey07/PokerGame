import java.util.ArrayList;
import java.util.Random;

class Deck { //Creating class Deck which will hold cards from Card.
    private ArrayList<Card> cards;

    Deck() {
        cards = new ArrayList<Card>(); //cards represent the cards in the Deck.
        int index_1, index_2; //index_1 & index_2 will be used in
        Random generator = new Random(); //generator is created to generate random numbers.
        Card temp;
        for (short a = 0; a <= 3; a++) //For loop fills deck with cards
        {
            for (short b = 0; b <= 12; b++) {
                cards.add(new Card(a, b)); //New card is added to cards
            }
        }

        int size = cards.size() - 1; //size is created to store total amount of cards in deck.

        for (short i = 0; i < 52; i++) {
            index_1 = generator.nextInt(size); //Random card is generated.
            index_2 = generator.nextInt(size);

            temp = cards.get(index_2);
            cards.set(index_2, cards.get(index_1));
            cards.set(index_1, temp);
        }
    }

    Card drawFromDeck() //This method is used when drawing card from deck to place in hand.
    {
        return cards.remove(cards.size() - 1); //Deck size is adjusted each time.
    }
}