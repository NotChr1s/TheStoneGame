import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)s

public class ClosetWorld extends Game
{
    private static World world;
    public ClosetWorld()
    {    
        super();
        prepareMedia();
        world = this;
        prepareButtons();
    }
    public void prepareButtons(){
        World initialWorld = InitialWorld.getThisWorld();
        // Crear el botón con la referencia al mundo actual
        ToWorldButton universalBack = new ToWorldButton("UniversalBackButton.png","UniversalBackButton.png",initialWorld,"UniversalBackButtonPresioned.png");
        addObject(universalBack,70,50);
        
        MySkinsWorld skinsWorld = new MySkinsWorld();
        ToWorldButton skins = new ToWorldButton("ApplyButtonSettings.png","SelectedApplyButtonSettings.png",skinsWorld,"PresionedApplyButtonSettings.png");
        addObject(skins,900,50);
        
        MyObjectsWorld objectsWorld = new MyObjectsWorld();
        ToWorldButton objects = new ToWorldButton("ApplyButtonSettings.png","SelectedApplyButtonSettings.png",objectsWorld,"PresionedApplyButtonSettings.png");
        addObject(objects,900,150);
        
        MySetAttack attacksWorld = new MySetAttack();
        ToWorldButton attacks = new ToWorldButton("ApplyButtonSettings.png","SelectedApplyButtonSettings.png",attacksWorld,"PresionedApplyButtonSettings.png");
        addObject(attacks,700,50);
    }
    public void prepareMedia(){
        Media name = generateName(player.getName());
        Media currentSkin = new Media(player.getCurrentSkinFileName());
        addObject(currentSkin,250,250);
        addObject(name,250,50);
        prepareAtributtes();
    }
    
    public void prepareAtributtes(){
        Media life= generateAnAtributte("LIFE",player.getRock().getLife());
        Media attack= generateAnAtributte("ATTACK",player.getRock().getAttack());
        Media defense= generateAnAtributte("DEFENSE",player.getRock().getDefense());
        Media speed= generateAnAtributte("SPEED",player.getRock().getSpeed());
        Media evasion= generateAnAtributte("EVASION",player.getRock().getEvasion());
        addObject(life,150,450);
        addObject(attack,550,450);
        addObject(defense,150,550);
        addObject(speed,550,550);
        addObject(evasion,150,650);
    }
    
    public Media generateAnAtributte(String atributteType,int atributte){
        GreenfootImage image = new GreenfootImage(250, 40);  
        Font font = new Font("Press Start 2P", 20);  
        image.setFont(font);  
        image.setColor(Color.WHITE);  
        image.drawString(atributteType +": " +atributte, 20, 30);  
        Media atributteMedia = new Media(image);   
        return atributteMedia;
   }
   
   public Media generateName(String name){
        GreenfootImage image = new GreenfootImage(200, 40);  
        Font font = new Font("Press Start 2P", 18);  
        image.setFont(font);  
        image.setColor(Color.WHITE);  
        image.drawString(name, 20, 30);  
        Media nameMedia = new Media(image);   
        return nameMedia;
   }
   
   public static World getThisWorld(){
        return world;
    }
}
