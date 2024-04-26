import java.util.ArrayList;

public class ShopInventory  
{
    private int lowerLimit;
    private int topLimit;
    private ArrayList<Attack> shopAttacks;
    private ArrayList<GameObject> shopObjects;
    private ArrayList<Object> inventory;
    private FileArrayManager fileManager;

    public ShopInventory()
    {
        this.lowerLimit=0;
        this.topLimit=5;
        shopObjects = new ArrayList<GameObject>(); 
        inventory = new ArrayList<Object>();
        fileManager = new FileArrayManager();
        shopObjects=fileManager.readArraylistObject("ShopObjects.txt");
        shopAttacks =fileManager.readArraylistAttack("ShopAttacks.txt");
        fillInventory();
    }
    
    public ShopInventory(int lowerLimit, int topLimit)
    {
        this.lowerLimit=lowerLimit;
        this.topLimit=topLimit;
        shopObjects = new ArrayList<GameObject>(); 
        inventory = new ArrayList<Object>();
        fileManager = new FileArrayManager();
        shopObjects=fileManager.readArraylistObject("ShopObjects.txt");
        shopAttacks =fileManager.readArraylistAttack("ShopAttacks.txt");
        fillInventory();
    }
    
    private void fillInventory(){
        for(GameObject object: shopObjects){
            Object inventoryUnit = object;
            inventory.add(inventoryUnit);
        }
        for(Attack attack: shopAttacks){
            Object inventoryUnit = attack;
            inventory.add(inventoryUnit);
        }
    }
    
    public int getInventorySize(){
        return this.inventory.size();
    }
    
    public int getInventoryLowerLimit(){
        return this.lowerLimit;
    }
    
    public int getInventoryTopLimit(){
        return this.topLimit;
    }
    
    public ArrayList<Object> getInventory(){
        return this.inventory;
    }
    
    public Object getOneElemenOfInventary(long id){
        for(Object unit: inventory){
            if(unit instanceof GameObject){
                if(((GameObject)(unit)).getId()==id){
                    return unit;
                }
            }
            if(unit instanceof Attack){
                if(((Attack)(unit)).getId()==id){
                    return unit;
                }
            }
        }
        return null;
    }
    
    public void saveMyShopObjects(){
        fileManager.saveArraylistObject("ShopObjects.txt",shopObjects);
    }
    
    public void saveMyShopAttacks(){
        fileManager.saveArraylistAttack("ShopAttacks.txt",shopAttacks);
    }
}
