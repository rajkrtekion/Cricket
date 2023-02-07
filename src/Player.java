import java.util.*;
public class Player {
    private String name;
    private int playerType;  // 0-> Batsman, 1->Baller
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
    public void setPlayerType(int playerType){this.playerType=playerType;}
    public void addRuns(int run)
    {
        this.runs+=run;
    }
    public void addBalls()
    {
        balls++;
    }

    public String getName() { return name; }
    public int getRuns() { return runs; };
    public int getBalls() { return balls;};
    public int getPlayerType(){return playerType;}




}
