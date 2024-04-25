import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract class Game extends World
{
    protected GreenfootSound music;
    protected Player player;
    /**
     * Constructor for objects of class Game.
     * 
     */
    public Game()
    {    
        super(1080, 720, 1); 
        player = new Player();
    }
    abstract void prepareButtons();
    abstract void prepareMedia();
}
