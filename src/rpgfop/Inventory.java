package rpg;

import java.util.Scanner;
import java.util.Random;

public class Inventory {

    private String[] itemNames = new String[10];
    private String[] descriptions = new String[10];
    private int[] values = new int[10];
    private String[] types = new String[10];
    private int itemCount = 0;
    private Random random = new Random();

    public void findItem() {
        if (itemCount >= 10) {
            System.out.println("Inventory is full!");
            return;
        }

        String[] possibleNames = {"Healing Potion", "Elixir", "Strength Amulet", "Speed Boots", "Mana Crystal"};
        String[] possibleDescriptions = {"Restores health", "Boosts magic", "Increases physical defense", "Enhances movement speed", "Restores mana"};
        int[] possibleValues = {10, 5, 15, 3, 8};
        String[] possibleTypes = {"HP", "Attack", "Physical Defense", "Movement Speed", "Mana"};

        int randomIndex = random.nextInt(possibleNames.length);
        itemNames[itemCount] = possibleNames[randomIndex];
        descriptions[itemCount] = possibleDescriptions[randomIndex];
        values[itemCount] = possibleValues[randomIndex];
        types[itemCount] = possibleTypes[randomIndex];

        System.out.println("You found a " + itemNames[itemCount] + "! " + descriptions[itemCount] + " (Value: +" + values[itemCount] + ")");
        itemCount++;
    }

    public void useItem() {
        Scanner scanner = new Scanner(System.in);
        if (itemCount == 0) {
            System.out.println("Your inventory is empty!");
            return;
        }
        displayInventory();
        System.out.println("Enter the number of the item you want to use:");
        int itemNumber = scanner.nextInt();
        if (itemNumber < 1 || itemNumber > itemCount) {
            System.out.println("Invalid item number! Try again.");
            return;
        }
        int index = itemNumber - 1;

        System.out.println("You used " + itemNames[index] + ". " + descriptions[index]+ " (+" + values[index] + " " + types[index] + ")");
        
        for (int i = index; i < itemCount - 1; i++) {
            itemNames[i] = itemNames[i + 1];
            descriptions[i] = descriptions[i + 1];
            values[i] = values[i + 1];
            types[i] = types[i + 1];
        }
        itemCount--;
    }

    public void displayInventory() {
        if (itemCount == 0) {
            System.out.println("Your inventory is empty!");
            return;
        }
        System.out.println("Inventory:");
        for (int i = 0; i < itemCount; i++) {
            System.out.println((i + 1) + ". " + itemNames[i] + ": " + descriptions[i] + " (Value: +" + values[i] + " " + types[i] + ")");
        }
    }
}
