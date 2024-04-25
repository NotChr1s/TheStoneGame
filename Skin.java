import greenfoot.GreenfootImage;

/**
 * Write a description of class Skin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skin  
{
    // instance variables - replace the example below with your own
    private long id;
    private String name;
    private String rarity;
    private GreenfootImage sprite;
    private String spriteFile;

    public Skin()
    {
    }
    
    public Skin(long id, String name, String rarity, String sprite)
    {
        this.id=id;
        this.name=name;
        this.rarity=rarity;
        this.sprite=new GreenfootImage(sprite);
        this.spriteFile=sprite;
    }
    
     public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getRarity() {
        return rarity;
    }
    
    public GreenfootImage getSprite() {
        return sprite;
    }
    
    public String getSpriteFile() {
        return spriteFile;
    }

}
