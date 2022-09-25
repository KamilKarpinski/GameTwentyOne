package pl.kk;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int humansNum, botsNum;
        System.out.println("Number of human Players: ");
        humansNum = scanner.nextInt();
        System.out.println("Number of Bots: ");
        botsNum = scanner.nextInt();

        Cassino orginal = new Cassino(humansNum,botsNum);
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

    }
}