import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

abstract class Button extends Actor
{
    private GreenfootImage normalImage;
    private GreenfootImage selectImage;
    private GreenfootImage presionedImage;
    private GreenfootSound sound;
    
    protected Button(String imageButton, String imageSelectButton, String imagePresionedButton) {
        normalImage = new GreenfootImage(imageButton);
        selectImage = new GreenfootImage(imageSelectButton);
        presionedImage = new GreenfootImage(imagePresionedButton); 
        setImage(normalImage);
        sound = new GreenfootSound("ButtonSound.wav");
    }
    
    protected Button() {
        normalImage = new GreenfootImage("BasicButton.png");
        selectImage = new GreenfootImage("SelectedBasicButton.png");
        presionedImage = new GreenfootImage("PresionedBasicButton.png");
        setImage(normalImage);
        sound = new GreenfootSound("ButtonSound.wav");
    }
    
    public void setSound(GreenfootSound newsound){
        this.sound=newsound;
    }
    
    public GreenfootSound getSound(){
        return this.sound;
    }
    
    public GreenfootImage getNormalImage(){
        return this.normalImage;
    }
    
    public GreenfootImage getSelectImage(){
        return this.selectImage;
    }
    
    public GreenfootImage getPresionedImage(){
        return this.presionedImage;
    }
    
    abstract void handleMouseClicks();
}

