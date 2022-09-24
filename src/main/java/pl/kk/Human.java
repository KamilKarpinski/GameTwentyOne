package pl.kk;

import java.util.Scanner;

public class Human extends Player{



    public Human(String name) {
        super(name);
        this.rename();
    }
    public Human(Human human){
        super(human);
    }
    @Override
    public void rename(){
        System.out.print("Set player name: ");
        Scanner scannerName = new Scanner(System.in);
        String new_name = scannerName.next();
        this.setName(new_name);
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
