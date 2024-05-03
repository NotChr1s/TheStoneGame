import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Actor;

/**
 * Write a description of class ToWorldButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToWorldButton extends Button
{
    private World newWorld;
    
    public ToWorldButton(){
        super();
        newWorld = new InitialWorld();
    }
    
    protected ToWorldButton(String imageButton, String imageSelectButton, World newWorld, String imagePresionedButton) {
        super(imageButton, imageSelectButton, imagePresionedButton);
        this.newWorld=newWorld;
    }
    
    protected ToWorldButton(String imageButton, String imageSelectButton,String imagePresionedButton) {
        super(imageButton, imageSelectButton, imagePresionedButton);
        newWorld = new InitialWorld();
    }
    
    public void handleMouseClicks(){
        if (Greenfoot.mouseMoved(this)) {  
            setImage(getSelectImage());  
        } 
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {  
            setImage(getNormalImage());  
        }
        if(Greenfoot.mousePressed(this)){
            setImage(getPresionedImage());
        }else if(Greenfoot.mouseClicked(this)){
            setImage(getPresionedImage());
            Greenfoot.delay(7); 
            setImage(getSelectImage());
            getSound().play();
            Greenfoot.setWorld(newWorld);
        }
    }
    public void act()
    {
        handleMouseClicks();
    }
}
