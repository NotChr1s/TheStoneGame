import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InventoryShopButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InventoryShopButton extends ShopButton
{
    private boolean side;
    public InventoryShopButton(String imageButton, String imageSelectButton, String imagePresionedButton, boolean side, int lowLimit, int topLimit){
        super(imageButton, imageSelectButton, imagePresionedButton,lowLimit,topLimit);
        this.side=side;
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
                ShopWorld shop = new InventoryWorld(getLowLimit() + 6,getTopLimit() +6);
                Greenfoot.setWorld(shop);
            }else{
                ShopWorld shop = new InventoryWorld(getLowLimit() - 6,getTopLimit() - 6);
                Greenfoot.setWorld(shop);
            }
        }
    }
    
    public void act()
    {
        handleMouseClicks();
    }
}
