import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InitialWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InitialWorld extends Game
{
    private static World world;
    /**
     * Constructor for objects of class InitialWorld.
     * 
     */
    public InitialWorld()
    {    
        super(); 
        world = this;
        music= new GreenfootSound("A game of rocks.mp3");
        prepare();
    }
    
    public void prepareButtons()
    {
        World world = new CombatWorld();
        ToWorldButton button1 = new ToWorldButton("CombatButton.png","SelectedCombatButton.png",world,"PresionedCombatButton.png");
        addObject(button1,540,350);
        
        world = new ClosetWorld();
        ToWorldButton button2 = new ToWorldButton("ClosetButton.png","SelectedClosetButton.png",world,"PresionedClosetButton.png");
        addObject(button2,270,550);
        
        world = new InventoryWorld();
        ToWorldButton button3 = new ToWorldButton("ShopButton.png","SelectedShopButton.png",world,"PresionedShopButton.png");
        addObject(button3,810,550);
        
        world = new GachaWorld();
        ToWorldButton button4 = new ToWorldButton("GachaButton.png","SelectedGachaButton.png",world,"PresionedGachaButton.png");
        addObject(button4,540,600);
        
        world = new SettingsWorld();
        ToWorldButton button5 = new ToWorldButton("SettingsButton.png","SelectedSettingsButton.png",world,"PresionedSettingsButton.png");
        GreenfootSound newSound = new GreenfootSound("ButtonSound2.wav");
        button5.setSound(newSound);
        addObject(button5,50,670);
    }
    
    public void prepareMedia(){
        GreenfootImage nuevaImagenFondo = new GreenfootImage("ProvisionalBG2.jpg");
        setBackground(nuevaImagenFondo);
        Media title = new Media("Title.png");
        addObject(title,540,150);
    }
    
    private void prepare()
    {
        prepareMedia();
        prepareButtons();
        if(!music.isPlaying()){
            music.play();
        }
    }
    
        public static World getThisWorld(){
        return world;
    }
}
