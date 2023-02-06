import java.util.*;
import java.util.concurrent.TimeUnit;

public class Match {
    private Team team1;
    private Team team2;
    private String team1Name;
    private String team2Name;
    private int overs;
    Match(String name1,String name2, int overs)
    {
        this.team1Name=name1;
        this.team2Name=name2;
        this.overs=overs;

        team1=new Team(team1Name,overs);
        team2=new Team(team2Name,overs);
    }

    public void setTeams() {
        team1.setTeam();
        team2.setTeam();
    }

    public void Toss(){
        System.out.print("TOSS: ");
        int tossVal=(int)(Math.random()*2);
        tossVal=1;
        if(tossVal==1){
            Team temp=team1;
            team1=team2;
            team2=temp;

            team1Name=team1.getTeamName();
            team2Name=team2.getTeamName();
        }
        System.out.println(team1Name+" won the toss.");

    }

    public void play() {
        team1.playGame(Integer.MAX_VALUE);

        team2.playGame(team1.getScore());


    }

    public void displayResult() throws InterruptedException{

        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("\nThe Match Between : "+team1Name +" and "+ team2Name+'\n');
        TimeUnit.MILLISECONDS.sleep(400);


        team1.displayScoreCard();
        TimeUnit.MILLISECONDS.sleep(400);
        team2.displayScoreCard();
        TimeUnit.MILLISECONDS.sleep(400);



        System.out.println(team1Name+" : "+ team1.getScore()+"/"+team1.getWickets() +"   Overs : "+team1.getOver()+"."+team1.getBalls());
        TimeUnit.MILLISECONDS.sleep(400);
        System.out.println(team2Name+" : "+ team2.getScore()+"/"+team2.getWickets() +"   Overs : "+team2.getOver()+"."+team2.getBalls());
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
