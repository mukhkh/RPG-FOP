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
import static rpgfop.game.PlayerATK;
import static rpgfop.game.PlayerCOIN;
import static rpgfop.game.PlayerHP;
import static rpgfop.game.mainTextArea;
import static rpgfop.game.playeratk;
import static rpgfop.game.playercoin;
import static rpgfop.game.playerhp;

public class Monster {
    //floor 1
    public static class goblin {
        private int hp;
        private int atk;
        private char name;
        private int drop;

        public goblin(int hp, int atk, int drop) {
            this.hp = hp;
            this.atk = atk;
            this.name = 'g';
            this.drop = drop;
        }

        public void attack() {
            Random chance = new Random();
            int dodge = chance.nextInt(4);
            if (isAlive()) {
                switch (dodge) {
                    case 0:
                        hp = hp - playeratk;
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The goblin lost some HP");
                        break;
                    case 1:
                        hp = hp - playeratk;
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The goblin lost some HP");
                        break;
                    case 2:
                        hp = hp - playeratk;
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The goblin lost some HP");
                        break;
                    case 3:
                        playerhp = playerhp - atk;
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The goblin dodge and attack you.\n"
                                        + "you lost some HP");
                        break;
                }
                HeroDeadOrNot();
            } 
            //if goblin is dead
            if(hp<=0) {
                mainTextArea.setText("The goblin has been defeated and dropped some coins!");
                playercoin+=drop;
                game.continueGameScreen();
            }
            PlayerHP.setText(""+playerhp);
            PlayerCOIN.setText(""+playercoin);
        }

        public int getDrop() {
            return drop;
        }

        public int getAtk() {
            return atk;
        }

