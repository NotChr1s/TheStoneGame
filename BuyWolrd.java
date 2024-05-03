import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        if(selledObject instanceof Attack){
            ((Attack)(selledObject)).decreasesAmount();
            long id=((Attack)(selledObject)).getId();
            String name = ((Attack)(selledObject)).getName();
            String description = ((Attack)(selledObject)).getDescription();
            int amount=1;
            String sprite= ((Attack)(selledObject)).getSpriteFile();
            String category = ((Attack)(selledObject)).getCategory();
            int cost = ((Attack)(selledObject)).getCost();
            String silhouetteSprite = ((Attack)(selledObject)).getSilhouetteSpriteFile();
            Attack object = new Attack(id,name,description,category,cost,amount,sprite,silhouetteSprite);
            player.addObjectToMyAttacks(object);
            int newGold = player.getGold() - ((Attack)(selledObject)).getCost();
            player.setGold(newGold);
            player.saveMyAttacksArrayList();
            player.saveMyData();
            inventory.saveMyShopAttacks();
        }
    }
    
    public void prepareMedia(){
        Media buyWindow = new Media("WindowsShop.png");
        addObject(buyWindow,540,360);
        
        Object selledObject = inventory.getOneElemenOfInventary(this.currentSelledObject);
        generateBuyInfo(selledObject);
    }
    
    public void prepareButtons(){
        if(player.getGold()<getObjectCost()){
            ToWorldButton back = new ToWorldButton("BackButtonSettings.png","SelectedBackButtonSettings.png",this.previusInventoryWolrd,"PresionedBackButtonSettings.png");
            addObject(back,300,490);
        }else{
            ToWorldButton back = new ToWorldButton("BackButtonSettings.png","SelectedBackButtonSettings.png",this.previusInventoryWolrd,"PresionedBackButtonSettings.png");
            addObject(back,300,490);
            BuyButton buy = new BuyButton("BuyButton.png","SelectedBuyButton.png",this,"PresionedBuyButton.png");
            addObject(buy,760,480);
        }
    }
    
    public int getObjectCost(){
        Object selledObject = inventory.getOneElemenOfInventary(this.currentSelledObject);
        if(selledObject instanceof GameObject){
            return ((GameObject)(selledObject)).getCost();
        }
        if(selledObject instanceof Attack){
            return ((Attack)(selledObject)).getCost();
        }
        return 0;
    }
    
    public void generateBuyInfo(Object buy){
       if(buy instanceof GameObject){
            String buySpriteFile = ((GameObject)(buy)).getSpriteFile();
            Media buySprite = new Media(buySpriteFile);
            Media buyName = generateBuyName(((GameObject)(buy)).getName());
            Media buyAmount = generateMyAmountBuy(player.getObjectAmount((((GameObject)(buy)).getId())));
            Media objectAmount = generateObjectAmount(buy);
            generateGoldAndObjectCost(((GameObject)(buy)).getCost());
            addObject(buyName,560,150);
            addObject(buySprite,360,260);
            addObject(buyAmount,570,370);
            addObject(objectAmount,660,390);
        } 
        if(buy instanceof Attack){
            String buySpriteFile = ((Attack)(buy)).getSpriteFile();
            Media buySprite = new Media(buySpriteFile);
            Media buyName = generateBuyName(((Attack)(buy)).getName());
            Media buyAmount = generateMyAmountBuy(player.getObjectAmount((((Attack)(buy)).getId())));
            Media objectAmount = generateObjectAmount(buy);
            generateGoldAndObjectCost(((Attack)(buy)).getCost());
            addObject(buyName,560,150);
            addObject(buySprite,360,270);
            addObject(buyAmount,570,370);
            addObject(objectAmount,570,390);
        } 
    }
    
    public void generateGoldAndObjectCost(int objectCost){
         GreenfootImage image = new GreenfootImage(200, 50);  
        Font font = new Font("Press Start 2P", 18);  
        image.setFont(font);
        image.setColor(Color.BLACK);  
        image.drawString("" +objectCost + " / ", 20, 30);  
        Media objectCostMedia = new Media(image);
        
        int playerGold = player.getGold();
        GreenfootImage image2 = new GreenfootImage(200, 50);  
        Font font2 = new Font("Press Start 2P", 18);  
        image2.setFont(font2);
        if(playerGold<objectCost){
            image2.setColor(Color.RED);  
        }else{
            image2.setColor(Color.BLACK);  
        }
        image2.drawString("" +playerGold, 20, 30);  
        Media playerGoldMedia = new Media(image2);
        
        addObject(playerGoldMedia,630,470);
        addObject(objectCostMedia,510,470);
    }
        
    public Media generateObjectAmount(Object obj){
        if(obj instanceof GameObject){
            int amount = ((GameObject)(obj)).getAmount();
            GreenfootImage image = new GreenfootImage(400, 50);  
            Font font = new Font("Arial", 18);  
            image.setFont(font);  
            image.setColor(Color.WHITE);  
            image.drawString("Available: " + amount, 20, 30);  
            Media amountObject = new Media(image);
            return amountObject;
        }
        if(obj instanceof Attack){
            int amount = ((Attack)(obj)).getAmount();
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
        GreenfootImage image = new GreenfootImage(500, 50);  
        Font font = new Font("Press Start 2P", 24);  
        image.setFont(font);  
        image.setColor(Color.WHITE);  
        image.drawString(name, 20, 30);  
        Media buy = new Media(image);
        return buy;
    }   
    
    public InventoryWorld getPreviusInventoryWorld(){
        return this.previusInventoryWolrd;
    }
}
