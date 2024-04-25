import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class ShopWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShopWorld extends Game
{
    private int lowerLimit;
    private int topLimit;
    private ArrayList<Attack> shopattacks;
    private ArrayList<GameObject> shopObjects;
    private ArrayList<Object> inventory;
    private FileArrayManager fileManager;
    private boolean buyStatus;
    private long idBuyObject;
    private boolean ifISell;
    
    public ShopWorld()
    {    
        super(); 
        this.lowerLimit=0;
        this.topLimit=5;
        shopObjects = new ArrayList<GameObject>(); 
        inventory = new ArrayList<Object>();
        fileManager = new FileArrayManager();
        shopObjects=fileManager.readArraylistObject("ShopObjects.txt");
        fillInventory();
        this.buyStatus=false;
        this.idBuyObject=-1;
        this.ifISell=false;
        prepare();
    }
    public ShopWorld(int lowerLimit, int topLimit)
    {    
        super(); 
        this.lowerLimit=lowerLimit;
        this.topLimit=topLimit;
        shopObjects = new ArrayList<GameObject>(); 
        inventory = new ArrayList<Object>();
        fileManager = new FileArrayManager();
        shopObjects=fileManager.readArraylistObject("ShopObjects.txt");
        fillInventory();
        this.buyStatus=false;
        this.idBuyObject=-1;
        this.ifISell=false;
        prepare();
    }
    public ShopWorld(int lowerInt, int topLimit, boolean buyStatus, long buyId){
        super();
        initialize();
        this.lowerLimit=lowerLimit;
        this.topLimit=topLimit;
        this.buyStatus=buyStatus;
        this.idBuyObject=buyId;
        prepare();
    }
    public ShopWorld(int lowerInt, int topLimit, boolean ifISell, boolean buyStatus, long buyId){
        super();
        initialize();
        this.lowerLimit=lowerLimit;
        this.topLimit=topLimit;
        this.buyStatus=buyStatus;
        this.idBuyObject=buyId;
        this.ifISell=true;
        prepare();
    }
    public void initialize(){
        this.lowerLimit=0;
        this.topLimit=5;
        shopObjects = new ArrayList<GameObject>(); 
        inventory = new ArrayList<Object>();
        fileManager = new FileArrayManager();
        shopObjects=fileManager.readArraylistObject("ShopObjects.txt");
        fillInventory();
        this.buyStatus=false;
        this.idBuyObject=-1;
        this.ifISell=false;
    }
    public void saveMyShopObjects(){
        fileManager.saveArraylistObject("ShopObjects.txt",shopObjects);
    }
    public void sellObject(){
        Object selledObject = searchObjectInventory(this.idBuyObject);
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
            saveMyShopObjects();
        }
    }
    private void prepare()
    {
        if(ifISell){
            sellObject();
        }
        if(buyStatus==true){
            prepareMedia(); 
            prepareButtons();
        }else{
            prepareStatusFalseMedia();
            prepareStatusFalseButtons();
        }
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
    
    public void fillInventory(){
        for(GameObject object: shopObjects){
            Object inventoryUnit = object;
            inventory.add(inventoryUnit);
        }
    }
    public int getLowerLimit(){
        return this.lowerLimit;
    }
    public int getTopLimit(){
        return this.topLimit;
    }

    public void prepareButtons(){
        BuyShopButton back = new BuyShopButton("BackButtonSettings.png","SelectedBackButtonSettings.png","PresionedBackButtonSettings.png",lowerLimit,topLimit,buyStatus,idBuyObject,false);
        addObject(back,425,550);
        BuyShopButton buy = new BuyShopButton("ApplyButtonSettings.png","SelectedApplyButtonSettings.png","PresionedApplyButtonSettings.png",lowerLimit,topLimit,buyStatus,idBuyObject,true);
        addObject(buy,625,550);
    }
    public void prepareMedia(){
        prepareMediaFalseButtons();
        
        GreenfootImage image = new GreenfootImage(200, 50);  
        Font font = new Font("Press Start 2P", 24);  
        image.setFont(font);  
        image.setColor(Color.YELLOW);  
        image.drawString(" " +getLowerLimit(), 20, 30);  
        Media lowlimit = new Media(image);
        addObject(lowlimit,570,60);
        
        GreenfootImage image2 = new GreenfootImage(200, 50);  
        Font fon2 = new Font("Press Start 2P", 24);  
        image2.setFont(fon2);  
        image2.setColor(Color.YELLOW);  
        image2.drawString(" " +getTopLimit(), 20, 30);  
        Media toplimit = new Media(image2);
        addObject(toplimit,770,60);
        
        GreenfootImage image3 = new GreenfootImage(200, 50);  
        Font fon3 = new Font("Press Start 2P", 24);  
        image3.setFont(fon3);  
        image3.setColor(Color.YELLOW);  
        image3.drawString(" " +inventory.size(), 20, 30);  
        Media size = new Media(image3);
        addObject(size,670,60);
        
        Media buyBanner = new Media("SelectedBasicButton.png");
        addObject(buyBanner,540,360);
        Object buyObject = searchObjectInventory(this.idBuyObject);
        generateBuyInfo(buyObject);
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
    
    public Object searchObjectInventory(long id){
        for(Object unit: inventory){
            if(unit instanceof GameObject){
                if(((GameObject)(unit)).getId()==id){
                    return unit;
                }
            }
        }
        return null;
    }
    
    public void prepareMediaFalseButtons(){
        if(lowerLimit<=0){
            Media button1 = new Media("ButtonArrow.png");
            addObject(button1,1000,360);
        }else if(topLimit<=(inventory.size()-1)){
            Media button1 = new Media("ButtonArrow.png");
            Media button2 = new Media("LeftArrowButton.png");
            addObject(button1,1000,360);
            addObject(button2,30,360);
        }else{
            Media button2 = new Media("LeftArrowButton.png");
            addObject(button2,30,360);
        }
        
        displayPlayerGold();
        int j=1;
        for(int i=lowerLimit;((i<=(inventory.size()-1))&&(i<=topLimit));i++){
            Object unit = inventory.get(i);
            if(unit instanceof GameObject){
                String spriteFile = ((GameObject)(unit)).getSpriteFile();
                Media sprite = new Media(spriteFile);
                if(j<=3){
                    addObject(sprite,200+(j*200),200);
                }else{
                    addObject(sprite,(j*200)-400,400);
                }
            }
            j++;
        }
    }
    
    public void prepareStatusFalseMedia(){
        displayPlayerGold();
        int j=1;
        for(int i=lowerLimit;((i<=(inventory.size()-1))&&(i<=topLimit));i++){
            Object unit = inventory.get(i);
            if(unit instanceof GameObject){
                if(((GameObject)(unit)).getAmount()>0){
                    String spriteFile = ((GameObject)(unit)).getSpriteFile();
                    long objectId = ((GameObject)(unit)).getId();
                    BuyShopButton button = new BuyShopButton(spriteFile,spriteFile,spriteFile,lowerLimit,topLimit,this.buyStatus,objectId,false);
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
        
        GreenfootImage image = new GreenfootImage(200, 50);  
        Font font = new Font("Press Start 2P", 24);  
        image.setFont(font);  
        image.setColor(Color.RED);  
        image.drawString(" " +getLowerLimit(), 20, 30);  
        Media lowlimit = new Media(image);
        addObject(lowlimit,570,60);
        
        GreenfootImage image2 = new GreenfootImage(200, 50);  
        Font fon2 = new Font("Press Start 2P", 24);  
        image2.setFont(fon2);  
        image2.setColor(Color.YELLOW);  
        image2.drawString(" " +getTopLimit(), 20, 30);  
        Media toplimit = new Media(image2);
        addObject(toplimit,770,60);
        
        GreenfootImage image3 = new GreenfootImage(200, 50);  
        Font fon3 = new Font("Press Start 2P", 24);  
        image3.setFont(fon3);  
        image3.setColor(Color.YELLOW);  
        image3.drawString(" " +inventory.size(), 20, 30);  
        Media size = new Media(image3);
        addObject(size,670,60);
    }
    
    public void prepareStatusFalseButtons(){
       if(lowerLimit<=0){
            ShopButton button1= new InventoryShopButton("ButtonArrow.png","ButtonArrowSelected.png","ButtonArrowPresioned.png",true,lowerLimit,topLimit);
            addObject(button1,1000,360);
        }else if(topLimit<=(inventory.size()-1)){
            ShopButton button1= new InventoryShopButton("ButtonArrow.png","ButtonArrowSelected.png","ButtonArrowPresioned.png",true,lowerLimit,topLimit);
            ShopButton button2= new InventoryShopButton("LeftArrowButton.png","LeftArrowButtonSelected.png","LeftArrowButtonPresioned.png",false,lowerLimit,topLimit);
            addObject(button1,1000,360);
            addObject(button2,30,360);
        }else{
            ShopButton button2= new InventoryShopButton("LeftArrowButton.png","LeftArrowButtonSelected.png","LeftArrowButtonPresioned.png",false,lowerLimit,topLimit);
            addObject(button2,30,360);
        } 
    }
}
