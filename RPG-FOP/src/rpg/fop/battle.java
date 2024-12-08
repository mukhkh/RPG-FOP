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
public class battle {
    Scanner scanner = new Scanner(System.in);
    public void fight(int[] a, int[] b, String c, String d){
        System.out.println("The battle between "+c+" and "+d+ " just start.");
        System.out.println("Choose your action: ");
        System.out.println("1. Attack");
        System.out.println("2.Flee");
        int option=scanner.nextInt();
        if(option == 1){
        action action = new action();
        int[] result = new int[3];
        result = action.attack(a, b,d);
        }
        if(option == 2){
//        action.flee();
        }
    }
}
