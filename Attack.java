import greenfoot.GreenfootImage;

public class Attack  
{
    // instance variables - replace the example below with your own
    private long id;
    private String name;
    private String description;
    private String category;
    private int cost;
    private int amount;
    private GreenfootImage sprite;
    private String spriteFile;
    private GreenfootImage silhouetteSprite;
    private String silhouetteSpriteFile;
    
    public Attack()
    {
    }

    public Attack(long id, String name, String description, String category, int cost, int amount,String sprite, String silhouette)
    {
        this.id=id;
        this.name=name;
        this.description=description;
        this.category=category;
        this.cost=cost;
        this.amount = amount;
        this.sprite=new GreenfootImage(sprite);
        this.spriteFile=sprite;
        this.silhouetteSprite= new GreenfootImage(silhouette);
        this.silhouetteSpriteFile=silhouette;
    }
    
    public long getId() {
        return id;
    }
    
    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public int getCost() {
        return cost;
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
    
    public void decreasesAmount() {
        this.amount--;
    }
}
