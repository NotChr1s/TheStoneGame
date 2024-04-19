import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InitialWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InitialWorld extends World
{
    private static World world;
    private GreenfootSound bgMusic;
    /**
     * Constructor for objects of class InitialWorld.
     * 
     */
    public InitialWorld()
    {    
        super(1080, 720, 1); 
        world = this;
        bgMusic= new GreenfootSound("A game of rocks.mp3");
        prepare();
    }
    
    private void prepareButtons()
    {
        World world = new CombatWorld();
        Button button1 = new Button("CombatButton.png","SelectedCombatButton.png",world,"PresionedCombatButton.png");
        addObject(button1,540,350);
        World world2 = new ClosetWorld();
        Button button2 = new Button("ClosetButton.png","SelectedClosetButton.png",world2,"PresionedClosetButton.png");
        addObject(button2,270,550);
        World world3 = new ShopWorld();
        Button button3 = new Button("ShopButton.png","SelectedShopButton.png",world,"PresionedShopButton.png");
        addObject(button3,810,550);
        World world4 = new GachaWorld();
        Button button4 = new Button("GachaButton.png","SelectedGachaButton.png",world4,"PresionedGachaButton.png");
        addObject(button4,540,600);
        World world5 = new SettingsWorld();
        Button button5 = new Button("SettingsButton.png","SelectedSettingsButton.png",world5,"PresionedSettingsButton.png");
        GreenfootSound newSound = new GreenfootSound("ButtonSound2.wav");
        button5.setSound(newSound);
        addObject(button5,50,670);
    }
    
    private void prepare()
    {
        GreenfootImage nuevaImagenFondo = new GreenfootImage("ProvisionalBG2.jpg");
        setBackground(nuevaImagenFondo);
        Media title = new Media("Title.png");
        addObject(title,540,150);
        prepareButtons();
        if(!bgMusic.isPlaying()){
            bgMusic.play();
        }
    }
    
        public static World getThisWorld(){
        return world;
    }
}
