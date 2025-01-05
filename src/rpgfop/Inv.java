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

        String[] possibleNames = {"Healing Potion", "Elixir", "Strength Amulet", "Speed Boots", "Mana Crystal"};
        String[] possibleDescriptions = {
            "Restores health", "Boosts magic", "Increases attack strength", 
            "Enhances movement speed", "Restores mana"};
        int[] possibleValues = {10, 5, 15, 3, 8};
        String[] possibleTypes = {"HP", "Attack", "Physical Defense", "Movement Speed", "Mana"};

        int randomIndex = random.nextInt(possibleNames.length);
        itemNames[itemCount] = possibleNames[randomIndex];
        descriptions[itemCount] = possibleDescriptions[randomIndex];
        values[itemCount] = possibleValues[randomIndex];
        types[itemCount] = possibleTypes[randomIndex];
        
        mainTextArea.setText("You found a " + itemNames[itemCount] + "! " + descriptions[itemCount] + 
            " (Value: +" + values[itemCount] + ")");
        System.out.println("You found a " + itemNames[itemCount] + "! " + descriptions[itemCount] + 
            " (Value: +" + values[itemCount] + ")");
        itemCount++;
    }

    // Method to use an item from the inventory
    public static void useItem() {
        if (itemCount == 0) {
            mainTextArea.setText("Your inventory is empty!");
            System.out.println("Your inventory is empty!");
            return;
        }

        displayInventory();
        mainTextArea.setText("Enter the number of the item you want to use:");
        boolean found = false;
//        for (int i = 0; i < itemCount; i++) {
//            if (itemNames[i].equalsIgnoreCase(itemName)) {
//                found = true;
//                System.out.println("You used " + itemNames[i] + ". " + descriptions[i] + 
//                    " (+" + values[i] + " " + types[i] + ")");
//
//                // Shift items left to remove the used item
//                for (int j = i; j < itemCount - 1; j++) {
//                    itemNames[j] = itemNames[j + 1];
//                    descriptions[j] = descriptions[j + 1];
//                    values[j] = values[j + 1];
//                    types[j] = types[j + 1];
//                }
//                itemCount--;
//                break;
//            }
//        }

        if (!found) {
            System.out.println("Item not found!");
        }
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
            item[i] = ((i + 1) + ". " + itemNames[i] + ": " + descriptions[i] + 
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