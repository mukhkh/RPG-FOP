/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpgfop;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField; //for input username
import static rpgfop.Inv.displayInventory;
import static rpgfop.Inv.findItem;
import static rpgfop.Merchant.Buy_Process;
import static rpgfop.Merchant.Items;
import rpgfop.Monster.goblin;
import rpgfop.Monster.slime;
import rpgfop.Monster.tarantula;
import rpgfop.Monster.lizard;
import rpgfop.Monster.basilisk;
import rpgfop.Monster.giant;
import rpgfop.Monster.zombie;
import rpgfop.Monster.witch;
import rpgfop.Monster.dragon;

/**
 *
 * @author USER
 */
public class game {
    
    JFrame menu;
    Container con; //function to add button, title etc
    JPanel titlenamepanel, startbuttonpanel, maintextPanel ,choicePanel, difficulty;
    JPanel playerstats, leaderBoardPanel, returnPanel;
    JPanel storyPanel, nextStoryButtonPanel;
    JTextArea storyboard, leaderBoardArea;
    static JTextArea mainTextArea;
    JPanel usernameButton ,inputUsername, instruction;
    static JLabel titlename, HPPlayerDisplay, ATKPlayerDisplay, PlayerHP, PlayerATK, COINPlayerDisplay, PlayerCOIN, MANAPlayerDisplay, PlayerMANA;
    Font Titlefont = new Font("Algerian ", Font.PLAIN, 45);
    Font normalFont = new Font("Arabic Typesetting", Font.PLAIN, 25);
    Font storyFont = new Font("Monospaced", Font.PLAIN, 15);
    JButton startButton, nextButtonStory ,R;
    JButton level1,level2,level3;
    static JTextField input;
    static JButton choice1, choice2, choice3, choice4, choice5;
    
    //button function connecter
    chooseDifficultyHandler cdHandler  = new chooseDifficultyHandler(); 
    titleScreenHandler tsHandler = new titleScreenHandler();
    titleScreenHandler1 ts1Handler = new titleScreenHandler1();
    titleScreenHandler2 ts2Handler = new titleScreenHandler2();
    titleScreenHandler3 ts3Handler = new titleScreenHandler3();
    usernameScreenHandler usHandler = new usernameScreenHandler();
    leaderboardHandler ldHandler = new leaderboardHandler();
    sambungstory ssHandler = new sambungstory();
    sambungstory2 ss2Handler = new sambungstory2();
    sambungstory3 ss3Handler = new sambungstory3();
    createGame cgHandler = new createGame();
    static back backHandler = new back();
    static buy buyHandler = new buy();
    static buy1 buy1Handler = new buy1();
    static buy2 buy2Handler = new buy2();
    static fightMon fightMonHandler = new fightMon();
    static fightBoss fbHandler = new fightBoss();
    
    //object for action listener
    static toNorth NmoveHandler = new toNorth();
    static toEast EmoveHandler = new toEast();
    static toWest WmoveHandler = new toWest();
    static toSouth SmoveHandler = new toSouth();
    static toInventory tiHandler = new toInventory();
    
    //object of mosnter class
    static goblin goblin;
    static slime slime;
    static tarantula tarantula;
    static lizard lizard;
    static basilisk basilisk;
    static giant giant;
    static zombie zombie;
    static witch witch;
    static dragon dragon;
    
    static int move = 0;
    static int fightwho;
    static boolean firstFight;
    
    
    static String PlayerName;
    static int playerhp, playeratk, playercoin; 
            
    static int floor,opt;
    
    public static void main(String[] args) {
         new game();
    }
    
