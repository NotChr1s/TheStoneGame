import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MySkinsWorld extends BelongingsWorld
{
    public MySkinsWorld()
    {
        super();
        prepare();
    }
    public MySkinsWorld(int lowerLimit, int topLimit)
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
            SelectedSkinButton button = new SelectedSkinButton(spriteFile,spriteFile,spriteFile,skinId,this);
            if(j<=2){
                addObject(button,((j-1)*400)+350,200);
            }else{
                addObject(button,((j-3)*400)+350,500);
            }
            j++;
        }
    }
}
