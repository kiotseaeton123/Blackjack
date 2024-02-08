
public class Deck{
    private final KArrayList<Card> cards;

    public Deck(){
        this.cards = new KArrayList<>();
        initializeDeck();
        shuffleDeck();
        
    }

    private void initializeDeck(){
        
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "Jack", "Queen", "King", "Ace"};

        for(String suit : suits){
            for(String rank : ranks){
                this.cards.add(new Card(suit, rank));
            }
        }
    }

    private void shuffleDeck(){
        cards.shuffle();
    }

    public Card drawCard(){
        if(cards.getSize() == 0){
            System.out.println("no cards left in deck...");
            return null;
        }
        return cards.remove(0);
    }


}