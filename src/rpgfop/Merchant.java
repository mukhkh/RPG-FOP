/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpgfop;

/**
 *
 * @author USER
 */
import java.util.Scanner;
import static rpgfop.game.floor;
import static rpgfop.game.mainTextArea;
import static rpgfop.game.opt;
import static rpgfop.game.playeratk;
import static rpgfop.game.playercoin;
import static rpgfop.game.playerhp;
public class Merchant {
        
    public static int coins = 0 ;
    static int HP; 
    static int HP_price;
    static int Attack; 
    static int Attack_price;
    static int[] attributes;
    static int[] prices;
    static String[] items;
    static String[] item;
    
    public static void Items(){
        
        Attributes();
        items = new String[] {"Health Potion", "Strength Amulet"};
        String[] item_description = {"Restore HP", "Increase Attack"};
        attributes = new int[] {getHP(), getAttack()};
        prices = new int[] {getHP_price(), getAttack_price()};
        item = new String[items.length];
        
        System.out.println("Items available : ");
        for(int i = 0; i < items.length; i++){
            //format text
            item[i] = (
                    String.format("%d.%-15s :%s by %d(cost: %d coins)"
                    , (i+1), items[i], item_description[i], attributes[i], prices[i]));
            System.out.printf("%d. %-15s : %s by %d (cost: %d coins)\n"
                   , (i+1), items[i], item_description[i], attributes[i], prices[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(String s : item ){
            sb.append(s).append("\n");
        }
        
        mainTextArea.setText("Items available : \n"
                +sb.toString());
    }
    
    
    public static void Buy_Process(){
        switch(opt){
            case 1 :
                if(playercoin < Merchant.prices[0]){
                    mainTextArea.setText("Insufficient coins!\n"
                            + "You were kicked by the merchant"); 
                    System.out.println("Insufficient coins!");
                    break;
                }
                
                mainTextArea.setText("You buy " + Merchant.items[0]);
                System.out.println("You buy " + Merchant.items[0]);
                playercoin -= Merchant.prices[0];
                playerhp += HP;
                System.out.println("Your balances : " + coins + " coins");
                //inventory array ++;
                //update inventory
                break;
            case 2 :
                if(coins < Merchant.prices[1]){
                    System.out.println("Insufficient coins!");
                    break;
                }
                
                System.out.println("You buy " + Merchant.items[1]);
                coins -= Merchant.prices[1];
                System.out.println("Your balances : " + coins + " coins");
                playeratk += Attack;
                break;
            default :
                System.out.println("Invalid input.");                
        }
    }
    
    //determine attributes according to current floor stage
    public static void Attributes(){       
                
        switch(floor){
            case 1 :
                HP = 15; HP_price = 10;
                Attack = 20; Attack_price = 15;
                break;
            case 2 :
                HP = 25; HP_price = 15;
                Attack = 40; Attack_price = 30;
                break;
            default :
                HP = 50; HP_price = 25;
                Attack = 70; Attack_price = 50;
                break;                
        }
    }
    
    public static int getHP(){
        return HP;
    }
    
    public static int getAttack(){
        return Attack;
    }
    
    public static int getHP_price(){
        return HP_price;
    }
    
    public static int getAttack_price(){
        return Attack_price;
    }
}

