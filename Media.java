import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Media extends Actor
{
    private GreenfootImage image;
    
    public Media()
    {
        image = new GreenfootImage("defaultMedia");
        setImage(image);
    }
    
    public Media(String media)
    {
        image = new GreenfootImage(media);
        setImage(image);
    }
    
    public void setMedia(GreenfootImage newImage)
    {
        this.image = newImage;
    }
}
