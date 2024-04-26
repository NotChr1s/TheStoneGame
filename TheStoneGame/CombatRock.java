import greenfoot.GreenfootImage;
import java.util.ArrayList;

/**
 * Write a description of class CombatRock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CombatRock extends Rock 
{
    // instance variables - replace the example below with your own
    private String name;
    private GreenfootImage skin;
    private ArrayList<GameObject> objects;
    
    public CombatRock()
    {
    }
    
    public CombatRock(String name, GreenfootImage skin, int attack, int defense, int evasion, int speed, Attack attack1, Attack attack2, Attack attack3, Attack attack4)
    {
        super(attack,defense,evasion,speed,attack1,attack2,attack3,attack4);
        this.name=name;
        this.skin=skin;
        this.objects= new ArrayList<GameObject>();
    }
}
