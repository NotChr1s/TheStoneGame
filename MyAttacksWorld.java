import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyAttacksWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyAttacksWorld extends BelongingsWorld
{
    private long attackId;
    
    public MyAttacksWorld(long id)
    {
        super();
        this.attackId=id;
        prepare();
    }
    public MyAttacksWorld(int lowerLimit, int topLimit)
    {
        super(lowerLimit,topLimit);
        prepare();
    }
    
    private void prepare(){
        prepareMedia();
        prepareButtons();
    }
    
    public void prepareMedia(){
           
    }
    
    public void prepareButtons(){
        prepareScrollButtons();
        prepareSkins();
        World initialWorld = ClosetWorld.getThisWorld();
        // Crear el botón con la referencia al mundo actual
        ToClosetButton backCloset = new ToClosetButton("UniversalBackButton.png","UniversalBackButton.png","UniversalBackButtonPresioned.png");
        addObject(backCloset,70,50);
    }
    
    public void prepareScrollButtons(){
       if(getInventoryLowerLimit()<=0){
            if((player.getSkins().size() -1)>getInventoryTopLimit()){
                ClosetSkinsScrollButton button1= new ClosetSkinsScrollButton("ButtonArrow.png","ButtonArrowSelected.png","ButtonArrowPresioned.png",true,getInventoryLowerLimit(),getInventoryTopLimit());
                addObject(button1,1000,360);
            }
        }else if(getInventoryTopLimit()<=((player.getSkins().size())-1)){
            ClosetSkinsScrollButton button1= new ClosetSkinsScrollButton("ButtonArrow.png","ButtonArrowSelected.png","ButtonArrowPresioned.png",true,this.getInventoryLowerLimit(),getInventoryTopLimit());
            ClosetSkinsScrollButton button2= new ClosetSkinsScrollButton("LeftArrowButton.png","LeftArrowButtonSelected.png","LeftArrowButtonPresioned.png",false,getInventoryLowerLimit(),getInventoryTopLimit());
            addObject(button1,1000,360);
            addObject(button2,30,360);
        }else{
            ClosetSkinsScrollButton button2= new ClosetSkinsScrollButton("LeftArrowButton.png","LeftArrowButtonSelected.png","LeftArrowButtonPresioned.png",false,getInventoryLowerLimit(),getInventoryTopLimit());
            addObject(button2,30,360);
        } 
    }
    
    public void prepareSkins(){
        int j=1;
        for(int i=getInventoryLowerLimit();((i<=(player.getSkins().size() - 1 ))&&(i<=getInventoryTopLimit()));i++){
            Skin unit = player.getSkins().get(i);
            String spriteFile = unit.getSpriteFile();
            long skinId = unit.getId();
            
            
            j++;
        }
    }
}
