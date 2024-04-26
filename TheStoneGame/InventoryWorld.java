import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class InventoryWorld extends ShopWorld
{
    public InventoryWorld()
    {    
        super(); 
        prepare();
    }
    public InventoryWorld(int lowerLimit, int topLimit)
    {    
        super(lowerLimit, topLimit); 
        prepare();
    }
    
    private void prepare()
    {
        displayInventory();        
    }
    
    public void displayInventory(){
        prepareMedia();
        prepareButtons();
        
        GreenfootImage image = new GreenfootImage(200, 50);  
        Font font = new Font("Press Start 2P", 24);  
        image.setFont(font);  
        image.setColor(Color.YELLOW);  
        image.drawString(" " +inventory.getInventoryLowerLimit(), 20, 30);  
        Media lowlimit = new Media(image);
        addObject(lowlimit,570,60);
        
        GreenfootImage image2 = new GreenfootImage(200, 50);  
        Font fon2 = new Font("Press Start 2P", 24);  
        image2.setFont(fon2);  
        image2.setColor(Color.YELLOW);  
        image2.drawString(" " +inventory.getInventoryTopLimit(), 20, 30);  
        Media toplimit = new Media(image2);
        addObject(toplimit,770,60);
        
        GreenfootImage image3 = new GreenfootImage(200, 50);  
        Font fon3 = new Font("Press Start 2P", 24);  
        image3.setFont(fon3);  
        image3.setColor(Color.GREEN);  
        image3.drawString(" " +inventory.getInventorySize(), 20, 30);  
        Media size = new Media(image3);
        addObject(size,670,60);
        
    }
    
    public void prepareMedia(){
        displayPlayerGold();
    }
    
    public void displayPlayerGold(){
        Media playerGoldSprite = new Media("gold.png");
        addObject(playerGoldSprite,1040,50);
        GreenfootImage image = new GreenfootImage(200, 50);  
        Font font = new Font("Press Start 2P", 24);  
        image.setFont(font);  
        image.setColor(Color.YELLOW);  
        image.drawString("x" +player.getGold(), 20, 30);  
        Media playerGold = new Media(image);
        addObject(playerGold,970,60);
    }
    
    public void prepareButtons(){
        prepareInventoryShopButtons();
        prepareBuyShopButtons();
    }
    
    public void prepareInventoryShopButtons(){
       int inventoryLowLimit = inventory.getInventoryLowerLimit();
       int inventoryTopLimit = inventory.getInventoryTopLimit();
       int inventorySize = inventory.getInventorySize();
       if(inventoryLowLimit<=0){
            ShopButton button1= new InventoryShopButton("ButtonArrow.png","ButtonArrowSelected.png","ButtonArrowPresioned.png",true,inventoryLowLimit,inventoryTopLimit);
            addObject(button1,1000,360);
        }else if(inventoryTopLimit<=(inventorySize-1)){
            ShopButton button1= new InventoryShopButton("ButtonArrow.png","ButtonArrowSelected.png","ButtonArrowPresioned.png",true,inventoryLowLimit,inventoryTopLimit);
            ShopButton button2= new InventoryShopButton("LeftArrowButton.png","LeftArrowButtonSelected.png","LeftArrowButtonPresioned.png",false,inventoryLowLimit,inventoryTopLimit);
            addObject(button1,1000,360);
            addObject(button2,30,360);
        }else{
            ShopButton button2= new InventoryShopButton("LeftArrowButton.png","LeftArrowButtonSelected.png","LeftArrowButtonPresioned.png",false,inventoryLowLimit,inventoryTopLimit);
            addObject(button2,30,360);
        } 
    }
    
    public void prepareBuyShopButtons(){
        int inventoryLowLimit = inventory.getInventoryLowerLimit();
        int inventoryTopLimit = inventory.getInventoryTopLimit();
        int inventorySize = inventory.getInventorySize();
        int j=1;
        for(int i=inventoryLowLimit;((i<=(inventorySize-1))&&(i<=inventoryTopLimit));i++){
            Object unit = inventory.getInventory().get(i);
            if(unit instanceof GameObject){
                if(((GameObject)(unit)).getAmount()>0){
                    String spriteFile = ((GameObject)(unit)).getSpriteFile();
                    long objectId = ((GameObject)(unit)).getId();
                    BuyShopButton button = new BuyShopButton(spriteFile,spriteFile,spriteFile,inventoryLowLimit,inventoryTopLimit,objectId,this);
                    if(j<=3){
                        addObject(button,200+(j*200),200);
                    }else{
                        addObject(button,(j*200)-400,400);
                    }
                }else{
                    String silhouetteSpriteFile = ((GameObject)(unit)).getSilhouetteSpriteFile();
                    Media silhouette = new Media(silhouetteSpriteFile);
                    if(j<=3){
                        addObject(silhouette,200+(j*200),200);
                    }else{
                        addObject(silhouette,(j*200)-400,400);
                    }
                }
            }
            j++;
        }
    }   
    
    public ShopInventory getInventory(){
        return inventory;
    }
}
