import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Write a description of class FileArrayManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FileArrayManager  
{
    /**
     * Constructor for objects of class FileManager
     */
    public FileArrayManager()
    {
    }
    
    public ArrayList<Skin> readArraylistSkin (String fileName){
        ArrayList<Skin> skins= new ArrayList<Skin>();
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
                skins.add(skin);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return skins;
    }
    
    public void saveArraylistSkin(String fileName, ArrayList<Skin> skins) {
        try {
            BufferedWriter writter = new BufferedWriter(new FileWriter(fileName));
            for (Skin skin : skins) {
                String datosAGuardar = skin.getId() + "," + skin.getName() + "," + skin.getRarity() + "," + skin.getSpriteFile();
                writter.write(datosAGuardar);
                writter.newLine(); 
            }
            writter.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    public ArrayList<Attack> readArraylistAttack(String fileName){
        ArrayList<Attack> attacks = new ArrayList<Attack>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                long id = Long.parseLong(attributes[0]);
                String name = attributes[1];
                String description = attributes[2];
                String category = attributes[3];
                int cost = Integer.parseInt(attributes[4]);
                int amount = Integer.parseInt(attributes[5]);
                String fileSprite = attributes[6]; 
                String silhouetteFileSprite = attributes[7]; 
                Attack attack = new Attack(id, name, description, category, cost, amount,fileSprite, silhouetteFileSprite);
                attacks.add(attack);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return attacks;
    }
    
    public void saveArraylistAttack(String fileName, ArrayList<Attack> attacks) {
        try {
            BufferedWriter writter = new BufferedWriter(new FileWriter(fileName));
            for (Attack attack : attacks) {
                String save = attack.getId() + "," + attack.getName() + "," + attack.getDescription() + "," + attack.getCategory() + "," + attack.getCost() + "," + attack.getAmount() + "," +attack.getSpriteFile() + "," +attack.getSilhouetteSpriteFile() +",";
                writter.write(save);
                writter.newLine(); 
            }
            writter.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    public ArrayList<GameObject> readArraylistObject (String fileName){
        ArrayList<GameObject> objects = new ArrayList<GameObject>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");
                long id = Long.parseLong(attributes[0]);
                String name = attributes[1];
                String description = attributes[2];
                int cost = Integer.parseInt(attributes[3]);
                int amount = Integer.parseInt(attributes[4]);
                String fileSprite = attributes[5]; 
                String silhouetteFileSprite = attributes[6]; 
                GameObject object = new GameObject(id, name, description, amount, fileSprite, cost, silhouetteFileSprite);
                objects.add(object);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return objects;
    }
    
    public void saveArraylistObject(String fileName, ArrayList<GameObject> objects) {
        try {
            BufferedWriter writter = new BufferedWriter(new FileWriter(fileName));
            for (GameObject object : objects) {
                String save = object.getId() + "," + object.getName() + "," + object.getDescription() + "," + object.getCost() +"," + object.getAmount() + "," +object.getSpriteFile() + "," +object.getSilhouetteSpriteFile() + ",";
                writter.write(save);
                writter.newLine(); 
            }
            writter.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
}
