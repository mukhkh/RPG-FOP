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
import java.util.ArrayList;
public class RPGFOP {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        action action = new action();
        battle battle = new battle();
        story story = new story();
        character character = new character();
        //player input name        
        String player = character.name();
        
        //print story
        story.introduction();
        
        int floor=1;
        boolean printstory = true;
        while(floor<=3){
            
            //print floor 1 story
            if(printstory && floor==1){
                story.floor1();
                printstory=false;
            }
            //print floor 2 story
            if(printstory && floor==2){
                story.floor2();
                printstory=false;
            }
            //print floor 3 story
            if(printstory && floor==3){
                story.floor3();
                printstory=false;
            }
            
            ArrayList<String> inventory = new ArrayList<>();
            int map = random.nextInt(00001,99999);
            while(true){
                boolean raise = false;
                do{
                System.out.println("***********************************************");
                System.out.println("Choose your move adventurer :");
                System.out.println("1. move");
                System.out.println("2. inventory");
                System.out.println("3. give up"); //never gonna give you up
                System.out.println("************************************************");

                int choice = scanner.nextInt();
                int move=0;
                    if(choice >=1 && choice<=3){
                        switch(choice){
                            case 1 -> {
                                move=action.move();
                            }
                            case 2 -> {
                                action.printList(inventory);
                            }
                            case 3 ->{
                                System.out.print("hmm");
                            }
                        }
                        if(choice == 1){
                        switch(move){
                            //north
                            case 1 ->{
                                if(map%2 == 0){ //even
                                
                                }else{ //odd
                                
                                }
                            }
                            //east
                            case 2 ->{
                                if(map%2 == 0){ //even
                                
                                }else{ //odd
                                
                                }
                            }
                            //south
                            case 3 ->{
                                if(map%2 == 0){ //even
                                
                                }else{ //odd
                                
                                }
                            }
                            //west
                            case 4 ->{
                                if(map%2 == 0){ //even
                                
                                }else{ //odd
                                
                                }
                            }
                        }
                        }
                        //choosing inv
                        if(choice == 2){
                            int inv;
                            do{
                            System.out.println("What do you want to do adventurer?");
                            System.out.println("1. Use item");
                            System.out.println("2. Continue the adventure");
                            inv = scanner.nextInt();
                            
                            if(inv == 1){
                            }else if(inv == 2){
                            }else{
                                System.out.println("please choose carefully.");
                            }
                            }while(inv != 2);    
                        }
                    }else{
                        System.out.println("Excuse me player,\n"
                                + "I dont quite understand your choice there");
                    }
                }while(raise);
            }
        }    
    }
}

