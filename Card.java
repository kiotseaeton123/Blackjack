public class Card{

    private final String suit; //category heart, diamond, club, spades
    private final String rank; //number

    public Card(String suit, String rank){
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit(){
        return this.suit;
    }
    public String getRank(){
        return this.rank;
    }

    public String toString(){
        return this.rank + " of " + this.suit;
    }
}