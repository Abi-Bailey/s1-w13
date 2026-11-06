import java.util.Random;

public class DiceRoll
{
    private int die1;
    private int die2;
    private Random randGen;
    
    public DiceRoll ( ) {
        randGen = new Random ( );
    }
    
    public void roll ( ) {
        die1 = 1 + randGen.nextInt (6);
        die2 = 1 + randGen.nextInt (6);
    }
    
    public int total ( ) {
        return die1 + die2;
    }
}
