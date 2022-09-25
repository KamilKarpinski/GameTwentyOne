package pl.kk;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> playerDeck = new ArrayList<Card>();
    private String name;


    public  Player(){}
    public Player(String name) {
        this.name = name;
    }
    public Player(Player pl) {
        for (Card i : pl.playerDeck){
            this.playerDeck.add(new Card(i));
        }
        this.name = pl.name;
    }
    public ArrayList<Card> getPlayerDeck(){
        return playerDeck;
    }
    public void printPlayer(){
        System.out.println("Name: "+this.name );
        printClass();
        this.printPlayerDeck();
        System.out.println("points: "+this.calculatePoints());
    }
    public void printPlayerDeck(){
        for (Card i : playerDeck)
        {i.printCard();}
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void getCard(Card card){
        this.playerDeck.add(card);
    }


    public void printClass(){
        System.out.println("player");
    }

    public int calculatePoints(){
        int sum = 0;
        for(Card i : playerDeck)
        {
            sum += i.getValue();
        }
        return sum;
    }
    public int Play(){
        return 2;
    }
}
