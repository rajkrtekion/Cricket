import java.util.*;
public class Player {
    private String name;
    private boolean batsman;
    private boolean baller;
    int runs=0;
    int balls=0;

    public Player(String name)
    {
        this.name=name;
        runs=0;
        balls=0;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setBatsman(boolean x){
        batsman=x;
    }
    public void setBaller(boolean x){
        baller=x;
    }
    public void addRuns(int run)
    {
        this.runs+=run;
    }
    public void addBalls()
    {
        balls++;
    }

    public String getName() { return name; }
    public boolean isBatsman() { return batsman; }
    public boolean isBaller() { return baller; }
    public int getRuns() { return runs; };
    public int getBalls() { return balls;};




}
