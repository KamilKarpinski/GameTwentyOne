package pl.kk;

import java.util.Vector;

public class Card {
    private final String symbol;
    private final char unit;
    private final int value;

    public Card(String symbol, char unit){
        this.symbol = symbol;
        this.unit = unit;

        switch(symbol) {
            case "A": this.value = 11; break;
            case "K": this.value = 4; break;
            case "Q": this.value = 3; break;
            case "J": this.value = 2; break;
            default: this.value = Integer.parseInt(symbol);
        }
    }

    public Card(Card old){
        this.symbol = old.getSymbol();
        this.unit = old.getUnit();
        this.value = old.getValue();
    }
    public void printCard(){
        System.out.println(getSymbol() + " "+getUnit());
    }
    public static Vector<Card> InitializeDeck(){
        Vector<Card> newDeck = new Vector<Card>();
        String [] symbols = {"2", "3", "4","5","6","7","8","9","10","J","Q","K","A"};
        char [] units = {'♥', '♦', '♣', '♠'};
        for (String i : symbols){
            for (char j : units){
                newDeck.add(new Card(i, j));
            }
        }
        return newDeck;
    }


    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    public char getUnit() {
        return unit;
    }
}

//  public

