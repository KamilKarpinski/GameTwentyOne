package pl.kk;

public class Bot extends Player{
    static int quantity = 0;

    public Bot(String name) {
        super(name);
        quantity++;
        this.rename();
    }
    public Bot(Bot bot){
        super(bot);
    }
    @Override
    public void rename(){
        this.setName("pl.kk.Bot"+(quantity));
    }
    @Override
    public void printClass(){
        System.out.println("bot");
    }
    @Override
    public int Play(){
        if(this.calculatePoints() < 17)
            return 1;
        else
            return 2;
    }
}
