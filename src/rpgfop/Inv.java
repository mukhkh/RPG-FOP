/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpgfop;

/**
 *
 * @author USER
 */

//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Arrays;
//import java.util.Scanner;
import java.util.Random;
import static rpgfop.game.mainTextArea;
import static rpgfop.game.playeratk;
import static rpgfop.game.playerhp;
public class Inv {
    // item is limited to 5
    static String[] itemNames = new String[5];
    static String[] descriptions = new String[5];
    static int[] values = new int[5];
    static String[] types = new String[5];
    static int itemCount = 0;
    static Random random = new Random();
    static StringBuilder sb;
    
    // Method to find and add a new item to the inventory
    //will be displayed when player choose to move east only(as of now)
    public static void findItem() {
        if (itemCount >= 5) {
            mainTextArea.setText("Inventory is full!");
            System.out.println("Inventory is full!");
            return;
        }

        String[] possibleNames = {"Health Potion","Strength Amulet"};
        String[] possibleDescriptions = {
            "Restores health", "Increases attack strength"};
        int[] possibleValues = {10, 5};
        String[] possibleTypes = {"HP", "Attack",};

        int randomIndex = random.nextInt(possibleNames.length);
        itemNames[itemCount] = possibleNames[randomIndex];
        descriptions[itemCount] = possibleDescriptions[randomIndex];
        values[itemCount] = possibleValues[randomIndex];
        types[itemCount] = possibleTypes[randomIndex];
        
        mainTextArea.setText("You found a " + itemNames[itemCount] + "! " + "( " + values[itemCount] + ")");
        System.out.println("You found a " + itemNames[itemCount] + "! " + descriptions[itemCount] + 
            " (Value: +" + values[itemCount] + ")");
        
        
       
        if(itemNames[itemCount].equals("Health Potion")){
            playerhp += values[itemCount];
        }
        if(itemNames[itemCount].equals("Strength Amulet")){
            playeratk += values[itemCount];
        }
        itemCount++;
    }
    
    // Method to display all items in the inventory
    public static void displayInventory() {

        if (itemCount == 0) {
            mainTextArea.setText("Your inventory is empty!");
            System.out.println("Your inventory is empty!");
            return;
        }
        String[] item = new String[itemCount];
        System.out.println("Inventory:");
        for (int i = 0; i < itemCount; i++) {
            item[i] = ((i + 1) + "." + itemNames[i] + ":" + 
                " (Value: +" + values[i] + " " + types[i] + ")");
            
            System.out.println((i + 1) + ". " + itemNames[i] + ": " + descriptions[i] + 
                " (Value: +" + values[i] + " " + types[i] + ")");
        }
        sb = new StringBuilder();
        for(String s : item ){
            sb.append(s).append("\n");
        }
        
        mainTextArea.setText(sb.toString());
    }
}