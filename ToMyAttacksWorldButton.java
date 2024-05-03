import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ToMyAttacksWorldButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToMyAttacksWorldButton extends Button
{
    private long id;
    
    public ToMyAttacksWorldButton(){
        super();
    }
    
    protected ToMyAttacksWorldButton(String imageButton, String imageSelectButton, String imagePresionedButton, long id) {
        super(imageButton, imageSelectButton, imagePresionedButton);
        this.id=id;
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
            MyAttacksWorld w = new MyAttacksWorld(this.id);
            Greenfoot.setWorld(w);
        }
    }
    public void act()
    {
        handleMouseClicks();
    }
}
