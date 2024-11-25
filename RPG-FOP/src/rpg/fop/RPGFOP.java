/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rpg.fop;

/**
 *
 * @author USER
 */
import java.util.Scanner;
import java.util.Random;
public class RPGFOP {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        action action = new action();
        battle battle = new battle();
        character character = new character();
        //player input name        
        String player = character.name();

        while(true){
        int map = random.nextInt(00001,99999);
            while(true){
                System.out.println("Choose your move :");
                System.out.println("1. move");
                System.out.println("2. item");
                System.out.println("3. give up"); //never gonna give you up
                int choice = scanner.nextInt();
                if(choice >=1 && choice<=3){
                    switch(choice){
                        case 1: //do some fuction
                            break;
                        case 2: //do some function
                            break;
                        case 3: //do some function
                            break;
                    }
                }
                else{
                    System.out.println("Excuse me player,\nI dont quite understand your choice there");
                    continue;
                }
            }
            
        }
    }
}
