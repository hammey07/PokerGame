public class Card //Card class represents the cards that will be contained in Deck.
{
    private static String[] suits = {"hearts", "spades", "diamonds", "clubs"}; //suits and ranks are arrays
    private static String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", //that will be placed in cards[]
            "8", "9", "10", "Jack", "Queen", "King"};
    private short rank, suit;

    Card(short suit, short rank) {
        this.rank = rank;
        this.suit = suit;
    }

    static String rankAsString(int __rank) //Convert rank and return
    {
        return ranks[__rank];
    }

    public @Override
    String toString() {
        return ranks[rank] + " of " + suits[suit];
    }

    short getRank() { //Assign rank.
        return rank;
    }

    short getSuit() { //Assign suit.
        return suit;
    }
}

 