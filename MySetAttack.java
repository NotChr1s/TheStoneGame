import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class MySetAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MySetAttack extends Game
{
    public MySetAttack()
    {
        super();
        prepare();
    }
    
    public void prepare(){
        prepareMedia();
        prepareButtons();
    }
    
    public void prepareMedia(){
        Media text1 = generateText("These are your attacks",22,500);
        Media text2 = generateText("do you want to change them?",14,400);
        addObject(text1,540,50);
        addObject(text2,540,100);
    }
    
    public Media generateText(String text, int fontsize,int mediasize){
        GreenfootImage image = new GreenfootImage(mediasize, 50);  
        Font font = new Font("Press Start 2P", fontsize);  
        image.setFont(font);  
        image.setColor(Color.BLACK);  
        image.drawString(text, 20, 30);  
        Media textMedia = new Media(image);
        return textMedia;
    }
    
    public void prepareButtons(){
        ArrayList<Attack> attacks = player.getRock().getAttacks();
        int j=0;
        for(Attack attack: attacks){
            String spriteFile = attack.getSpriteFile();
            long attackId = attack.getId();
            ToMyAttacksWorldButton attackButton = new ToMyAttacksWorldButton(spriteFile,spriteFile,spriteFile,attackId);
            if(j<=1){
                addObject(attackButton,(j*360)+360,240);
            }else{
                addObject(attackButton,((j-2)*360)+360,480);
            }
            j++;
        }
        ToClosetButton backCloset = new ToClosetButton("UniversalBackButton.png","UniversalBackButton.png","UniversalBackButtonPresioned.png");
        addObject(backCloset,70,50);
    }
}
