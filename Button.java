import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

class Button extends Actor
{
    private GreenfootImage imagenNormal;
    private World newWorld;
    
    public Button(String imageButton, World newWorld) {
        imagenNormal = new GreenfootImage(imageButton);
        setImage(imagenNormal);
        this.newWorld= newWorld;
    }
    
    public Button() {
        imagenNormal = new GreenfootImage("BasicButton.png");
        setImage(imagenNormal);
        this.newWorld= new InitialWorld();
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(newWorld);
        }
    }
}

