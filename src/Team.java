import java.util.*;
import java.util.concurrent.TimeUnit;

public class Team {

    private String teamName;
    private Player[] teamPlayer;
    private int over=0;
    private int balls;
    private int score;
    private int noOfPlayers;
    private int wickets;

    public Team(String teamName,int noOfPlayers)
    {
        this.teamName=teamName;
        this.noOfPlayers=noOfPlayers;

    }

    public Player getPlayer(int playerNo){ return teamPlayer[playerNo]; }
    public String getTeamName(){ return teamName; }
    public int getWickets() { return wickets; }
    public int getScore() { return score; }
    public int getOver() { return over; }
    public int getBalls() { return balls; }

    public void setScore(int score){ this.score=score;}
    public void setOver(int over){ this.over=over;}
    public void setBalls(int balls){ this.balls=balls; }
    public void setWickets(int wickets){ this.wickets=wickets; }


    public void setTeam(){
        teamPlayer=new Player[noOfPlayers];

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the Players for Team: "+ teamName+"         Note: PlayerType- 0(BatsMan)  1(Baller)");
        for(int player=0;player<noOfPlayers;player++){
            int playerNo=player+1;
            System.out.print(playerNo+".");
            String name=sc.next();
            teamPlayer[player]=new Player(name);
            System.out.print("PlayerType: ");
            teamPlayer[player].setPlayerType(sc.nextInt());

        }
        System.out.println();

    }
}
