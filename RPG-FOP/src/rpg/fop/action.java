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
    
    public int[] attack(Object[][] player, Object[][] mon){
        int[] result = new int[3];
        
        System.out.println("You attack the "+mon[0][0]+" and inflicted "+player[1][1]);
        int monHP = (Integer)mon[1][0];
        monHP -= (Integer)player[1][1];
        if(monHP <=0){
            System.out.println("You beat the monster!");
            result[0] = (Integer)mon[1][1];
            result[1] = (Integer)player[1][1];
            result[2] = 1; //win
        }else{
            System.out.println("The monster inflicted "+mon[1][1]+" damage to you");
            result[0] = (Integer)mon[1][1];
            result[1] = (Integer)player[1][1];
            result[2] = 0; //not yet win
        }
        // result = {monATK ,playerATK, win/lose}
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
        boolean loop = true;
        do{
            switch(a){
                case 1 -> System.out.println("You choose to move in the north direction.");
                case 2 -> System.out.println("You choose to move in the east direction.");
                case 3 -> System.out.println("You choose to move in the south direction.");
                case 4 -> System.out.println("You choose to move in the west direction.");
                default -> System.out.println("Please choose your direction carefully.");
            }
            if(a>0 && a<5)
                loop = false;
        }while(loop);
        return a;
    }
    
    //printing inventry function
    public void printList(ArrayList<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }
    
}


