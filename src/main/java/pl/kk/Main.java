package pl.kk;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int humans, bots;
        System.out.println("Number of human Players: ");
        humans = scanner.nextInt();
        System.out.println("Number of Bots: ");
        bots = scanner.nextInt();

        Cassino orginal = new Cassino(humans,bots);
        orginal.printCassinoPlayers();

        int decision = 0;
        while(true) {
            System.out.println("Start? 1 - YES Other - NO");
            decision = scanner.nextInt();

            if (decision!=1) break;

            Cassino temp = new Cassino(orginal);

            temp.Playing();
            temp.printCassinoPlayers();
        }

//        orginal.printCassinoPlayers();

    }
}

//♥ ♦ ♣ ♠