    public game(){
        menu = new JFrame(); //create window
        menu.setSize(600,500); //window size
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close with x button
        menu.getContentPane().setBackground(Color.WHITE);
        menu.setLayout(null); //disable the default layout, we want to use a custom layout
        menu.setVisible(true); //we can see the window
        menu.setFocusable(false);
        menu.setTitle("RPG-FOP ADVENTURE");
        menu.setLocationRelativeTo(null); //let the window appeared in the center
        con = menu.getContentPane();
        
        titlenamepanel = new JPanel();
        titlenamepanel.setBounds(55, 100, 500, 100);
        titlenamepanel.setBackground(Color.WHITE);
        titlenamepanel.setForeground(Color.BLACK);
        titlename = new JLabel("RPG-FOP ADVENTURE");
        titlename.setFont(Titlefont);
        titlenamepanel.add(titlename);
        
        
        startbuttonpanel = new JPanel();
        startbuttonpanel.setBounds(200, 300, 200, 100);
        startbuttonpanel.setBackground(Color.WHITE);
        
        String a = "START";
        startButton = new JButton(a);
        startButton.setBackground(Color.WHITE); //button color
        startButton.setForeground(Color.BLACK); //text in button color
        startButton.setFocusPainted(false);
        startButton.addActionListener(cdHandler); //add action listener to start button
        startbuttonpanel.add(startButton);
        
        titlenamepanel.setVisible(true);
        startbuttonpanel.setVisible(true);
        con.add(titlenamepanel);
        con.add(startbuttonpanel);
        
    }
    public void chooseDifficulty(){
        
        startbuttonpanel.setVisible(false); //diasble start button panel after click start 
        
        titlename.setText("choose your difficulty");
        titlename.setFont(storyFont);
        
        difficulty = new JPanel();
        difficulty.setBounds(250, 200, 100, 400);
        difficulty.setBackground(Color.WHITE);
        
        level1 = new JButton("level1");
        level1.setBackground(Color.WHITE); //button color
        level1.setForeground(Color.BLACK); //text in button color
        level1.setFocusPainted(false);
        level1.addActionListener(ts1Handler); //add action listener to start button
        difficulty.add(level1);
        
        level2 = new JButton("level2");
        level2.setBackground(Color.WHITE); //button color
        level2.setForeground(Color.BLACK); //text in button color
        level2.setFocusPainted(false);
        level2.addActionListener(ts2Handler); //add action listener to start button
        difficulty.add(level2);
        
        level3 = new JButton("level3");
        level3.setBackground(Color.WHITE); //button color
        level3.setForeground(Color.BLACK); //text in button color
        level3.setFocusPainted(false);
        level3.addActionListener(ts3Handler); //add action listener to start button
        difficulty.add(level3);
        
        con.add(difficulty);
    }
    public void enterUsernameScreen(){
        
        difficulty.setVisible(false);
        titlenamepanel.setVisible(false); //disable the title panel after click start
        startbuttonpanel.setVisible(false); //diasble start button panel after click start
        
        //enter and leaderboard button
        usernameButton = new JPanel();
        usernameButton.setBounds(200, 300, 200, 100);
        usernameButton.setBackground(Color.white);
        usernameButton.setForeground(Color.black);
        
        //ENTER button
        JButton enter = new JButton("ENTER");
        enter.setBackground(Color.white);
        enter.setForeground(Color.black);
        enter.addActionListener(usHandler);
        usernameButton.add(enter);
        
        //LEADERBOARD button
        JButton back = new JButton("LEADERBOARD");
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(ldHandler);
        usernameButton.add(back);
        
        //panel for please input your username
        JLabel pleaseinputname = new JLabel("Please input your username.\n");
        instruction = new JPanel();
        instruction.setBounds(150, 50, 300, 50);
        instruction.setBackground(Color.white);
        instruction.setForeground(Color.black);
        instruction.add(pleaseinputname);
        
        //panel for input
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx =0;
        gbc.gridy =0;
        gbc.gridwidth = 10;
        inputUsername = new JPanel(new GridBagLayout());
        inputUsername.setBounds(100, 100, 400, 20);
        inputUsername.setBackground(Color.white);
        inputUsername.setForeground(Color.black);
        
        input = new JTextField(20);
        JLabel name = new JLabel("Name : ");
        input.setBounds(150, 150, 300, 50);
        input.setBackground(Color.white);
        input.setForeground(Color.black);
        inputUsername.add(name, gbc);
        inputUsername.add(input);
        
        PlayerName = input.getText();
        con.add(instruction);
        con.add(inputUsername);
        con.add(usernameButton);
    }
    public void storyTelling(){
        PlayerName = input.getText();
        instruction.setVisible(false);
        usernameButton.setVisible(false);
        inputUsername.setVisible(false);
        titlenamepanel.setVisible(false); //disable the title panel after click start
        startbuttonpanel.setVisible(false);
        
        Stories story = new Stories();
        storyPanel = new JPanel();
        storyPanel.setBounds(50, 50, 500, 300);
        storyPanel.setBackground(Color.white);
        storyboard = new JTextArea();
        storyboard.setBounds(50, 50, 400, 300);
        storyboard.setForeground(Color.black);
        storyboard.setText(Stories.introPara1());
        storyboard.setLineWrap(true); //warp the text
        storyboard.setFont(storyFont);
        storyboard.setEditable(false); //disable the user from editing the text
        storyPanel.add(storyboard);
        
        nextStoryButtonPanel = new JPanel();
        nextStoryButtonPanel.setBounds(300, 350, 200, 100);
        nextStoryButtonPanel.setBackground(Color.white);
        nextStoryButtonPanel.setForeground(Color.black);
        nextStoryButtonPanel.setLayout(new GridLayout(4,1));
        
        nextButtonStory = new JButton("next");
        nextButtonStory.setBackground(Color.white);
        nextButtonStory.setForeground(Color.black);
        nextButtonStory.setFocusPainted(false);
        nextButtonStory.addActionListener(ssHandler);
        nextStoryButtonPanel.add(nextButtonStory);
        
        con.add(nextStoryButtonPanel);
        con.add(storyPanel);   
    }
    
