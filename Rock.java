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
    private int life;
    private int attack;
    private int defense;
    private int evasion;
    private int speed;
    private ArrayList<Attack> attacks;
    
    public Rock()
    {
        
    }
    
    public Rock(int life, int attack, int defense, int evasion, int speed, ArrayList<Attack> attacks)
    {
        this.life=life;
        this.attack=attack;
        this.defense=defense;
        this.evasion=evasion;
        this.speed=speed;
        this.attacks= attacks;
    }
    
    public  int getLife(){
        return this.life;
    }
    
    public  int getAttack(){
        return this.attack;
    }
    
    public  int getDefense(){
        return this.defense;
    }
    
    public  int getSpeed(){
        return this.speed;
    }
    
    public  int getEvasion(){
        return this.evasion;
    }
    
    public  ArrayList<Attack> getAttacks(){
        return this.attacks;
    }
    
    public void serLife(int life){
        this.life=life;
    }
    
    public void setAttack(int attack){
        this.attack=attack;
    }
    
    public void setDefense(int defense){
        this.defense=defense;
    }
    
    public void setSpeed(int speed){
        this.speed=speed;
    }
    
    public void setEvasion(int evasion){
        this.evasion=evasion;
    }
}    
