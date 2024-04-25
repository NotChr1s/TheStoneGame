import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuyShopButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuyShopButton extends ShopButton
{
    private boolean buyStatus;
    private long idBuyObject;
    private boolean identity;
    public BuyShopButton(String imageButton, String imageSelectButton, String imagePresionedButton, int lowLimit, int topLimit,boolean status, long id, boolean identity){
        super(imageButton, imageSelectButton, imagePresionedButton,lowLimit,topLimit);
        this.buyStatus=status;
        this.idBuyObject=id;
        this.identity=identity;
    }
    
    public void buyIdentityAct(){
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
            ShopWorld shop = new ShopWorld(getLowLimit(),getTopLimit(),true,false,idBuyObject);
            Greenfoot.setWorld(shop);
        }
    }
    
    public void backIdentityAct(){
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
            ShopWorld shop = new ShopWorld(getLowLimit(),getTopLimit());
            Greenfoot.setWorld(shop);
        }
    }
    
    public void statusTrue(){
        if(identity){
            buyIdentityAct();
        }else{
            backIdentityAct();
        }
    }
    
    public void statusFalse(){
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
            ShopWorld shop = new ShopWorld(getLowLimit(),getTopLimit(),true,idBuyObject);
            Greenfoot.setWorld(shop);
        }
    }
    
    public void handleMouseClicks(){
        if(this.buyStatus){
            statusTrue();
        }else{
            statusFalse();
        }
    }
    
    public void act()
    {
        handleMouseClicks();
    }
}
