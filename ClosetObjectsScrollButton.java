import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ClosetObjectsScrollButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClosetObjectsScrollButton extends Button
{
    private int lowLimit;
    private int topLimit;
    private boolean side;
    
    public ClosetObjectsScrollButton(String imageButton, String imageSelectButton, String imagePresionedButton, boolean side, int lowLimit, int topLimit){
        super(imageButton, imageSelectButton, imagePresionedButton);
        this.side=side;
        this.lowLimit=lowLimit;
        this.topLimit=topLimit;
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
            if(this.side){
                MySkinsWorld mySkins = new MySkinsWorld(this.lowLimit + 6,this.topLimit +6);
                Greenfoot.setWorld(mySkins);
            }else{
                MySkinsWorld mySkins = new MySkinsWorld(this.lowLimit - 6,this.topLimit - 6);
                Greenfoot.setWorld(mySkins);
            }
        }
    }
    
    public void act()
    {
        handleMouseClicks();
    }
}
