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
    private GreenfootImage imagenPresionado;
    private World newWorld;
    
    public Button(String imageButton, String imageSelectButton, World newWorld, String imagePresionedButton) {
        imagenNormal = new GreenfootImage(imageButton);
        imagenSeleccion = new GreenfootImage(imageSelectButton);
        imagenPresionado = new GreenfootImage(imagePresionedButton); 
        setImage(imagenNormal);
        this.newWorld= newWorld;
    }
    
    public Button() {
        imagenNormal = new GreenfootImage("BasicButton.png");
        imagenSeleccion = new GreenfootImage("SelectedBasicButton.png");
        imagenPresionado = new GreenfootImage("PresionedBasicButton.png");
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
            setImage(imagenPresionado);
            Greenfoot.delay(7); 
            setImage(imagenNormal);
            Greenfoot.setWorld(newWorld);
        }
    }
}

