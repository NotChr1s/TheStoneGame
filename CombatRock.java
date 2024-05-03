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
    
    public CombatRock(int life, String name, GreenfootImage skin, int attack, int defense, int evasion, int speed, ArrayList<Attack> attacks)
    {
        super(life, attack,defense,evasion,speed,attacks);
        this.name=name;
        this.skin=skin;
        this.objects= new ArrayList<GameObject>();
    }
}