    public void introPara2(){
        storyboard.setText(Stories.introPara2());
        nextButtonStory.removeActionListener(ssHandler);
        nextButtonStory.addActionListener(ss2Handler);
    }
    public void introPara3(){
        storyboard.setText(Stories.introPara3());
        nextButtonStory.removeActionListener(ss2Handler);
        nextButtonStory.addActionListener(ss3Handler);
    }
    public void introPara4(){
        storyboard.setText(Stories.introPara4());
        nextButtonStory.removeActionListener(ss3Handler);
        nextButtonStory.addActionListener(cgHandler);
    }
    public void createGameScreen(){
        
        storyboard.setVisible(false);
        usernameButton.setVisible(false);
        inputUsername.setVisible(false);
        titlenamepanel.setVisible(false); //disable the title panel
        nextButtonStory.setVisible(false); //diasble next button panel
        
        maintextPanel = new JPanel();
        maintextPanel.setBounds(50, 100, 500, 400);
        maintextPanel.setBackground(Color.white);
        maintextPanel.setForeground(Color.black);
        
        mainTextArea = new JTextArea();
        mainTextArea.setBounds(50, 100, 500, 400);
        mainTextArea.setBackground(Color.white);
        mainTextArea.setForeground(Color.black);
        mainTextArea.setFont(storyFont);
        mainTextArea.setLineWrap(true); //if text too long, it will break line
        mainTextArea.setText("Welcome to the dungeon, warrior.\n"
                + "Here, the dungeon will generate eveything and there\nis no other "
                + "choices than to defeat the boss of this \nfloor to exit");
        mainTextArea.setVisible(true);
        maintextPanel.add(mainTextArea);
        
        choicePanel = new JPanel();
        choicePanel.setBounds(200, 300, 200, 150);
        choicePanel.setBackground(Color.white);
        choicePanel.setForeground(Color.black);
        choicePanel.setLayout(new GridLayout(5,1));
        
        //button to move North
        choice1 = new JButton("NORTH");
        choice1.setBackground(Color.white);
        choice1.setForeground(Color.black);
        choice1.setFocusPainted(false);
        choice1.addActionListener(NmoveHandler);
        
        //button to move East
        choice2 = new JButton("EAST");
        choice2.setBackground(Color.white);
        choice2.setForeground(Color.black);
        choice2.setFocusPainted(false);
        choice2.addActionListener(EmoveHandler);
        
        //button to move West
        choice3 = new JButton("WEST");
        choice3.setBackground(Color.white);
        choice3.setForeground(Color.black);
        choice3.setFocusPainted(false);
        choice3.addActionListener(WmoveHandler);
        
        //button to move South
        choice4 = new JButton("SOUTH");
        choice4.setBackground(Color.white);
        choice4.setForeground(Color.black);
        choice4.setFocusPainted(false);
        choice4.addActionListener(SmoveHandler);
        
        choice5 = new JButton("INVENTORY");
        choice5.setBackground(Color.white);
        choice5.setForeground(Color.black);
        choice5.setFocusPainted(false);
        choice5.addActionListener(tiHandler);
        
        choicePanel.add(choice1);
        choicePanel.add(choice2);
        choicePanel.add(choice3);
        choicePanel.add(choice4);
        choicePanel.add(choice5);
        
        playerstats = new JPanel();
        playerstats.setBounds(50, 15, 500, 50);
        playerstats.setBackground(Color.WHITE);
        playerstats.setForeground(Color.WHITE);
        playerstats.setLayout(new GridLayout(1, 6));
        
        HPPlayerDisplay = new JLabel("HP:");
        HPPlayerDisplay.setForeground(Color.black);
        HPPlayerDisplay.setFont(normalFont);
        playerstats.add(HPPlayerDisplay);
        PlayerHP = new JLabel();
        PlayerHP.setForeground(Color.black);
        PlayerHP.setFont(normalFont);
        playerstats.add(PlayerHP);
        
        ATKPlayerDisplay = new JLabel("ATK:");
        ATKPlayerDisplay.setForeground(Color.black);
        ATKPlayerDisplay.setFont(normalFont);
        playerstats.add(ATKPlayerDisplay);
        PlayerATK = new JLabel();
        PlayerATK.setForeground(Color.black);
        PlayerATK.setFont(normalFont);
        playerstats.add(PlayerATK);    
        
        COINPlayerDisplay = new JLabel("GOLD:");
        COINPlayerDisplay.setForeground(Color.black);
        COINPlayerDisplay.setFont(normalFont);
        playerstats.add(COINPlayerDisplay);
        PlayerCOIN = new JLabel();
        PlayerCOIN.setForeground(Color.black);
        PlayerCOIN.setFont(normalFont);
        playerstats.add(PlayerCOIN);
                
        createPlayer();
        
        con.add(playerstats);
        con.add(maintextPanel); //put text area on the screen
        con.add(choicePanel);
    }
    public static void continueGameScreen(){
        choice1.setText("NORTH");
        for( ActionListener al : choice1.getActionListeners() ) {
        choice1.removeActionListener( al );
        }
        choice1.addActionListener(NmoveHandler);
        
        for( ActionListener al : choice2.getActionListeners() ) {
        choice2.removeActionListener( al );
        }
        choice2.setText("EAST");
        choice2.addActionListener(EmoveHandler);
        
        for( ActionListener al : choice3.getActionListeners() ) {
        choice3.removeActionListener( al );
        }
        choice3.setText("WEST");
        choice3.addActionListener(WmoveHandler);
        
        for( ActionListener al : choice4.getActionListeners() ) {
        choice4.removeActionListener( al );
        }
        choice4.setText("SOUTH");
        choice4.addActionListener(SmoveHandler);
        
        choice5.setText("INVENTORY");
        choice5.addActionListener(tiHandler);
    }
    
