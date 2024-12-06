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
        
            int map = random.nextInt(00001,99999);
            while(true){
                System.out.println("***********************************************");
                System.out.println("Choose your move adventurer :");
                System.out.println("1. move");
                System.out.println("2. inventory");
                System.out.println("3. give up"); //never gonna give you up
                System.out.println("************************************************");

                int choice = scanner.nextInt();
                int move=0;
                
                while(choice !=1){
                    if(choice >=1 && choice<=3){
                        switch(choice){
                            case 1 -> {
                                move=action.move();
                            }
                            case 2 -> action.inventory();
                            default -> System.out.print("");
                        }        
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
                    }else{
                        System.out.println("Excuse me player,\n"
                                + "I dont quite understand your choice there");
                    }
                }
            }
        }    
    }
}

