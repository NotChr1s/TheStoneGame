import greenfoot.GreenfootImage;

/**
 * Write a description of class Attack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attack  
{
    // instance variables - replace the example below with your own
    private long id;
    private String name;
    private String description;
    private String category;
    private int cost;
    private GreenfootImage sprite;
    private String spriteFile;
    
    /**
     * Constructor for objects of class Attack
     */
    public Attack()
    {
    }

    public Attack(long id, String name, String description, String category, int cost, String sprite)
    {
        this.id=id;
        this.name=name;
        this.description=description;
        this.cost=cost;
        this.sprite=new GreenfootImage(sprite);
        this.spriteFile=sprite;
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
}
