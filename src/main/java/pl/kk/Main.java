package pl.kk;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScoreComparator scoreComparator = new ScoreComparator();
        Scanner scanner = new Scanner(System.in);
        int humansNum, botsNum;
        System.out.println("Number of human Players: ");
        humansNum = scanner.nextInt();
        System.out.println("Number of Bots: ");
        botsNum = scanner.nextInt();

        Cassino originalCassino = new Cassino(humansNum,botsNum);
        originalCassino.printCassinoPlayers();

        int decision = 0;
        while(true) {
            System.out.println("Start? 1 - YES Other - NO");
            decision = scanner.nextInt();

            if (decision!=1) break;

            Cassino tempCassino = new Cassino(originalCassino);

            GameLogic.Playing(tempCassino);

            List<Player> scoreBoard = tempCassino.getPlayers().stream()
                    .sorted(scoreComparator).toList();

            scoreBoard.stream().forEach(System.out::println);
        }

    }
}