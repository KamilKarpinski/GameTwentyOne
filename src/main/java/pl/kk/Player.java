package pl.kk;

import java.util.ArrayList;

public abstract class Player {
    private ArrayList<Card> playerDeck = new ArrayList<>();
    private String name;


    public  Player(){}
    public Player(String name) {
        this.name = name;
    }
    public Player(Player player) {
        player.getPlayerDeck().stream()
                .forEach( card -> this.playerDeck.add(new Card(card)));
        this.name = player.name;
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
        playerDeck.stream()
                .forEach(System.out::println);
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
    public abstract int Play();

    @Override
    public String toString() {
        String newString =
                "name = " + name +
                        "\nplayerDeck = " + playerDeck.stream().map(i -> i.toString()).toList()
                                +"\npoints = "+this.calculatePoints()+"\n";
        return newString;
    }
}
