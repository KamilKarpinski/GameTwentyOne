package pl.kk;

import java.util.ArrayList;
import java.util.Collections;

public class GameLogic {
    public static void Playing(Cassino cassino){
        Collections.shuffle(cassino.getDeck());
        ArrayList<Integer> decisionVector = new ArrayList<>();
        cassino.getCroupier().giveCardsToAllPlayers(2, cassino);

        for (Player i : cassino.getPlayers()){decisionVector.add(0);}

        while (decisionVector.stream().reduce(0, Integer::sum) < cassino.getPlayers().size()*2){
            for( int i = 0; i < cassino.getPlayers().size(); i++){
                if(decisionVector.get(i) != 2)
                    decisionVector.set(i,cassino.getPlayers().get(i).Play());
                if(decisionVector.get(i) == 1){
                    cassino.getCroupier().giveCardToPlayer(i, cassino);
                }
            }
        }

    }



}
