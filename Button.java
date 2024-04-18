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
    private GreenfootImage imagenSeleccion;
    private World newWorld;
    
    public Button(String imageButton, String imageSelectButton, World newWorld) {
        imagenNormal = new GreenfootImage(imageButton);
        imagenSeleccion = new GreenfootImage(imageSelectButton);
        setImage(imagenNormal);
        this.newWorld= newWorld;
    }
    
    public Button() {
        imagenNormal = new GreenfootImage("BasicButton.png");
        imagenSeleccion = new GreenfootImage("SelectedBasicButton.png");
        setImage(imagenNormal);
        this.newWorld= new InitialWorld();
    }
    
    public void act() {
        if (Greenfoot.mouseMoved(this)) {  
            setImage(imagenSeleccion);  
        } 
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {  
            setImage(imagenNormal);  
        }
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(newWorld);
        }
    }
}

