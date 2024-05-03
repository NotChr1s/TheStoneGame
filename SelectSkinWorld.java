import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SelectSkinWorld extends Game
{
    private long skinId;
    private MySkinsWorld currentMySkinsWorld;
    
    public SelectSkinWorld(MySkinsWorld previusMySkinsWorld, long skinId)
    {
        super();
        this.skinId = skinId;
        this.currentMySkinsWorld=previusMySkinsWorld;
        prepare();
    }
        
    public void prepare(){
        prepareMedia();
        prepareButtons();
    }
    
    public void prepareMedia(){
        Media buyWindow = new Media("WindowsShop.png");
        addObject(buyWindow,540,360);
        generateSelectedSkinInfo();
    }
    
    public void generateSelectedSkinInfo(){
        Skin selectedSkin = player.getOneSkin(this.skinId);
        String selectedSkinSprite = selectedSkin.getSpriteFile();
        Media selectedSkinMedia = new Media(selectedSkinSprite);
        Media selectedName = generateSelectedName(selectedSkin.getName());
        addObject(selectedName,560,150);
        addObject(selectedSkinMedia,360,260);
    }
    
    public Media generateSelectedName(String name){
        GreenfootImage image = new GreenfootImage(500, 50);  
        Font font = new Font("Press Start 2P", 24);  
        image.setFont(font);  
        image.setColor(Color.WHITE);  
        image.drawString(name, 20, 30);  
        Media selected = new Media(image);
        return selected;
    }
    
    public void prepareButtons(){
        ToWorldButton back = new ToWorldButton("BackButtonSettings.png","SelectedBackButtonSettings.png",this.currentMySkinsWorld,"PresionedBackButtonSettings.png");
        addObject(back,300,490);
        ChangeCurrentSkinButton buy = new ChangeCurrentSkinButton("BuyButton.png","SelectedBuyButton.png",this,"PresionedBuyButton.png");
        addObject(buy,760,480);
    }
    
    public MySkinsWorld getCurrentMySkinsWorld(){
        return this.currentMySkinsWorld;
    }
    
    public void changeTheCurrentSkin(){
        Skin selectedSkin = player.getOneSkin(this.skinId);
        player.setCurrentSkin(selectedSkin);
        player.saveCurrentSkin("CurrentSkin.txt");
    }
}
