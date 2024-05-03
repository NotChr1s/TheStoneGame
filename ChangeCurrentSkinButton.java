import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ChangeCurrentSkinButton extends Button
{
    private SelectSkinWorld world;
    
    protected ChangeCurrentSkinButton(String imageButton, String imageSelectButton, SelectSkinWorld newWorld, String imagePresionedButton) {
        super(imageButton, imageSelectButton, imagePresionedButton);
        this.world=newWorld;
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
            world.changeTheCurrentSkin();
            Greenfoot.setWorld(world.getCurrentMySkinsWorld());
        }
    }
    public void act()
    {
        handleMouseClicks();
    }
}
