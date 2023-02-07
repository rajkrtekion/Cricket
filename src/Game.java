import java.util.concurrent.TimeUnit;

public class Game {
    private Team team;
    private int over = 0;
    private int balls=0;
    private int overs;
    private int score;
    private int wickets;
    int noOfPlayers;

    public Game(int overs,int noOfPlayers) {
        this.overs=overs;
        this.noOfPlayers=noOfPlayers;
    }
    private void setOvers() {
        if(balls==6) {balls=0;}
    }
    private int runGenerator() {
        int run;
        int randomVal=((int)(Math.random()*9));
        if(team.getPlayer(wickets).getPlayerType()==0){ //Bowler{
            if(randomVal<=6) run=randomVal; else run=7;
        }
        else{
            if(randomVal<=4) run=randomVal; else run=7;
        }
        return run;
    }
    private void playOver(int target) throws Exception{

        for(balls=0;balls<6;balls++){

            int run=runGenerator();

            if(run==7)
            {
                System.out.print("W ");
                team.getPlayer(wickets).addBalls();
                wickets++;
                if (wickets == noOfPlayers) {
                    balls++;
                    break;
                }
            }
            else {
                System.out.print(run+" ");
                score+=run;
                team.getPlayer(wickets).addRuns(run);
                team.getPlayer(wickets).addBalls();
                if(score>target) {
                    balls++;
                    break;
                }
            }
            TimeUnit.MILLISECONDS.sleep(200);
        }
        if(balls==6) over++;
        System.out.println();
    }
    public void playGame(Team team,int target){
        score=0;
        wickets=0;
        over=0;
        this.team=team;
        System.out.println("Team "+team.getTeamName()+": Overs going...");
        while(over<overs && score<=target && wickets<noOfPlayers)
        {
            try {
                playOver(target);
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }

        setOvers();

        team.setScore(score);
        team.setOver(over);
        team.setBalls(balls);
        team.setWickets(wickets);

        System.out.println();
    }

    public void displayScoreCard(Team team) throws InterruptedException{
        System.out.println("SCORECARD: "+team.getTeamName());
        System.out.format("%15s %15s %15s\n", "Player", "Score", "Ball");
        TimeUnit.MILLISECONDS.sleep(200);

        for(int i=0;i<noOfPlayers;i++)
        {
            System.out.format("%14s %14s %17s\n", team.getPlayer(i).getName(), team.getPlayer(i).getRuns(), team.getPlayer(i).getBalls());
            TimeUnit.MILLISECONDS.sleep(200);
        }
        System.out.println("----------------------------------------------------------");
        System.out.println();
    }

    public void displayScore(Team team){
        System.out.println(team.getTeamName()+" : "+ team.getScore()+"/"+team.getWickets() +"   Overs : "+team.getOver()+"."+team.getBalls());
    }
}