package pl.kk;

import java.util.Scanner;

public class Human extends Player{



    public Human() {
        super();
        System.out.print("Set player name: ");
        Scanner scannerName = new Scanner(System.in);
        String name = scannerName.next();
        this.setName(name);
    }



    public Human(Human human){
        super(human);
    }


    @Override
    public void printClass(){
        System.out.println("human");
    }
    @Override
    public int Play(){
        Scanner scannerName = new Scanner(System.in);
        this.printPlayer();
        System.out.println("1 - Draw pl.kk.Card \n2 - STOP \n Decision: ");
        int decision = scannerName.nextInt();
        switch(decision) {
            case(1): return 1;
            case(2): return 2;
        }
        return 2;
    }
}