        public boolean isAlive() {
            return hp > 0;
        }

    }

    public static class slime {

        private int hp;
        private int atk;
        private char name;
        private int drop;

        public slime(int hp, int atk, int drop) {
            this.hp = hp;
            this.atk = atk;
            this.name = 's';
            this.drop = drop;
        }

        public void attack() {
            Random chance = new Random();
            int counter = chance.nextInt(2);
            if (isAlive()) {
                switch (counter) {
                    case 0:
                        hp = hp - playeratk;
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The slime lost some HP");
                        break;
                    case 1:
                        playerhp = playerhp - atk;
                        hp = hp - playeratk;
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The slime recieve damage and counter your attack \n"
                                + "you lost some HP");
                        break;
                }
                HeroDeadOrNot();
            }
            if(hp<=0){
                mainTextArea.setText("The slime has been defeated and dropped some coins!");
                playercoin+=drop;
                game.continueGameScreen();
            }
            PlayerHP.setText(""+playerhp);
            PlayerCOIN.setText(""+playercoin);
        }

        public int getDrop() {
            return this.drop;
        }

        public int getAtk() {
            return this.atk;
        }

        public boolean isAlive() {
            return hp > 0;
        }
    }

    public static class tarantula {

        private int hp;
        private int atk;
        private char name;
        private int drop;

        public tarantula(int hp, int atk, int drop) {
            this.hp = hp;
            this.atk = atk;
            this.name = 't';
            this.drop = drop;
        }

        public void attack() {
            Random chance = new Random();
            int counter = chance.nextInt(3);
            if (isAlive()) {
                switch (counter) {
                    case 0:
                        hp = hp - playeratk;
                        playerhp -= (int) (playeratk / 4);//hp player also decrease
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                        + "The tarantula lost some HP\n"
                            + "and you inflicted damage to yourself. Ouch!");
                    case 1:
                        hp = hp - playeratk;
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                            + "The tarantula lost some HP");
                    case 2:
                        playerhp -= atk;
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                            + "The tarantula dodge your attack\n"
                                + "It fight back and you lost some HP");
                }
            } 
            HeroDeadOrNot();
            if(hp<=0){
                mainTextArea.setText("The tarantula has been defeated and you finish the game!\n"
                        + "Thank you for playing");
                playercoin+=drop;
                game.gameEnd();
            }
            PlayerHP.setText(""+playerhp);
            PlayerCOIN.setText(""+playercoin);
        }

        public int getDrop() {
            return this.drop;
        }

        public int getAtk() {
            return this.atk;
        }

        public boolean isAlive() {
            return hp > 0;
        }
    }

    //floor 2
    public static class lizard {

        private int hp;
        private int atk;
        private char name;
        private int drop;
        //(55, 6, 9)
        public lizard(int hp, int atk, int drop) {
            this.hp = hp;
            this.atk = atk;
            this.name = 'l';
            this.drop = drop;
        }

        public void attack() {
            Random chance = new Random();
            int counter = chance.nextInt(3);
            if (isAlive()) {
                switch (counter) {
                    case 0:
                        hp = hp - playeratk; //received attack
                        hp = hp + 1; //ability (regenerate 1 hp)
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The lizard lose some HP, and regenerate 1 HP. \nUnbelievable");
                        break;
                    case 1:
                        playerhp = playerhp - atk;
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The lizard dodge, and you recieve some damage. \nOuch");
                        break;
                    case 2:
                        hp = hp - playeratk; //received attack
                        hp = hp + 1; //ability (regenerate 1 hp)
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The lizard lose some HP, and regenerate 1 HP. \nUnbelievable");
                        break;
                }
                HeroDeadOrNot();
            } if(hp<=0){
                mainTextArea.setText("The lizard has been defeated and dropped some coins!");
                playercoin+=drop;
                game.continueGameScreen();
            }
            //update the display
            PlayerHP.setText(""+playerhp);
            PlayerCOIN.setText(""+playercoin);
        }

        public int getDrop() {
            return this.drop;
        }

        public int getAtk() {
            return this.atk;
        }

        public boolean isAlive() {
            return hp > 0;
        }
    }

    public static class basilisk {

        private int hp;
        private int atk;
        private char name;
        private int drop;
        //(75, 8, 12)
        public basilisk(int hp, int atk, int drop) {
            this.hp = hp;
            this.atk = atk;
            this.name = 'b';
            this.drop = drop;
        }

        public void attack() {

            Random chance = new Random();
            int counter = chance.nextInt(3);
            if (isAlive()) {
                switch (counter) {
                    case 0:
                        hp = (int) (hp - (0.95 * playeratk));//take 5% less dmg
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The basilsik lost some HP. But its skin is tough,\n"
                                + "you deal less damage than you supposed to do");
                        break;
                    case 1:
                        playerhp = playerhp - atk;
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The basilisk dodge and attack you\n"
                                + "you lost some HP");
                        break;
                    case 2:
                        hp = (int) (hp - (0.95 * playeratk));//take 5% less dmg
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The basilsik lost some HP. But its hard skin is tough,\n"
                                + "you deal less damage than you supposed to do");
                        break;
                }
                HeroDeadOrNot();
            } if(hp<=0){
                mainTextArea.setText("The basilisk has been defeated and dropped some coins!");
                playercoin+=drop;
                game.continueGameScreen();
            }
            PlayerHP.setText(""+playerhp);
            PlayerCOIN.setText(""+playercoin);
        }

        public int getDrop() {
            return this.drop;
        }

        public int getAtk() {
            return this.atk;
        }

        public boolean isAlive() {
            return hp > 0;
        }
    }

    public static class giant {

        private int hp;
        private int atk;
        private char name;
        private int drop;

        public giant(int hp, int atk, int drop) {
            this.hp = hp;
            this.atk = atk;
            this.name = 'g';
            this.drop = drop;
        }

        public void attack() {
            Random chance = new Random();
            int counter = chance.nextInt(4);
            if (isAlive()) {
                switch (counter) {
                    case 0:
                        hp = (int) (hp - (0.85 * playeratk));//take 15% less dmg
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The giant lost some HP. This guy is tough\n"
                                + "you deal less damage than you supposed to do");
                        break;
                    case 1:
                        playerhp = playerhp - atk;
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The giant block you attack and punch back.\n"
                                + "you lost some HP");
                        break;
                    case 2:
                        playeratk = (int) (playeratk * 0.9);
                        hp = hp + 3;
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The giant let out a loud screech and heal itself \n"
                                + "Your morale is down, SO IS YOUR ATTACK");
                    case 4:
                        hp = (int) (hp - (0.85 * playeratk));//take 15% less dmg
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The giant lost some HP. This guy is tough\n"
                                + "you deal less damage than you supposed to do");
                        break;
                }
                HeroDeadOrNot();
            } if(hp<=0){
                mainTextArea.setText("The giant has been defeated and you finish the game!\n"
                        + "Thank you for playing");
                playercoin+=drop;
                game.gameEnd();
            }
            PlayerHP.setText(""+playerhp);
            PlayerCOIN.setText(""+playercoin);
        }

        public int getDrop() {
            return this.drop;
        }

        public int getAtk() {
            return this.atk;
        }

        public boolean isAlive() {
            return hp > 0;
        }
    }

    //floor 3
    public static class zombie {

        private int hp;
        private int atk;
        private char name;
        private int drop;
        private int lives;
        //(60, 9, 5);
        public zombie(int hp, int atk, int drop) {
            this.hp = hp;
            this.atk = atk;
            this.name = 'z';
            this.drop = drop;
            lives = 2;
        }

        public void attack() {
            
            
                Random chance = new Random();
                int counter = chance.nextInt(3);
                if (isAlive()) {
                    switch (counter) {
                        case 0:
                            hp = hp - playeratk;//loop for the second time plssss
                            playerhp -= atk;
                            mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The zombie lost some HP \n"
                                + "you lost some HP too");
                            break;
                        case 1:
                            hp = hp - playeratk;//loop for the second time plssss
                            mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The zombie lost some HP and stand still without\n"
                                    + "attacking back \n");
                            break;
                        case 2:
                            hp = hp - playeratk;//loop for the second time plssss
                            mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The zombie lost some HP and stand still without\n"
                                    + "attacking back \n");
                            break;


                    }
                    HeroDeadOrNot();
                } 
                if(hp<=0){
                    
                    lives--;
                    //revive back
                    this.hp = 60;
                    mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                            + "Oh wait. The zombie is still Alive? \n"
                            + "I mean dead where's ma coin?");
                    HeroDeadOrNot();
                }
                
            if (lives == 0) {
                mainTextArea.setText("The zombie finally dead for sure. \n"
                        + "It dropped some coins for you");
                playercoin+=drop;
                game.continueGameScreen();
                        HeroDeadOrNot();
            }
            PlayerHP.setText(""+playerhp);
            PlayerCOIN.setText(""+playercoin);
        }

        public void attack2() {
            hp = hp - playeratk;
        }

        public int getDrop() {
            return this.drop;
        }

        public int getAtk() {
            return this.atk;
        }

        public boolean isAlive() {
            return hp > 0;
        }
    }

    public static class witch {

        /*Witches. Known for their prowess in wicked witchcraft and potion making. Also known for their heartlessness and cruelty. When witches encounter enemies, they will throw 
        venomous potions at precision towards their target to inflict damage over time. Though not deadly, this continuous damage will always make their enemies be on low health
        and make them easier to be killed. Besides that, witches can also regenerate health over time by consuming their specially made healing potion. Hence, it is advised for 
        you to advance with caution and plan your strategy thoroughly before taking actions to ensure the most efficient use of your resources.
         */
        private int hp;
        private int atk;
        private char name;
        private int drop;
        //(105, 15, 20)
        public witch(int hp, int atk, int drop) {
            this.hp = hp;
            this.atk = atk;
            this.name = 'w';
            this.drop = drop;
        }

        public void attack() {
            Random chance = new Random();
            int counter = chance.nextInt(3);
            if (isAlive()) {
                switch (counter) {
                    case 0:
                        hp = hp - playeratk;
                        hp = hp + 2;
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The witch lost some HP drink a potion \n"
                                + "She heals herself by 2 HP");
                        break;
                    case 1:
                        playerhp = playerhp - atk;
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The witch throw a rock at you \n"
                                + "You lost some HP. Rocks hurts");
                        break;
                    case 2:
                        playerhp = playerhp - 10;//poison
                        hp = hp - playeratk;
                        playeratk = playeratk - 10;//poison
                        if(playeratk<5){
                            playeratk=5;
                        }
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                                + "The witch throw a poison at you when you strike her\n"
                                + "You lost some HP. And ATK too. Ouch!");
                        break;
                }
                HeroDeadOrNot();
            } if(hp<=0){
                mainTextArea.setText("The witch has been defeated and dropped some coins!");
                playercoin+=drop;
                game.continueGameScreen();
            }
            PlayerHP.setText(""+playerhp);
            PlayerATK.setText(""+playeratk);
            PlayerCOIN.setText(""+playercoin);
        }

        public int getDrop() {
            return this.drop;
        }

        public int getAtk() {
            return this.atk;
        }

        public boolean isAlive() {
            return hp > 0;
        }
    }

    public static class dragon {

        /* The Dragon is the mythical creature that has taken over the Kingdom of *******. Its immense strength and powerful abilities has striked fear among even the bravest
        of warriors. Not only the fact that its sheer strength has never been overcome from any battle records, its ability to inflict permanent burning on enemies and its
        steel-thick scaled skin make its enemies struggle even more to defeat it. Hence, it is advised for you to advance with caution and plan your strategy thoroughly before 
        taking actions to ensure the most efficient use of your resources.
         */
        private int hp;
        private int atk;
        private char name;
        //(275, 70)
        public dragon(int hp, int atk) {
            this.hp = hp;
            this.atk = atk;
            this.name = 'd';
        }

        public void attack() {
            Random chance = new Random();
            int negligible = chance.nextInt(5);
            if (isAlive()) {
                switch (negligible) {
                    case 0:
                        hp = hp - 0;
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                            + "Your attack did nothing \n"
                            + "Oh no man");
                        break;
                    case 1:
                        hp = (int) (hp - (0.75 * playeratk));
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                            + "You strike the dragon on its head \n"
                            + "It lost some HP.");
                        break;
                    case 2:
                        playerhp = playerhp - 5;//burning
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                            + "The dragon use flamethrower \n"
                            + "You cannot appraoch it and lost some HP");
                        break;
                    case 3:
                        playerhp = playerhp - 10;//burning
                        hp = (int) (hp - (0.75 * playeratk));
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                            + "The dragon use flamethrower \n"
                            + "You appraoch it even thou it hurts\n"
                                + "You manage to deal some damage");
                        break;
                    case 4:
                        playerhp -= atk;
                        mainTextArea.setText("HP:"+hp+"ATK:"+atk+"\n"
                            + "The dragon use his claw to beat you \n"
                            + "oh ma gad the damage!");
                }
                HeroDeadOrNot();
            } if(hp<=0){ // this hp is hp of a dragon inside dragon class
                mainTextArea.setText("The dragon has been defeated and you finish the game!\n"
                        + "Thank you for playing");
                game.gameEnd();
            }
            PlayerHP.setText(""+playerhp);
        }

        public int getAtk() {
            return this.atk;
        }

        public boolean isAlive() {
            return hp > 0;
        }
    }
    
    public static void HeroDeadOrNot(){
        if(playerhp <= 0){
            //player lose
            mainTextArea.setText("You're dead. Thank you for playing the game.\n"
                    + "Nice try Hero");
            game.gameEnd();
        }
    }
}