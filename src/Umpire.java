import java.security.PrivateKey;

public class Umpire {
    private String umpireName;
    private int age;
    private int experience; //No. of Years;



    public Umpire(String umpireName,int age,int experience)
    {
        this.umpireName=umpireName;
        this.age=age;
        this.experience=experience;
    }

    //Setters
    public void setUmpireName(String umpireName){this.umpireName=umpireName; }
    public void setAge(int age){ this.age=age;}
    public void setExperience(int experience){this.experience=experience;}

    //Getters
    public String getUmpireName(){return umpireName;}
    public int getAge(){return age;}
    public int getExperience(){return experience;}
}
