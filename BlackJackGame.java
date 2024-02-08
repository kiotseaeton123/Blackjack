import java.util.Scanner;

public class BlackJackGame{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        Deck deck = new Deck();
        System.out.print("player name: ");
        Player player = new Player(input.nextLine());
        System.out.print("dealer name: ");
        Player dealer = new Player(input.nextLine());
        System.out.println("-------------------------");

        //initial deal
        player.getHand().addCard(deck.drawCard());
        dealer.getHand().addCard(deck.drawCard());
        player.getHand().addCard(deck.drawCard());
        dealer.getHand().addCard(deck.drawCard());

        //player turn
        while(true){
            System.out.println("-------------------------");
            player.displayHand();
            System.out.println("player, hit(h) or stand(s)?");
            String choice = input.nextLine().toLowerCase();

            if(choice.equals("h")){
                player.getHand().addCard(deck.drawCard());

                if(player.getHand().calculateScore() > 21){

                    System.out.println("-------------------------");
                    player.displayHand();
                    System.out.println("player busts, dealer wins!");
                    break;
                }
            }else if (choice.equals("s")){
                break;
            }
        }

        //dealer turn
        while(dealer.getHand().calculateScore() < 17){
            dealer.getHand().addCard(deck.drawCard());
        }

        //display final hands and determine winner
        System.out.println("-------------------------");
        player.displayHand();
        dealer.displayHand();
        int playerScore = player.getHand().calculateScore();
        int dealerScore = dealer.getHand().calculateScore();

        if(playerScore > 21){
            System.out.println("player busts, dealer wins!");
        }else if(dealerScore > 21){
            System.out.println("dealer busts, player wins!");
        }else if(playerScore > dealerScore){
            System.out.println("player wins!");
        }else if (dealerScore > playerScore){
            System.out.println("dealer wins!");
        }else{
            System.out.println("it's a tie!");
        }

    }
}