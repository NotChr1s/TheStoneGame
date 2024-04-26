import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuyButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuyButton extends Button
{
    private BuyWolrd world;
    
    public BuyButton(){
        super();
    }
    
    protected BuyButton(String imageButton, String imageSelectButton, BuyWolrd newWorld, String imagePresionedButton) {
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
            world.sellTheObject();
            int lowlimit= world.getPreviusInventoryWorld().getInventory().getInventoryLowerLimit();
            int toplimit= world.getPreviusInventoryWorld().getInventory().getInventoryTopLimit();
            InventoryWorld w = new InventoryWorld(lowlimit,toplimit);
            Greenfoot.setWorld(w);
        }
    }
    public void act()
    {
        handleMouseClicks();
    }
}
