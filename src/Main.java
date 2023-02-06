import java.util.*;

class MatchController{
    private Match match=null;
    private String name1,name2;
    int overs;
    public void matchStart(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Team-1:");
        name1=sc.next();
        System.out.println("Team-2:");
        name2=sc.next();
        System.out.println("Enter Number of Overs:");
        overs=sc.nextInt();

        match=new Match(name1,name2,overs);
        match.setTeams();
        match.Toss();
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
public class Main {
    public static void main(String[] args) {
            MatchController matchController=new MatchController();
            matchController.matchStart();
            matchController.matchPlay();
            matchController.matchResult();
    }
}