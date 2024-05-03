import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class ToClosetButton extends Button
{
    public ToClosetButton(){
        super();
    }
    
    protected ToClosetButton(String imageButton, String imageSelectButton, String imagePresionedButton) {
        super(imageButton, imageSelectButton, imagePresionedButton);
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
            ClosetWorld w = new ClosetWorld();
            Greenfoot.setWorld(w);
        }
    }
    public void act()
    {
        handleMouseClicks();
    }
}
