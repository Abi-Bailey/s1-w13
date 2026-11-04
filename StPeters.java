import java.util.Random;

public class StPeters
{
    private Random r = new Random();
    private double entryFee;
    private int pot = 1;
   
    public StPeters(double fee){
        this.entryFee = fee;    
    }
    
    public void optimizeEntryFee(){
        for(double x = 1 ; x < 3; x+=0.1){
            this.entryFee = x;
            tester(1000);
        }
    }
    
    public void tester(int howMany){
        int counter = 0;
        int countBreakEvenOrWin=0;
        while(counter < howMany)
        {
           pot = 1;
           if(runGame() <= this.entryFee)
                countBreakEvenOrWin++;
           counter++;
        }
        System.out.println("Entry Fee: " + this.entryFee + " : " + countBreakEvenOrWin + " broke even or won out of " + howMany + " tries. Chance of winning: " + countBreakEvenOrWin * 1.0 / howMany); 
    }
    
    //returns the amount of money you win in the game
    private int runGame(){
        while(flip() == 0)
            pot *= 2;
        return pot;
    }
    
    //code to return a 0 or 1 simulating a flip
    // 0 = heads, 1 = tails
    private int flip(){
        return r.nextInt(2);
    }    

    public static void main(String[] args) {
        StPeters p = new StPeters(1);
        p.optimizeEntryFee();
    }
}
