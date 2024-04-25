import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingsWorld extends Game
{

    /**
     * Constructor for objects of class SettingsWorld.
     * 
     */
    public SettingsWorld()
    {    
        super(); 
        prepareButtons();
    }
    
    public void prepareButtons()
    {
        World initialWorld = InitialWorld.getThisWorld();
        // Crear el botón con la referencia al mundo actual
        ToWorldButton buttonGoBack = new ToWorldButton("BackButtonSettings.png","SelectedBackButtonSettings.png",initialWorld,"PresionedBackButtonSettings.png");
        addObject(buttonGoBack,425,450);
        ToWorldButton buttonApply = new ToWorldButton("ApplyButtonSettings.png","SelectedApplyButtonSettings.png",initialWorld,"PresionedApplyButtonSettings.png");
        addObject(buttonApply,700,450);
    }
    
    public void prepareMedia(){}
}
