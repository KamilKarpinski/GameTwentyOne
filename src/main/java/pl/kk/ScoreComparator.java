package pl.kk;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        if (o1.calculatePoints() == o2.calculatePoints())
            return 0;
        else if (o1.calculatePoints()>21 && o2.calculatePoints() <= 21)
            return -1;
        else if (o1.calculatePoints()<=21 && o2.calculatePoints() > 21)
            return 1;
        else {
            if(o1.calculatePoints()>o2.calculatePoints())
                return 1;
            else
                return -1;
        }
    }
}
