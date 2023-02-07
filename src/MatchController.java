import java.util.Scanner;

public class MatchController{
    private Match match=null;
    private String name1,name2;
    private int overs;
    private int noOfPlayers; //count of players;
    public void matchStart(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number of Players in Each Team: ");
        noOfPlayers=sc.nextInt();
        System.out.print("Enter Number of Overs: ");
        overs=sc.nextInt();
        System.out.print("Team-1: ");
        name1=sc.next();
        System.out.print("Team-2: ");
        name2=sc.next();


        match=new Match(name1,name2,overs,noOfPlayers);
        match.setTeams();
        try {
            match.Toss();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void matchPlay(){
        match.play();
    }
    public void matchResult()
    {
        try {
            match.displayResult();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

}