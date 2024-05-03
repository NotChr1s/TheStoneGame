import greenfoot.GreenfootImage;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Player  
{
    private String name;
    private int xp;
    private int level;
    private int gold;
    private int crystal;
    private int personalBest;
    private Skin currentSkin;
    private ArrayList<Skin> skins;
    private ArrayList<Attack> attacks;
    private ArrayList<GameObject> objects;
    private Rock rock;
    private FileArrayManager fileManager;
    
    public Player()
    {
        readFileData("playerData.txt");
        readCurrentSkin("CurrentSkin.txt");
        this.skins = new ArrayList<Skin>();
        this.attacks = new ArrayList<Attack>();
        this.objects = new ArrayList<GameObject>();
        this.fileManager = new FileArrayManager();
        this.skins=fileManager.readArraylistSkin("MySkins.txt");
        this.objects=fileManager.readArraylistObject("MyObjects.txt");
        this.attacks = fileManager.readArraylistAttack("MyAttacks.txt");
        this.rock=readRockData();
    }
    
    private void readFileData(String fileName){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                this.name = attributes[0];
                this.xp = Integer.parseInt(attributes[1]);
                this.level = Integer.parseInt(attributes[2]);
                this.gold = Integer.parseInt(attributes[3]);
                this.crystal = Integer.parseInt(attributes[4]);
                this.personalBest = Integer.parseInt(attributes[5]);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    private Rock readRockData(){
        ArrayList<Attack> attacks = fileManager.readArraylistAttack("MyRockAttacks.txt");
        int life=0;
        int attack=0;
        int defense=0;
        int speed=0;
        int evasion=0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Myatributtes.txt"));
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                life = Integer.parseInt(attributes[0]);
                attack = Integer.parseInt(attributes[1]);
                defense = Integer.parseInt(attributes[2]);
                speed =Integer.parseInt(attributes[3]);
                evasion = Integer.parseInt(attributes[4]);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        Rock newRock = new Rock(life,attack,defense,evasion,speed,attacks);
        return newRock;
    }
    
    
    public void saveMyData(){
        saveDataPlayer("playerData.txt");
    }
    
    public void saveDataPlayer(String fileName) {
        try {
            BufferedWriter writter = new BufferedWriter(new FileWriter(fileName));
            String save = name + "," + xp + "," + level + "," + gold + "," + crystal + "," + personalBest;
            writter.write(save);
            writter.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    } 
    
    private void readCurrentSkin (String fileName){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] atributos = line.split(",");
                long id = Long.parseLong(atributos[0]);
                String name = atributos[1];
                String rarity = atributos[2];
                String fileSprite = atributos[3]; 
                Skin skin = new Skin(id, name, rarity, fileSprite);
                this.currentSkin= new Skin(id,name,rarity,fileSprite);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    public void saveCurrentSkin(String fileName) {
        try {
            BufferedWriter writter = new BufferedWriter(new FileWriter(fileName));
            String save = currentSkin.getId() + "," + currentSkin.getName() + "," + currentSkin.getRarity() + "," + currentSkin.getSpriteFile();
            writter.write(save);
            writter.newLine(); 
            writter.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    public String getCurrentSkinFileName(){
        return currentSkin.getSpriteFile();
    }
    
    public int getGold(){
        return this.gold;
    }
    
    public void setGold(int newGold){
        this.gold=newGold;
    }
    
    public Rock getRock(){
        return this.rock;
    }
    
    public ArrayList<GameObject> getMyObjects(){
        return this.objects;
    }
    
    public void addObjectToMyObjects(GameObject newObject){
        for(GameObject object : objects){
            if(object.getId()==newObject.getId()){
                object.increasesAmount();
                return;
            }
        }
        objects.add(newObject);
    }
    
    public void addObjectToMyAttacks(Attack newAttack){
        attacks.add(newAttack);
    }
    
    public boolean searchObject(long id){
        for(GameObject object: objects){
            if(object.getId()==id){
                return true;
            }
        }
        return false;
    }
    
    public int getObjectAmount(long id){
        if(searchObject(id)){
           for(GameObject object: objects){
                if(object.getId()==id){
                    return object.getAmount();
                }
            }    
        }
        return 0;
    }
    
    public void saveMyObjectsArrayList(){
        fileManager.saveArraylistObject("MyObjects.txt",objects);
    }
    
    public void saveMyAttacksArrayList(){
        fileManager.saveArraylistAttack("MyAttacks.txt",attacks);
    }
    
    public String getName(){
        return this.name;
    }
    
    public ArrayList<Skin> getSkins(){
        return this.skins;
    }
    
    public Skin getOneSkin(long id){
        for(Skin skin: skins){
            if(skin.getId()==id){
                return skin;
            }
        }
        return null;
    }
    
    public void setCurrentSkin(Skin newCurrentSkin){
        this.currentSkin= newCurrentSkin;
    }

}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 