    public static void gameEnd(){
        System.out.println("Name : "+PlayerName);
        System.out.println("Move used : "+move);
        choice1.setText("");
        for( ActionListener al : choice1.getActionListeners() ) {
        choice1.removeActionListener( al );
        }
        
        for( ActionListener al : choice2.getActionListeners() ) {
        choice2.removeActionListener( al );
        }
        choice2.setText("");
        
        for( ActionListener al : choice3.getActionListeners() ) {
        choice3.removeActionListener( al );
        }
        choice3.setText("");
        
        for( ActionListener al : choice4.getActionListeners() ) {
        choice4.removeActionListener( al );
        }
        choice4.setText("");
        
        for( ActionListener al : choice5.getActionListeners() ) {
        choice5.removeActionListener( al );
        }
        choice5.setText("");
    }
    public static void createPlayer(){
        //PlayerName get from user input (GUI)
        System.out.println("Player name: "+PlayerName);
        //these variable is static variable
        playerhp = 50;
        playeratk = 5;
        playercoin = 10;
        
        //display stats on GUI
        PlayerHP.setText(""+playerhp);
        PlayerATK.setText(""+playeratk);
        PlayerCOIN.setText(""+playercoin);
    }
    
    public void displayLeaderboard(){
        
        instruction.setVisible(false);
        inputUsername.setVisible(false);
        usernameButton.setVisible(false);
        
        leaderBoardPanel = new JPanel();
        leaderBoardPanel.setBounds(50, 100, 500, 400);
        leaderBoardPanel.setBackground(Color.white);
        leaderBoardPanel.setForeground(Color.black);
        
        leaderBoardArea= new JTextArea();
        leaderBoardArea.setBounds(50, 100, 500, 400);
        leaderBoardArea.setBackground(Color.white);
        leaderBoardArea.setForeground(Color.black);
        leaderBoardArea.setFont(storyFont);
        leaderBoardArea.setLineWrap(true); //if text too long, it will break line
        leaderBoardArea.setText("gay"); //String for leaderboard is here
        leaderBoardArea.setVisible(true);
        leaderBoardPanel.add(leaderBoardArea);
        
        returnPanel = new JPanel();
        returnPanel.setBounds(200, 300, 200, 150);
        returnPanel.setBackground(Color.white);
        returnPanel.setForeground(Color.black);
        returnPanel.setLayout(new GridLayout(5,1));
        
        //button to return
        R = new JButton("RETURN");
        R.setBackground(Color.white);
        R.setForeground(Color.black);
        R.setFocusPainted(false);
        R.addActionListener(tsHandler);
        
        returnPanel.add(R);
        con.add(leaderBoardPanel);
        con.add(returnPanel);        
    }
    
