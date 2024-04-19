import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingsWorld extends World
{

    /**
     * Constructor for objects of class SettingsWorld.
     * 
     */
    public SettingsWorld()
    {    
        super(1080, 720, 1); 
        prepareButtons();
    }
    
    private void prepareButtons()
    {
        
        World initialWorld = InitialWorld.getThisWorld();
        // Crear el botón con la referencia al mundo actual
        Button buttonGoBack = new Button("BackButtonSettings.png","SelectedBackButtonSettings.png",initialWorld,"PresionedBackButtonSettings.png");
        addObject(buttonGoBack,425,450);
        Button buttonApply = new Button("ApplyButtonSettings.png","SelectedApplyButtonSettings.png",initialWorld,"PresionedApplyButtonSettings.png");
        addObject(buttonApply,700,450);
    }

}
