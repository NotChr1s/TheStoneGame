import greenfoot.GreenfootImage;
import java.util.ArrayList;

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock  
{
    // instance variables - replace the example below with your own
    private int attack;
    private int defense;
    private int evasion;
    private int speed;
    private Attack attack1;
    private Attack attack2;
    private Attack attack3;
    private Attack attack4;
    
    public Rock()
    {
    }
    
    public Rock(int attack, int defense, int evasion, int speed, Attack attack1, Attack attack2, Attack attack3, Attack attack4)
    {
        this.attack=attack;
        this.defense=defense;
        this.evasion=evasion;
        this.speed=speed;
        this.attack1=attack1;
        this.attack2=attack2;
        this.attack3=attack3;
        this.attack4=attack4;
    }

}    
