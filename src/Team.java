import java.util.*;
import java.util.concurrent.TimeUnit;

public class Team {

    private String teamName;
    private Player[] teamPlayer;
    private int over=0;
    private int overs;
    private int balls;
    private int score;
    private int wickets;
    final private int []bastmanRun;
    final private int []allrounderRun;
    private int ballerRun[];

    public Team(String teamName,int overs)
    {
        this.teamName=teamName;
        this.overs=overs;

        bastmanRun=new int[]{0,0,1,1,1,1,1,1,2,2,2,2,3,3,4,4,4,6,6,7};
        allrounderRun=new int[]{0,0,1,1,1,1,1,1,2,2,2,2,2,3,3,4,4,6,7,7};
        ballerRun=new int[]{0,0,0,1,1,1,1,1,1,1,2,2,2,2,3,4,6,7,7,7};

    }

    public String getTeamName(){ return teamName; }
    public int getWickets() { return wickets; }
    public int getScore() { return score; }
    public int getOver() { return over; }
    public int getBalls() { return balls; }


    public void setTeam(){
        teamPlayer=new Player[11];

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the Players for Team: "+ teamName);
        for(int i=0;i<11;i++){

            String name=sc.next();
            teamPlayer[i]=new Player(name);

            if(i<=4) {
                teamPlayer[i].setBatsman(true);
                teamPlayer[i].setBaller(false);
            }
            else if(i>4 && i<=6){
                teamPlayer[i].setBatsman(true);
                teamPlayer[i].setBaller(true);
            }
            else{
                teamPlayer[i].setBatsman(false);
                teamPlayer[i].setBaller(true);
            }
        }

    }

    private void setOvers()
    {
        if(balls==6) {
            overs++; balls=0;
        }
    }
    private int runGenerator() //Pos-> the position of Batsman Playing
    {
        int run;
        int idx=((int)(Math.random()*20));
        if(teamPlayer[wickets].isBatsman()==true && teamPlayer[wickets].isBaller()==true) //All rounder
            run= allrounderRun[idx];
        else if(teamPlayer[wickets].isBatsman()==true)  //Batsman
            run=bastmanRun[idx];
        else run=ballerRun[idx];  //Baller

        return run;
    }
    private void playOver(int target) {

        for(balls=0;balls<6;balls++){

            int run=runGenerator();

            if(run==7)
            {
                teamPlayer[wickets].addBalls();
                wickets++;
                if (wickets == 10) break;
            }
            else {
                score+=run;
                teamPlayer[wickets].addRuns(run);
                teamPlayer[wickets].addBalls();
                if(score>target) break;
            }
        }
    }
    public void playGame(int target){
        score=0;
        wickets=0;

        for(over=0;over<overs;over++){
            playOver(target);

            if(wickets==10) break;
            if(score>target) break;
        }
        setOvers();
    }

    public void displayScoreCard() throws InterruptedException{
        System.out.println("SCORECARD: "+teamName);
        System.out.format("%15s %15s %15s\n", "Player", "Score", "Ball");
        TimeUnit.MILLISECONDS.sleep(200);

        for(int i=0;i<11;i++)
        {
            System.out.format("%14s %14s %17s\n", teamPlayer[i].getName(), teamPlayer[i].getRuns(), teamPlayer[i].getBalls());
            TimeUnit.MILLISECONDS.sleep(200);
        }
        System.out.println("----------------------------------------------------------");
        System.out.println();
    }
}
