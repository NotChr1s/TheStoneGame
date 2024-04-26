import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuyWolrd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuyWolrd extends ShopWorld
{
    private InventoryWorld previusInventoryWolrd;
    private long currentSelledObject;
    
    public BuyWolrd(InventoryWorld previusInventoryWolrd, long currentSelledObject)
    {
        super();
        this.previusInventoryWolrd = previusInventoryWolrd;
        this.currentSelledObject=currentSelledObject;
        prepare();
    }
        
    public void prepare(){
        prepareMedia();
        prepareButtons();
    }
    
    public void sellTheObject(){
        Object selledObject = inventory.getOneElemenOfInventary(this.currentSelledObject);
        if(selledObject instanceof GameObject){
            ((GameObject)(selledObject)).decreasesAmount();
            long id=((GameObject)(selledObject)).getId();
            String name = ((GameObject)(selledObject)).getName();
            String description = ((GameObject)(selledObject)).getDescription();
            int amount=1;
            String sprite= ((GameObject)(selledObject)).getSpriteFile();
            int cost = ((GameObject)(selledObject)).getCost();
            String silhouetteSprite = ((GameObject)(selledObject)).getSilhouetteSpriteFile();
            GameObject object = new GameObject(id,name,description,amount,sprite,cost,silhouetteSprite);
            player.addObjectToMyObjects(object);
            int newGold = player.getGold() - ((GameObject)(selledObject)).getCost();
            player.setGold(newGold);
            player.saveMyObjectsArrayList();
            player.saveMyData();
            inventory.saveMyShopObjects();
        }
    }
    
    public void prepareMedia(){
        Media buyWindow = new Media("SettingsBanner.png");
        addObject(buyWindow,540,360);
        
        Object selledObject = inventory.getOneElemenOfInventary(this.currentSelledObject);
        generateBuyInfo(selledObject);
    }
    
    public void prepareButtons(){
        ToWorldButton back = new ToWorldButton("BackButtonSettings.png","SelectedBackButtonSettings.png",this.previusInventoryWolrd,"PresionedBackButtonSettings.png");
        addObject(back,425,550);
        BuyButton buy = new BuyButton("ApplyButtonSettings.png","SelectedApplyButtonSettings.png",this,"PresionedApplyButtonSettings.png");
        addObject(buy,625,550);
    }
    
    public void generateBuyInfo(Object buy){
       if(buy instanceof GameObject){
            String buySpriteFile = ((GameObject)(buy)).getSpriteFile();
            Media buySprite = new Media(buySpriteFile);
            Media buyName = generateBuyName(((GameObject)(buy)).getName());
            Media buyAmount = generateMyAmountBuy(player.getObjectAmount((((GameObject)(buy)).getId())));
            Media objectAmount = generateObjectAmount(buy);
            addObject(buyName,580,150);
            addObject(buySprite,540,250);
            addObject(buyAmount,580,370);
            addObject(objectAmount,580,390);
        } 
    }
    
    public Media generateObjectAmount(Object obj){
        if(obj instanceof GameObject){
            int amount = ((GameObject)(obj)).getAmount();
            GreenfootImage image = new GreenfootImage(200, 50);  
            Font font = new Font("Arial", 18);  
            image.setFont(font);  
            image.setColor(Color.WHITE);  
            image.drawString("Available: " + amount, 20, 30);  
            Media amountObject = new Media(image);
            return amountObject;
        }
        return null;
    }
    
    public Media generateMyAmountBuy(int amount){
        GreenfootImage image = new GreenfootImage(200, 50);  
        Font font = new Font("Arial", 18);  
        image.setFont(font);  
        image.setColor(Color.BLACK);  
        image.drawString("You have " +amount, 20, 30);  
        Media buyAmount = new Media(image);
        return buyAmount;
    }
    
    public Media generateBuyName(String name){
        GreenfootImage image = new GreenfootImage(200, 50);  
        Font font = new Font("Press Start 2P", 24);  
        image.setFont(font);  
        image.setColor(Color.YELLOW);  
        image.drawString(name, 20, 30);  
        Media buy = new Media(image);
        return buy;
    }   
    
    public InventoryWorld getPreviusInventoryWorld(){
        return this.previusInventoryWolrd;
    }
}
