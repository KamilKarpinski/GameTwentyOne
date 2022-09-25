package pl.kk;

public class Bot extends Player{
    static int quantity = 0;

    public Bot() {
        super("bot #" +quantity);
        quantity++;
    }
    public Bot(Bot bot){
        super(bot);
    }

    @Override
    public void printClass(){
        System.out.println("bot");
    }


    public int Play(){
        if(this.calculatePoints() < 17)
            return 1;
        else
            return 2;
    }
}
