public class Hand{

    private final KArrayList<Card> cards;

    public Hand(){
        this.cards = new KArrayList<>();

    }

    public void addCard(Card card){
        cards.add(card);
    }

    public int calculateScore(){
        int score = 0;
        int aceCount = 0;

        for (Card card : this.cards){
            String rank = card.getRank();
            if(rank.equals("Ace")){
                aceCount++;
                score += 11;
            }else if (rank.equals("King") || rank.equals("Queen") || rank.equals("Jack")){
                score += 10;
            }else{
                score += Integer.parseInt(rank);
            }
        }

        //adjust for ace
        while(aceCount > 0 && score > 21){
            score -= 10;
            aceCount--;
        }
        return score;
    }

    @Override
    public String toString(){
        return this.cards.toString();
    }
}