/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpgfop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Stories {
    
    public static void main(String[] args) {
//        intro();
//        try{
//        PrintWriter introduction = new PrintWriter(new FileOutputStream("introduction.txt"));
//                
//        introduction.close();
//            System.out.println("File created");
//        }catch(IOException e){
//            System.out.println("File creation failed");
//        }
    }
    public static String introPara1(){
        StringBuilder contentBuilder = new StringBuilder();
        try{
        Scanner introduction = new Scanner(new FileInputStream ("introduction.txt"));
        while (introduction.hasNextLine()) {
            String line = introduction.nextLine();
            contentBuilder.append(line).append(System.lineSeparator()); // Append line and newline
        }
        introduction.close();
        }catch(FileNotFoundException e){
            System.out.println("Failed to read the file");    
        }
        return contentBuilder.toString(); // Return the complete content as a String
    }
    
    public static String introPara2(){
        StringBuilder contentBuilder = new StringBuilder();
        try{
        Scanner introduction = new Scanner(new FileInputStream ("introduction2.txt"));
        while (introduction.hasNextLine()) {
            String line = introduction.nextLine();
            contentBuilder.append(line).append(System.lineSeparator()); // Append line and newline
        }
        introduction.close();
        }catch(FileNotFoundException e){
            System.out.println("Failed to read the file");    
        }
        return contentBuilder.toString(); // Return the complete content as a String
    }
    public static String introPara3(){
        StringBuilder contentBuilder = new StringBuilder();
        try{
        Scanner introduction = new Scanner(new FileInputStream ("introduction3.txt"));
        while (introduction.hasNextLine()) {
            String line = introduction.nextLine();
            contentBuilder.append(line).append(System.lineSeparator()); // Append line and newline
        }
        introduction.close();
        }catch(FileNotFoundException e){
            System.out.println("Failed to read the file");    
        }
        return contentBuilder.toString(); // Return the complete content as a String
    }
    public static String introPara4(){
        StringBuilder contentBuilder = new StringBuilder();
        try{
        Scanner introduction = new Scanner(new FileInputStream ("introduction4.txt"));
        while (introduction.hasNextLine()) {
            String line = introduction.nextLine();
            contentBuilder.append(line).append(System.lineSeparator()); // Append line and newline
        }
        introduction.close();
        }catch(FileNotFoundException e){
            System.out.println("Failed to read the file");    
        }
        return contentBuilder.toString(); // Return the complete content as a String
    }
//    public static test(){
//    
//    }
}
