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
 
    public int[] fight(Object[][] player , Object[][] monster){
        System.out.println("The battle between "+player[0][0]+" and "+monster[0][0]+ " just start.");
        boolean  victory = true;
        int coinObtained=0, hpLost=0, currentHP=0;
        // result = {monATK ,playerATK, win/lose}
        int[] result = new int[3];
        do{
        System.out.println("---------------------");
            System.out.println("PLAYER :" + player[0][0]);
            System.out.println("HP :" + player[1][0]);
            System.out.println("ATK :" + player[1][1]);
        System.out.println("---------------------");            
            System.out.println("MONSTER :" + monster[0][0]);
            System.out.println("HP :" + monster[1][0]);
            System.out.println("ATK :" + monster[1][1]);
        System.out.println("---------------------");
            System.out.println("Choose your action: ");
            System.out.println("1. Attack");
            System.out.println("2.Flee");
        System.out.println("---------------------");
        int option=scanner.nextInt();
        if(option == 1){
            action action = new action();
            // result = {monATK ,playerATK, win/lose}
            result = action.attack(player, monster);
            hpLost =result[0];
            currentHP = (Integer)player[1][0];
            player[1][0] = currentHP - hpLost;
            
            hpLost =result[1];
            currentHP = (Integer)monster[1][0];
            monster[1][0] = currentHP - hpLost;
        }
        if(option == 2){
//        action.flee();
        }
        if(result[2] == 1){ //if win
            System.out.println("Congratulations, you beat the monster!");
            System.out.println("You obtained "+monster[2][0]+" coins");
            coinObtained = (Integer)monster[2][0];
            victory = false;
        }
        }while(victory);
        
        int[] result2 = new int[2];
        result2[0] = hpLost;
        result2[1] = coinObtained;
        return result2;
    }
}
