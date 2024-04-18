import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InitialWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InitialWorld extends World
{

    /**
     * Constructor for objects of class InitialWorld.
     * 
     */
    public InitialWorld()
    {    
        super(1080, 720, 1); 
        prepare();
    }
    
    private void prepare()
    {
        GreenfootImage nuevaImagenFondo = new GreenfootImage("ProvisionalBG2.jpg");
        setBackground(nuevaImagenFondo);
        GameTitle gametitle = new GameTitle();
        addObject(gametitle,540,150);
        World world = new CombatWorld();
        Button button1 = new Button("CombatButton.png",world);
        addObject(button1,540,350);
        World world2 = new ClosetWorld();
        Button button2 = new Button("ClosetButton.png",world2);
        addObject(button2,270,550);
        World world3 = new ShopWorld();
        Button button3 = new Button("ShopButton.png",world3);
        addObject(button3,810,550);
        World world4 = new GachaWorld();
        Button button4 = new Button("GachaButton.png",world4);
        addObject(button4,540,600);
        World world5 = new CombatWorld();
        Button button5 = new Button("SettingsButton.png",world5);
        addObject(button5,50,670);
    }
}
