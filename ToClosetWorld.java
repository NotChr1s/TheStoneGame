import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ToClosetWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToClosetWorld extends Button
{
    /**
     * Act - do whatever the ToClosetWorld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        ClosetWorld world = new ClosetWorld();
        Greenfoot.setWorld(world);
    }
}