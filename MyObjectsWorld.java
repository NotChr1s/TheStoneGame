import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyObjectsWorld extends BelongingsWorld
{
    public MyObjectsWorld()
    {
        super(0,5);
        prepare();
    }
    public MyObjectsWorld(int lowerLimit, int topLimit)
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
        prepareObjects();
        World initialWorld = ClosetWorld.getThisWorld();
        // Crear el botón con la referencia al mundo actual
        ToClosetButton backCloset = new ToClosetButton("UniversalBackButton.png","UniversalBackButton.png","UniversalBackButtonPresioned.png");
        addObject(backCloset,70,50);
    }
    
    public void prepareScrollButtons(){
       if(getInventoryLowerLimit()<=0){
            if((player.getSkins().size() -1)>getInventoryTopLimit()){
                ClosetObjectsScrollButton button1= new ClosetObjectsScrollButton("ButtonArrow.png","ButtonArrowSelected.png","ButtonArrowPresioned.png",true,getInventoryLowerLimit(),getInventoryTopLimit());
                addObject(button1,1000,360);
            }
        }else if(getInventoryTopLimit()<=((player.getSkins().size())-1)){
            ClosetObjectsScrollButton button1= new ClosetObjectsScrollButton("ButtonArrow.png","ButtonArrowSelected.png","ButtonArrowPresioned.png",true,this.getInventoryLowerLimit(),getInventoryTopLimit());
            ClosetObjectsScrollButton button2= new ClosetObjectsScrollButton("LeftArrowButton.png","LeftArrowButtonSelected.png","LeftArrowButtonPresioned.png",false,getInventoryLowerLimit(),getInventoryTopLimit());
            addObject(button1,1000,360);
            addObject(button2,30,360);
        }else{
            ClosetObjectsScrollButton button2= new ClosetObjectsScrollButton("LeftArrowButton.png","LeftArrowButtonSelected.png","LeftArrowButtonPresioned.png",false,getInventoryLowerLimit(),getInventoryTopLimit());
            addObject(button2,30,360);
        } 
    }
    
    public void prepareObjects(){
        int j=1;
        for(int i=getInventoryLowerLimit();((i<=(player.getMyObjects().size() - 1 ))&&(i<=getInventoryTopLimit()));i++){
            GameObject unit = player.getMyObjects().get(i);
            String spriteFile = unit.getSpriteFile();
            int amount = unit.getAmount();
            Media unitMedia = new Media(spriteFile);
            Media amountMedia = generateMyAmountObject(amount);
            if(j<=3){
                addObject(unitMedia,((j-1)*225)+350,250);
                addObject(amountMedia,((j-1)*225)+390,350);
            }else{
                addObject(unitMedia,((j-4)*225)+350,500);
                addObject(amountMedia,((j-4)*225)+390,600);
            }
            j++;
        }
    }
    
    public Media generateMyAmountObject(int amount){
        GreenfootImage image = new GreenfootImage(200, 50);  
        Font font = new Font("Press Start 2P", 12);  
        image.setFont(font);  
        image.setColor(Color.BLACK);  
        image.drawString("You have " +amount, 20, 30);  
        Media buyAmount = new Media(image);
        return buyAmount;
    }
}
