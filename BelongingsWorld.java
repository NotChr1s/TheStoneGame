import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

abstract class BelongingsWorld extends Game
{
    private int lowerLimit;
    private int topLimit;
    
    protected BelongingsWorld()
    {
        super();
        this.lowerLimit=0;
        this.topLimit=3;
    }
    
    protected BelongingsWorld(int lowLimit, int topLimit)
    {
        super();
        this.lowerLimit=lowLimit;
        this.topLimit=topLimit;
    }
    
    public int getInventoryLowerLimit(){
        return this.lowerLimit;
    }
    
    public int getInventoryTopLimit(){
        return this.topLimit;
    }
    
    public void setLowerLimit(int l){
        this.lowerLimit=l;
    }
    
    public void setTopLimit(int t){
        this.topLimit=t;
    }
    
    abstract public void prepareScrollButtons();
}
