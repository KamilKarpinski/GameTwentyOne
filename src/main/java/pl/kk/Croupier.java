package pl.kk;

public class Croupier {

    public void giveCardToPlayer(int index, Cassino cassino){
        cassino.getPlayers().get(index).getPlayerDeck().add(cassino.getDeck().remove(cassino.getDeck().size()-1));
    }

    public void giveCardsToAllPlayers(int quantity, Cassino cassino){
        for (int j =0; j<quantity; j++) {
            for (Player i : cassino.getPlayers()) {
                i.getPlayerDeck().add(cassino.getDeck().remove(cassino.getDeck().size()-1));
            }
        }
    }
}
