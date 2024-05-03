import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectedSkinButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectedSkinButton extends Button
{
    private long idBuyObject;
    private MySkinsWorld currentMySkinsWorld;
    
    public SelectedSkinButton(String imageButton, String imageSelectButton, String imagePresionedButton, long id, MySkinsWorld currentMySkinsWorld){
        super(imageButton, imageSelectButton, imagePresionedButton);
        this.idBuyObject=id;
        this.currentMySkinsWorld = currentMySkinsWorld;
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
            SelectSkinWorld thisSelectSkinWorld = new SelectSkinWorld(this.currentMySkinsWorld, this.idBuyObject);
            Greenfoot.setWorld(thisSelectSkinWorld);
        }
    }
    
    public void act()
    {
        handleMouseClicks();
    }
}
