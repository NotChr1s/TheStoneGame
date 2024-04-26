import greenfoot.GreenfootImage;

/**
 * Write a description of class GameObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameObject  
{
    // instance variables - replace the example below with your own
    private long id;
    private String name;
    private String description;
    private int amount;
    private GreenfootImage sprite;
    private String spriteFile;
    private int cost;
    private GreenfootImage silhouetteSprite;
    private String silhouetteSpriteFile;
    
    protected GameObject()
    {
    }

    protected GameObject(long id, String name, String description, int amount, String sprite, int cost, String silhouette)
    {
        this.id=id;
        this.name=name;
        this.description=description;
        this.amount=amount;
        this.sprite=new GreenfootImage(sprite);
        this.spriteFile=sprite;
        this.cost=cost;
        this.silhouetteSprite= new GreenfootImage(silhouette);
        this.silhouetteSpriteFile=silhouette;
    }
    
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public GreenfootImage getSprite() {
        return sprite;
    }

    public String getSpriteFile() {
        return spriteFile;
    }
    
    public GreenfootImage getSilhouetteSprite() {
        return silhouetteSprite;
    }

    public String getSilhouetteSpriteFile() {
        return silhouetteSpriteFile;
    }
    
    public int getCost(){
        return this.cost;
    }
    
    public void increasesAmount() {
        this.amount++;
    }
    
    public void decreasesAmount() {
        this.amount--;
    }
}
