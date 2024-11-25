/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpg.fop;

/**
 *
 * @author USER
 */
public class action {
    public int[] attack(int a[], int b[]){
        while(true){
            a[0]=a[0]-b[1];
            b[0]=b[0]-a[1];
            if(b[0]<=0){
                System.out.println("You beat the monster!");
                break;
            }
            if(b[0]<=0){
                    System.out.println("You're dead...");
                    break;
            }
        }
        return a;
    }

    public void flee(){
        System.out.println("Instead of fighting, you choose to abandon the battlefield");
    }
}

