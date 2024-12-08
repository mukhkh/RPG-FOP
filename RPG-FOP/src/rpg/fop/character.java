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
public class character {
    public String name(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("**************************************************");
        System.out.print("Please enter your username :");
        String username=scanner.next();
        System.out.println("**************************************************");
        return username;
    }
    public int[] playerstat(){
    int[] a = {30,5};
    return a;
    }
    
    public int[] goblin(){
        int[] goblin = {6,2};
        return goblin;
    }
   public int end(){
       int[] player = playerstat();
       if(player[0]==0)
            return 0;
       else
           return 1;
   }
   public static void pikachu(){
       Object[][] pikachu = new Object[4][];
       pikachu[0][0] = "Pikachu";
       pikachu[1][0] = 100; //HP
       pikachu[1][1] = 100; //ATK
       pikachu[2][0] = 100; //coins
       pikachu[3][9] = true;         
   }
}
//public object[] goblin(){
//object[] goblin = {{MON_NAME},
//                   {HP,ATK},
//                   {EXP OBTAINED,MONEY OBTAINED}}
//return goblin;
//}
