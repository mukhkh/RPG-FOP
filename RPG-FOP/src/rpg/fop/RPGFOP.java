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
public class RPGFOP {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        action action = new action();
        battle battle = new battle();
        character character = new character();
        //player input name        
        String player = character.name();

        while(true){
        battle.fight(character.playerstat(), character.goblin(), player, "goblin");
        int end = character.end();
        if(end == 0)
            break;
        }
        System.out.println("GAME OVER!");
    }
}
