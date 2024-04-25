import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShopButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract class ShopButton extends Button
{
    
    private int lowLimit;
    private int topLimit;
    
    protected ShopButton(){
        super();
    }
    
    protected ShopButton(String imageButton, String imageSelectButton, String imagePresionedButton,int lowLimit, int topLimit) {
        super(imageButton, imageSelectButton, imagePresionedButton);
        this.lowLimit=lowLimit;
        this.topLimit=topLimit;
    }
    
    public int getTopLimit(){
        return this.topLimit;
    }
    
    public int getLowLimit(){
        return this.lowLimit;
    }
    
}
