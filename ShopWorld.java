import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

abstract class ShopWorld extends Game
{
    protected ShopInventory inventory;
    
    protected ShopWorld()
    {    
        super(); 
        this.inventory= new ShopInventory();
    }
    protected ShopWorld(int lowerLimit, int topLimit)
    {    
        super(); 
        this.inventory = new ShopInventory(lowerLimit, topLimit);
    }
}
