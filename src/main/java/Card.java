public class Card //Card class represents the cards that will be contained in Deck.
{
    private short rank, suit;

    private static String[] suits = { "hearts", "spades", "diamonds", "clubs" }; //suits and ranks are arrays
private static String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", //that will be placed in cards[]
        "8", "9", "10", "Jack", "Queen", "King" };

public static String rankAsString( int __rank ) //Convert rank and return
        {
        return ranks[__rank];
        }

        Card(short suit, short rank)
        {
        this.rank=rank;
        this.suit=suit;
        }

public @Override String toString()
        {
        return ranks[rank] + " of " + suits[suit];
        }

public short getRank() { //Assign rank.
        return rank;
        }

public short getSuit() { //Assign suit.
        return suit;
        }
        }

 