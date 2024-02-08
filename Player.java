public class Player{

    private final String name;
    private final Hand hand = new Hand();

    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public Hand getHand(){
        return this.hand;
    }

    public void displayHand(){
        System.out.println(this.name + "'s hand: " + this.hand.toString()); 
    }
}
