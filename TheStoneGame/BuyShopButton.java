import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuyShopButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuyShopButton extends ShopButton
{
    private long idBuyObject;
    private InventoryWorld currentInventoryWorld;
    
    public BuyShopButton(String imageButton, String imageSelectButton, String imagePresionedButton, int lowLimit, int topLimit,long id, InventoryWorld currentInventoryWorld){
        super(imageButton, imageSelectButton, imagePresionedButton,lowLimit,topLimit);
        this.idBuyObject=id;
        this.currentInventoryWorld = currentInventoryWorld;
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
            BuyWolrd thisItemBuyWorld = new BuyWolrd(this.currentInventoryWorld, this.idBuyObject);
            Greenfoot.setWorld(thisItemBuyWorld);
        }
    }
    
    public void act()
    {
        handleMouseClicks();
    }
}
