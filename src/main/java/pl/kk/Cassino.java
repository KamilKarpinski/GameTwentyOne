package pl.kk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cassino {
    private ArrayList<Player> players;
    private ArrayList <Card> deck;
    private Croupier croupier = new Croupier();


    public Cassino(int humans , int bots){
        this.deck = Card.InitializeDeck();
        this.players = createPlayers(humans, bots);
        Collections.shuffle(this.getDeck());
    }
    public Cassino(Cassino cassino){
        this.players = new ArrayList<Player>();
        this.deck = new ArrayList<Card>();
        for(Player i : cassino.players)
        {
            if((i) instanceof Human)
                this.players.add(new Human((Human) i));
            else this.players.add(new Bot((Bot) i));
        }
        for(Card i : cassino.deck)
        {this.deck.add(new Card(i));}
    }

    public ArrayList<Card> getDeck() {
        return deck;
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
    public void printCassinoPlayers(){
        for (Player i : players)
        {i.printPlayer();}
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Croupier getCroupier() {
        return croupier;
    }
}
