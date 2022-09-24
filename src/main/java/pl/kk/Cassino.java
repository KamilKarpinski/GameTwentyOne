package pl.kk;

import java.util.Collections;
import java.util.Vector;

public class Cassino {
    private Vector <Player> players = new Vector<Player>();
    private Vector <Card> deck = new Vector <Card>();

    public Cassino(int h , int b){
        this.deck = Card.InitializeDeck();
        this.createPlayers(h,b);
        this.deckShuffle();
    }
    public Cassino(Cassino orginal){
        for(Player i : orginal.players)
        {
            if((i) instanceof Human)
                this.players.add(new Human((Human) i));
            else this.players.add(new Bot((Bot) i));
        }
        for(Card i : orginal.deck)
        {this.deck.add(new Card(i));}
    }

    //    public pl.kk.Player returnPlayer(int x){
//        return players.get(x);
//    }
    public void giveCardToPlayer(int index){
        players.get(index).getCard(this.giveCard());
    }
    public void giveCardsToAllPlayers(int quantity){
        for (int j =0; j<quantity; j++) {
            for (Player i : players) {
                i.getCard(this.giveCard());
            }
        }
    }
    public void deleteTopDeckCard(){
        deck.remove(deck.size()-1);
    }
    public Card giveCard(){
        Card temp = new Card(deck.get(deck.size()-1)); //copying constructor called
        this.deleteTopDeckCard();
        return temp;
    }

    public void Playing(){
        Vector <Integer> decisionVector = new Vector<Integer>();
        this.giveCardsToAllPlayers(2);
        this.deckShuffle();
        for (Player i :players){decisionVector.add(0);}
        while (decisionVector.stream().reduce(0, Integer::sum) < players.size()*2){
            for( int i = 0; i < players.size(); i++){
                if(decisionVector.get(i) != 2)
                    decisionVector.set(i,players.get(i).Play());
                if(decisionVector.get(i) == 1){
                    this.giveCardToPlayer(i);
                }
            }
        }

    }

    public void printCassinoDeck(){
        int j = 1;
        for (Card i : deck){
            System.out.print(j +". ");
            i.printCard();
            j++;
        }
    }
    public void createPlayers(int humans, int bots){
        for( int i=0; i < humans; i++)
        {this.players.add(new Human("human"));}
        for (int i = 0; i <bots; i++)
        {this.players.add(new Bot("bot"));}

    }
    public void deckShuffle(){
        Collections.shuffle(deck);
    }
    public void printCassinoPlayers(){
        for (Player i : players)
        {i.printPlayer();}
    }
}
