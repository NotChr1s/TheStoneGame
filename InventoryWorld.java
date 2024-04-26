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
    }
    
    public void prepareMedia(){
        displayPlayerGold();
    }
    
    public void displayPlayerGold(){
        Media playerGoldSprite = new Media("gold.png");
        addObject(playerGoldSprite,40,50);
        GreenfootImage image = new GreenfootImage(200, 50);  
        Font font = new Font("Press Start 2P", 24);  
        image.setFont(font);  
        image.setColor(Color.ORANGE);  
        image.drawString("x" +player.getGold(), 20, 30);  
        Media playerGold = new Media(image);
        addObject(playerGold,150,60);
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
                    int cost = ((GameObject)(unit)).getCost();
                    Media objectCost = generateCost(cost);
                    if(j<=3){
                        addObject(button,((j-1)*300)+250,200);
                        addObject(objectCost,((j-1)*300)+250,320);
                    }else{
                        addObject(button,((j-4)*300)+250,500);
                        addObject(objectCost,((j-4)*300)+250,620);
                    }
                }else{
                    String silhouetteSpriteFile = ((GameObject)(unit)).getSilhouetteSpriteFile();
                    Media silhouette = new Media(silhouetteSpriteFile);
                    if(j<=3){
                        addObject(silhouette,((j-1)*300)+250,200);
                    }else{
                        addObject(silhouette,((j-4)*300)+250,500);
                    }
                }
            }
            j++;
        }
    }   
    
   public Media generateCost(int cost){
        GreenfootImage image = new GreenfootImage(100, 40);  
        Font font = new Font("Press Start 2P", 18);  
        image.setFont(font);  
        image.setColor(Color.WHITE);  
        image.drawString("" +cost, 20, 30);  
        Media costMedia = new Media(image);   
        return costMedia;
   }
    
    public ShopInventory getInventory(){
        return inventory;
    }
}
