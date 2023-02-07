import java.util.*;
import java.util.concurrent.TimeUnit;

public class Match {
    private Team team1;
    private Team team2;
    private String team1Name;
    private String team2Name;
    final private int overs;
    final private int noOfPlayers;
    private Game game;

    Match(String name1,String name2, int overs,int noOfPlayers)
    {
        this.team1Name=name1;
        this.team2Name=name2;
        this.overs=overs;
        this.noOfPlayers=noOfPlayers;

        game=new Game(overs,noOfPlayers);

        team1=new Team(team1Name,noOfPlayers);
        team2=new Team(team2Name,noOfPlayers);
    }

    public void setTeams() {
        team1.setTeam();
        team2.setTeam();
    }

    public void Toss() throws Exception{
        int tossVal=(int)(Math.random()*2);
        tossVal=1;
        if(tossVal==1){
            Team temp=team1;
            team1=team2;
            team2=temp;

            team1Name=team1.getTeamName();
            team2Name=team2.getTeamName();
        }
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("\nThe Match Between : "+team1Name +" and "+ team2Name);
        TimeUnit.MILLISECONDS.sleep(400);

        System.out.println("TOSS: "+team1Name+" won the toss.\n");
        TimeUnit.MILLISECONDS.sleep(400);

    }

    public void play() {

        game.playGame(team1,Integer.MAX_VALUE);
        game.playGame(team2,team1.getScore());


    }

    public void displayResult() throws InterruptedException{
        game.displayScoreCard(team1);
        TimeUnit.MILLISECONDS.sleep(400);
        game.displayScoreCard(team2);
        TimeUnit.MILLISECONDS.sleep(400);

        game.displayScore(team1);
        TimeUnit.MILLISECONDS.sleep(400);
        game.displayScore(team2);
        TimeUnit.MILLISECONDS.sleep(400);

        String winner;
        if(team1.getScore()==team2.getScore())
        {
            System.out.println("Match Tied.");
        }
        else {
                if(team1.getScore()>team2.getScore()){
                    winner=team1Name;
                }else winner=team2Name;
                System.out.println("The Winner is: "+winner);
        }
    }
}
