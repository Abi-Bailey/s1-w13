public class Craps
{
    DiceRoll r;
    
    public Craps()
    {
        r = new DiceRoll ( );
    }

    // Returns 0 if lose, 1 if you win. 
    public int play ( ) {
    r.roll();
    int x = r.total();

    if(x == 7 || x == 11)
        return 1;
    else if(x == 2 || x == 3 || x == 12)
        return 0;
    else{
        int point = x;
        r.roll();
        point = r.total();
        while(point != x){
            r.roll();
            point = r.total();
            if(point == 7)
                return 0;
        }
    }
    return 1;

    }
    
    //simulate play to see your odds of winning
    public void tester(int howMany)
    {
        int k = 0;
        while(k < howMany)
            System.out.println(play());
            k++;
    }

    public static void main(String[] args) {
        Craps k = new Craps();
        System.out.println(k.tester());

    }
}