    public void fightButton(){
        choice1.setText("FIGHT");
        choice1.removeActionListener(NmoveHandler);
        choice1.addActionListener(fbHandler);
        choice2.setText("RUN");
        choice2.removeActionListener(EmoveHandler);
        choice2.addActionListener(backHandler);
        choice3.setText("");
        choice3.removeActionListener(WmoveHandler);
        choice4.setText("");
        choice4.removeActionListener(SmoveHandler);
        choice5.setText("");
        choice5.removeActionListener(tiHandler);
        
    }
    
    public class chooseDifficultyHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            chooseDifficulty();
        }
    }
    public class titleScreenHandler1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            floor = 1;
            enterUsernameScreen();
        }
    }
    public class titleScreenHandler2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            floor = 2;
            enterUsernameScreen();
        }
    }
    public class titleScreenHandler3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            floor = 3;
            enterUsernameScreen();
        }
    }
    public class titleScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            leaderBoardPanel.setVisible(false);
            returnPanel.setVisible(false);
            enterUsernameScreen();
        }
    }
    public class usernameScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            storyTelling();
            //createGameScreen();
        }
    }
    public class leaderboardHandler implements ActionListener{        
        @Override
        public void actionPerformed(ActionEvent event){
            displayLeaderboard();
            //open leaderboard from database function
        }
    }
    public class sambungstory implements ActionListener{        
        @Override
        public void actionPerformed(ActionEvent event){
            introPara2();
        }
    }
    public class sambungstory2 implements ActionListener{        
        @Override
        public void actionPerformed(ActionEvent event){
            introPara3();
        }
    }
    public class sambungstory3 implements ActionListener{        
        @Override
        public void actionPerformed(ActionEvent event){
            introPara4();
        }
    }
    public class createGame implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            createGameScreen();
        }
    }
    public static class toInventory implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            displayInventory();
        }
    }
    // back is for running from monster/boss
    public static class back implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            mainTextArea.setText("Your return back to nowhere");
            continueGameScreen();
        }
    }
    
    // button to move
    public static class toNorth implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            move++;
            firstFight = true;
            switch(floor){
                    case 1:
                        mainTextArea.setText("You found a boss tarantula, fight or flight?");
                        break;
                    case 2:
                        mainTextArea.setText("You found a boss giant, fight or flight?");
                        break;
                    case 3:
                        mainTextArea.setText("You found a boss dragon, fight or flight?");
                        break;
                }
            choice1.setText("FIGHT");
            choice2.setText("RUN");
            choice3.setText("");
            choice4.setText("");
            choice1.removeActionListener(NmoveHandler);
            choice2.removeActionListener(EmoveHandler);
            choice3.removeActionListener(WmoveHandler);
            choice4.removeActionListener(SmoveHandler);
            choice1.addActionListener(fbHandler);
            choice2.addActionListener(backHandler);
        }
    }
    public static class toEast implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            findItem();
            move++;
            PlayerHP.setText(""+playerhp);
            PlayerATK.setText(""+playeratk);
            PlayerCOIN.setText(""+playercoin);
        }
    }
    public static class toWest implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            move++;
            firstFight=true;
            Random random = new Random();
            fightwho = random.nextInt(2);
            if(fightwho == 1){
                switch(floor){
                    case 1:
                        mainTextArea.setText("You found a goblin, fight or flight?");
                        break;
                    case 2:
                        mainTextArea.setText("You found a lizard, fight or flight?");
                        break;
                    case 3:
                        mainTextArea.setText("You found a zombie, fight or flight?");
                        break;
                }
            }else{
                switch(floor){
                    case 1:
                        mainTextArea.setText("You found a slime, fight or flight?");
                        break;
                    case 2:
                        mainTextArea.setText("You found a basilisk, fight or flight?");
                        break;
                    case 3:
                        mainTextArea.setText("You found a witch, fight or flight?");
                        break;
                }
            }
            choice1.setText("FIGHT");
            choice2.setText("RUN");
            choice3.setText("");
            choice4.setText("");
            choice1.removeActionListener(NmoveHandler);
            choice2.removeActionListener(EmoveHandler);
            choice3.removeActionListener(WmoveHandler);
            choice4.removeActionListener(SmoveHandler);
            choice1.addActionListener(fightMonHandler);
            choice2.addActionListener(backHandler);
        }
    }
    public static class toSouth implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            move++;
            Items();
            choice1.setText("BUY");
            choice2.setText("RETURN");
            choice3.setText("");
            choice4.setText("");
            choice1.removeActionListener(NmoveHandler);
            choice2.removeActionListener(EmoveHandler);
            choice3.removeActionListener(WmoveHandler);
            choice4.removeActionListener(SmoveHandler);
            choice1.addActionListener(buyHandler);
            choice2.addActionListener(backHandler);
       }
    }
    
    public static class buy implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            choice1.setText("1");
            choice2.setText("2");
            choice3.setText("");
            choice4.setText("");
            choice1.removeActionListener(buyHandler);
            choice2.removeActionListener(backHandler);
            choice1.addActionListener(buy1Handler);
            choice2.addActionListener(buy2Handler);
             
        }
    }
    public static class buy1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            opt=1;
            Buy_Process();
            PlayerHP.setText(""+playerhp);
            PlayerATK.setText(""+playeratk);
            PlayerCOIN.setText(""+playercoin);
            choice1.removeActionListener(buy1Handler);
            choice2.removeActionListener(buy2Handler);
            continueGameScreen();
        }
    }
    public static class buy2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            opt =2;
            Buy_Process();
            PlayerHP.setText(""+playerhp);
            PlayerATK.setText(""+playeratk);
            PlayerCOIN.setText(""+playercoin);
            choice1.removeActionListener(buy1Handler);
            choice2.removeActionListener(buy2Handler);
            continueGameScreen();
        }
    }
    public static class fightBoss implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            switch(floor){
                case 1:
                    if(firstFight){
                            tarantula = new tarantula(75, 9, 15);
                        }
                        tarantula.attack();
                    break;
                case 2:
                    if(firstFight){
                            giant = new giant(160, 18, 50);
                        }
                        giant.attack();
                    break;
                case 3:
                    if(firstFight){
                            dragon = new dragon(275, 70);
                        }
                        dragon.attack();
                    break;
            }
            firstFight=false;
        }
    }
    public static class fightMon implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            
            if(fightwho == 1){
                switch(floor){
                    case 1:
                        if(firstFight){
                            goblin = new goblin(45, 5, 7);
                        }
                        goblin.attack();
                        break;
                    case 2:
                        if(firstFight){
                            lizard = new lizard(55, 6, 9);
                        }
                        lizard.attack();
                        break;
                    case 3:
                        if(firstFight){
                            zombie = new zombie(60, 9, 10);
                        }
                        zombie.attack();
                        break;
                }
            }else{
                switch(floor){
                    case 1:
                        if(firstFight){
                            slime = new slime(35, 3, 5);
                        }
                        slime.attack();
                        break;
                    case 2:
                        if(firstFight){
                            basilisk = new basilisk(75, 8, 12);
                        }
                        basilisk.attack();
                        break;
                    case 3:
                        if(firstFight){
                            witch = new witch(105, 15, 20);
                        }
                        witch.attack();
                        break;
                }
            }
            firstFight = false;
        }
    }
}