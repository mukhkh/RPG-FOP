/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpgfop;

/**
 *
 * @author USER
 */
import java.util.Random;
import static rpgfop.game.mainTextArea;
import static rpgfop.game.playeratk;
import static rpgfop.game.playercoin;
import static rpgfop.game.playerhp;

public class Monster {
    //floor 1
    public static class goblin{
        private int hp;
        private int atk;
        private char name;
        private int drop;
        public goblin(int hp,int atk,int drop){
            this.hp=hp;
            this.atk=atk;
            this.name='g';
            this.drop=drop;
        }
        Random chance=new Random();
        int dodge=chance.nextInt(4);
        public void attack(){
            switch(dodge){
                case 0:
                    hp=hp-playeratk;
                    mainTextArea.setText("The goblin lost - HP");
                    break;
                case 1:
                    hp=hp-playeratk;
                    break;
                case 2:
                    hp=hp-playeratk;
                    break;
            }
        }
        public int getDrop(){
            return drop;
        }
        public int getAtk(){
            return atk;
        }
    }
    public class slime{
        private int hp;
        private int atk;
        private char name;
        private int drop;
        public slime(int hp,int atk,int drop){
            this.hp=hp;
            this.atk=atk;
            this.name='s';
            this.drop=drop;
        }
        public void attack(){
            hp=hp-playeratk;
        }
        public int getDrop(){
            return this.drop;
        }
        public int getAtk(){
            return this.atk;
        }
    }
    public class tarantula{
        private int hp;
        private int atk;
        private char name;
        private int drop;
        public tarantula(int hp,int atk,int drop){
            this.hp=hp;
            this.atk=atk;
            this.name='t';
            this.drop=drop;
        }
        Random chance=new Random();
        int counter=chance.nextInt(4);
        public void attack(){
            
            if(counter==0){
                hp=hp-playeratk;
                playerhp-=(int)(playeratk/4);//hp player also decrease
            }
            else{
                hp=hp-playeratk;
            }
        }
        public int getDrop(){
            return this.drop;
        }
        public int getAtk(){
            return this.atk;
        }
    }
    //floor 2
    public class lizard{
        private int hp;
        private int atk;
        private char name;
        private int drop;
        public lizard(int hp, int atk, int drop){
            this.hp=hp;
            this.atk=atk;
            this.name='l';
            this.drop=drop;
        }
        public void attack(){
            hp=hp-playeratk; //received attack
            hp=hp+1; //ability (regenerate 1 hp)
        }
        public int getDrop(){
            return this.drop;
        }
        public int getAtk(){
            return this.atk;
        }
    }
    public class basilisk{
        private int hp;
        private int atk;
        private char name;
        private int drop;
        public basilisk(int hp, int atk,int drop){
            this.hp=hp;
            this.atk=atk;
            this.name='b';
            this.drop=drop;
        }
        public void attack(){
            hp=(int)(hp-(0.95*playeratk));//take 5% less dmg
        }
        public int getDrop(){
            return this.drop;
        }
        public int getAtk(){
            return this.atk;
        }
    }
    public class giant{
        private int hp;
        private int atk;
        private char name;
        private int drop;
        public giant(int hp, int atk, int drop){
            this.hp=hp;
            this.atk=atk;
            this.name='g';
            this.drop=drop;
        }
        public void attack(){
            hp=(int)(hp-(0.85*playeratk));//take 15% less dmg
        }
        public int getDrop(){
            return this.drop;
        }
        public int getAtk(){
            return this.atk;
        }
    }
    //floor 3
    public class zombie{
        private int hp;
        private int atk;
        private char name;
        private int drop;
        public zombie(int hp, int atk, int drop){
            this.hp=hp;
            this.atk=atk;
            this.name='z';
            this.drop=drop;
        }
        public void attack(){
            hp=hp-playeratk;//loop for the second time plssss
        }
        public void attack2(){
            hp=hp-playeratk;
        }
        public int getDrop(){
            return this.drop;
        }
        public int getAtk(){
            return this.atk;
        }
    }
    public class witch{
        /*Witches. Known for their prowess in wicked witchcraft and potion making. Also known for their heartlessness and cruelty. When witches encounter enemies, they will throw 
        venomous potions at precision towards their target to inflict damage over time. Though not deadly, this continuous damage will always make their enemies be on low health
        and make them easier to be killed. Besides that, witches can also regenerate health over time by consuming their specially made healing potion. Hence, it is advised for 
        you to advance with caution and plan your strategy thoroughly before taking actions to ensure the most efficient use of your resources.
        */
        private int hp;
        private int atk;
        private char name;
        private int drop;
        public witch(int hp,int atk,int drop){
            this.hp=hp;
            this.atk=atk;
            this.name='w';
            this.drop=drop;
        }
        public void attack(){
            hp=hp-playeratk;
            hp=hp+2;
        }
        public int getDrop(){
            return this.drop;
        }
        public int getAtk(){
            return this.atk;
        }
    }
    public class dragon{
        /* The Dragon is the mythical creature that has taken over the Kingdom of *******. Its immense strength and powerful abilities has striked fear among even the bravest
        of warriors. Not only the fact that its sheer strength has never been overcome from any battle records, its ability to inflict permanent burning on enemies and its
        steel-thick scaled skin make its enemies struggle even more to defeat it. Hence, it is advised for you to advance with caution and plan your strategy thoroughly before 
        taking actions to ensure the most efficient use of your resources.
        */
        private int hp;
        private int atk;
        private char name;
        public dragon(int hp,int atk){
            this.hp=hp;
            this.atk=atk;
            this.name='d';
        }
        Random chance=new Random();
        int negligible=chance.nextInt(4);
        public void attack(){
            if(negligible==0){
                hp=hp-0;
            }
            else{
                hp=(int)(hp-(0.75*playeratk));
            }
        }
        public int getAtk(){
            return this.atk;
        }
    }
    
    public void encounter(){
        int floor =1;
        
    }
}