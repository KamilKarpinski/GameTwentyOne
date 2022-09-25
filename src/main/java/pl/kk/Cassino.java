package pl.kk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cassino {
    private ArrayList<Player> players;

    public ArrayList<Card> getDeck() {
        return deck;
    }

    private ArrayList <Card> deck;

    private Croupier croupier = new Croupier();

    public Cassino(int humans , int bots){
        this.deck = Card.InitializeDeck();
        this.players = createPlayers(humans, bots);
        this.deckShuffle();
    }
    public Cassino(Cassino orginal){
        this.players = new ArrayList<Player>();
        this.deck = new ArrayList<Card>();
        for(Player i : orginal.players)
        {
            if((i) instanceof Human)
                this.players.add(new Human((Human) i));
            else this.players.add(new Bot((Bot) i));
        }
        for(Card i : orginal.deck)
        {this.deck.add(new Card(i));}
    }

    public void Playing(){
        this.deckShuffle();
        ArrayList <Integer> decisionVector = new ArrayList<Integer>();
        croupier.giveCardsToAllPlayers(2, this);
//        this.deckShuffle();
        for (Player i :players){decisionVector.add(0);}
        while (decisionVector.stream().reduce(0, Integer::sum) < players.size()*2){
            for( int i = 0; i < players.size(); i++){
                if(decisionVector.get(i) != 2)
                    decisionVector.set(i,players.get(i).Play());
                if(decisionVector.get(i) == 1){
                    croupier.giveCardToPlayer(i, this);
                }
            }
        }

    }
    public ArrayList<Player> createPlayers(int humans, int bots){
        ArrayList<Player> playerList = new ArrayList<>();
        for( int i=0; i < humans; i++) {
            playerList.add(new Human());
        }
        for (int i = 0; i <bots; i++)
        {
            playerList.add(new Bot());
        }
        return  playerList;
    }
    public void deckShuffle(){
        Collections.shuffle(deck);
    }
    public void printCassinoPlayers(){
        for (Player i : players)
        {i.printPlayer();}
    }

    public List<Player> getPlayers() {
        return players;
    }
}
