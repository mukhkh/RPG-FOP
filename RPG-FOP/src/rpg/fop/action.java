/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpg.fop;

/**
 *
 * @author USER
 */
import java.util.Scanner;
public class action {
    Scanner scanner = new Scanner(System.in);
    
    public int[] attack(int player[], int monster[]){
        int[] result = new int[3];
        //return result[HP yg tertolak, duit yg dapat, 0(mon biasa) 1(boss)]
        return result;
    }

    public void flee(){
        System.out.println("Instead of fighting, you choose to abandon the battlefield");
    }
    
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
    
    public void inventory(){
        
    }
}

