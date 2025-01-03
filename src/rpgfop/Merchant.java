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
import static rpgfop.game.mainTextArea;
public class Merchant {
        
    public static int coins = 0 ;
    static int HP; 
    static int HP_price;
    static int Attack; 
    static int Attack_price;
    static int Magic;
    static int Magic_price;
    static int[] attributes;
    static int[] prices;
    static String[] items;
    
    public static void Items(){
        
        items = new String[] {"Healing Potion", "Strength Amulet", "Elixir"};
        String[] item_description = {"Restore HP", "Increase Attack", "Boost Magic"};
        attributes = new int[] {getHP(), getAttack(), getMagic()};
        prices = new int[] {getHP_price(), getAttack_price(), getMagic_price()};
        
        System.out.println("Items available : ");
        for(int i = 0; i < items.length; i++){
            
            //format text
            mainTextArea.setText(String.format("%d. %-15s : %s by %d (cost: %d coins)\n"
                    , (i+1), items[i], item_description[i], attributes[i], prices[i]));
           System.out.printf("%d. %-15s : %s by %d (cost: %d coins)\n"
                   , (i+1), items[i], item_description[i], attributes[i], prices[i]);
        }
    }
    
    
    public void Buy_Process(){
        
        Scanner sc = new Scanner(System.in);
        int opt;
        
        Items();
        System.out.println();
        System.out.println("Your coins : " + coins); //or display coins in main method 
        System.out.print("Choose item to buy: ");                        
        opt = sc.nextInt();
        
        switch(opt){
            case 1 :
                if(coins < this.prices[0]){
                    System.out.println("Insufficient coins!");
                    break;
                }
                
                System.out.println("You buy " + this.items[0]);
                coins -= this.prices[0];
                System.out.println("Your balances : " + coins + " coins");
                //inventory array ++;
                //update inventory
                break;
            case 2 :
                if(coins < this.prices[1]){
                    System.out.println("Insufficient coins!");
                    break;
                }
                
                System.out.println("You buy " + this.items[1]);
                coins -= this.prices[1];
                System.out.println("Your balances : " + coins + " coins");
                break;
            case 3 :
                if(coins < this.prices[2]){
                    System.out.println("Insufficient coins!");
                    break;
                }
                
                System.out.println("You buy " + this.items[2]);
                coins -= this.prices[2];
                System.out.println("Your balances : " + coins + " coins");
                break;
            default :
                System.out.println("Invalid input.");                
        }
    }
    
    //determine attributes according to current floor stage
    public void Attributes(int floor){       
                
        switch(floor){
            case 1 :
                HP = 15; HP_price = 10;
                Attack = 20; Attack_price = 15;
                Magic = 10; Magic_price = 5;
                break;
            case 2 :
                HP = 25; HP_price = 15;
                Attack = 40; Attack_price = 30;
                Magic = 20; Magic_price = 10;
                break;
            default :
                HP = 50; HP_price = 25;
                Attack = 70; Attack_price = 50;
                Magic = 35; Magic_price = 20;
                break;                
        }
    }
    
    public static int getHP(){
        return HP;
    }
    
    public static int getAttack(){
        return Attack;
    }
    
    public static int getMagic(){
        return Magic;
    }
    
    public static int getHP_price(){
        return HP_price;
    }
    
    public static int getAttack_price(){
        return Attack_price;
    }
    
    public static int getMagic_price(){
        return Magic_price;
    }
}

