package pl.kk;

import java.util.ArrayList;
import java.util.Arrays;

public class Card {
    private final String symbol;
    private final char unit;
    private final int value;

    public Card(String symbol, char unit){
        this.symbol = symbol;
        this.unit = unit;

        switch (symbol) {
            case "A" -> this.value = 11;
            case "K" -> this.value = 4;
            case "Q" -> this.value = 3;
            case "J" -> this.value = 2;
            default -> this.value = Integer.parseInt(symbol);
        }
    }

    public Card(Card old){
        this.symbol = old.getSymbol();
        this.unit = old.getUnit();
        this.value = old.getValue();
    }
    public static ArrayList<Card> InitializeDeck(){
        ArrayList<Card> newDeck = new ArrayList<>();
        ArrayList<String> symbols = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"));
        ArrayList<Character> units = new ArrayList<>(Arrays.asList('♥', '♦', '♣', '♠'));

        symbols.stream()
                .forEach(symbol -> {units.stream()
                        .forEach(unit -> newDeck.add(new Card(symbol, unit)));});

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

    @Override
    public String toString() {
        return   symbol + ' ' +
                unit;
    }
}

//  public

