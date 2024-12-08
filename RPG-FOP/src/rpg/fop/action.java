/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpg.fop;

/**
 *
 * @author USER
 */
import java.util.ArrayList;
import java.util.Scanner;
public class action {
    Scanner scanner = new Scanner(System.in);
    
    public int[] attack(int player[], int mon[], String monName){
        int[] result = new int[3];
        int damage = player[0]; //player atk
        int mondamage = mon[0]; //mon atk
        int coin = mon[1];
        System.out.println("You attack the "+monName+"and inflicted "+damage);
        if(mon[0] <=0){
            System.out.println("You beat the monster!");
            result[0] = mondamage;
            result[1] = damage;
            result[2] = coin;
        }else{
            System.out.println("The monster inflicted "+mondamage+"to you");
            result[0] = mondamage;
            result[1] = damage;
            result[2] = 0;
        }
        return result;
    }

    public void flee(){
        System.out.println("Instead of fighting, you choose to abandon the battlefield");
    }
    //move direction function
    public int move(){   
        System.out.println("Choose your direction :");
        System.out.println("1. North");
        System.out.println("2. East");
        System.out.println("3. South");
        System.out.println("4. West");
        int a = scanner.nextInt();

        do{
            switch(a){
                case 1 -> System.out.println("You choose to move in the north direction.");
                case 2 -> System.out.println("You choose to move in the east direction.");
                case 3 -> System.out.println("You choose to move in the south direction.");
                case 4 -> System.out.println("You choose to move in the west direction.");
                default -> System.out.println("Please choose your direction carefully.");
            }
        }while(a!=1 || a!=2 || a!=3 || a!=4);
        return a;
    }
    
    //printing inventry function
    public void printList(ArrayList<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }
    
}


