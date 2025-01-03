/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rpgfop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static rpgfop.Inv.displayInventory;
import static rpgfop.Inv.findItem;
import static rpgfop.Inv.useItem;
import static rpgfop.Merchant.Items;

/**
 *
 * @author USER
 */
public class game {
    
    JFrame menu;
    Container con; //function to add button, title etc
    JPanel titlenamepanel, startbuttonpanel, maintextPanel ,choicePanel;
    JPanel playerstats;
    JPanel storyPanel, nextStoryButtonPanel;
    JTextArea storyboard;
    static JTextArea mainTextArea;
    JPanel usernameButton ,inputUsername, instruction;
    JLabel titlename, HPPlayerDisplay, ATKPlayerDisplay, PlayerHP, PlayerATK, COINPlayerDisplay, PlayerCOIN, MANAPlayerDisplay, PlayerMANA;
    Font Titlefont = new Font("Algerian ", Font.PLAIN, 45);
    Font normalFont = new Font("Arabic Typesetting", Font.PLAIN, 25);
    Font storyFont = new Font("Monospaced", Font.PLAIN, 15);
    JButton startButton, nextButtonStory;
    JButton choice1, choice2, choice3, choice4, choice5;
    
    JPanel inventoryitem;
    JButton item1, item2, item3, item4, item5, item6, item7, item8, item9, item10;
    JButton backFromInventory;
    
    
    titleScreenHandler tsHandler = new titleScreenHandler();
    usernameScreenHandler usHandler = new usernameScreenHandler();
    leaderboardHandler ldHandler = new leaderboardHandler();
    sambungstory ssHandler = new sambungstory();
    sambungstory2 ss2Handler = new sambungstory2();
    sambungstory3 ss3Handler = new sambungstory3();
    createGame cgHandler = new createGame();
    
    //object for action listener
    toNorth NmoveHandler = new toNorth();
    toEast EmoveHandler = new toEast();
    toWest WmoveHandler = new toWest();
    toSouth SmoveHandler = new toSouth();
    toInventory tiHandler = new toInventory();
    
    useitem useitemHandler = new useitem();
    
    String PlayerName;
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
        startButton.addActionListener(tsHandler); //add action listener to start button
        startbuttonpanel.add(startButton);
        
        con.add(titlenamepanel);
        con.add(startbuttonpanel);
        
    }
    
    public void enterUsernameScreen(){
        
        titlenamepanel.setVisible(false); //disable the title panel after click start
        startbuttonpanel.setVisible(false); //diasble start button panel after click start
        
        //enter and back button
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
        
        JTextField input = new JTextField(20);
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
        maintextPanel.setBounds(50, 100, 450, 400);
        maintextPanel.setBackground(Color.white);
        
        mainTextArea = new JTextArea("Welcome to the dungeon, warrior. "
                + "Here, the dungeon will generate eveything themself and there is no other "
                + "choices than to defeat the boss of this floor to exit");
        mainTextArea.setBounds(50, 100, 450, 100);
        mainTextArea.setBackground(Color.gray);
        mainTextArea.setForeground(Color.black);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true); //if text too long, it will break line
        maintextPanel.add(mainTextArea);
        
        choicePanel = new JPanel();
        choicePanel.setBounds(200, 300, 200, 150);
        choicePanel.setBackground(Color.red);
        choicePanel.setForeground(Color.black);
        choicePanel.setLayout(new GridLayout(5,1));
        
        choice1 = new JButton("NORTH");
        choice1.setBackground(Color.white);
        choice1.setForeground(Color.black);
        choice1.setFocusPainted(false);
        choice1.addActionListener(NmoveHandler);
        
        choice2 = new JButton("EAST");
        choice2.setBackground(Color.white);
        choice2.setForeground(Color.black);
        choice2.setFocusPainted(false);
        choice2.addActionListener(EmoveHandler);
        
        choice3 = new JButton("WEST");
        choice3.setBackground(Color.white);
        choice3.setForeground(Color.black);
        choice3.setFocusPainted(false);
        choice3.addActionListener(WmoveHandler);
        
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
        playerstats.setLayout(new GridLayout(1, 8));
        
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
        
        MANAPlayerDisplay = new JLabel("MANA:");
        MANAPlayerDisplay.setForeground(Color.black);
        MANAPlayerDisplay.setFont(normalFont);
        playerstats.add(MANAPlayerDisplay);
        PlayerMANA = new JLabel();
        PlayerMANA.setForeground(Color.black);
        PlayerMANA.setFont(normalFont);
        playerstats.add(PlayerMANA);
        
        COINPlayerDisplay = new JLabel("COIN:");
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
    
    public void createPlayer(){
        int playerhp, playeratk, playermana, playercoin;
        playerhp = 30;
        playeratk = 5;
        playermana = 50;
        playercoin = 10;
        
        PlayerHP.setText(""+playerhp);
        PlayerATK.setText(""+playeratk);
        PlayerMANA.setText(""+playermana);
        PlayerCOIN.setText(""+playercoin);
        
    }
    public class titleScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
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
    public class toInventory implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            displayInventory();
            choice1.setText("USE ITEM");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
            choice5.setText("");
            choice1.addActionListener(useitemHandler);
            choice1.removeActionListener(NmoveHandler);
            choice2.removeActionListener(EmoveHandler);
            choice3.removeActionListener(WmoveHandler);
            choice4.removeActionListener(SmoveHandler);
            choice5.removeActionListener(tiHandler);
        }
    }
    
    // button to move
    public class toNorth implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
        }
    }
    public class toEast implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            findItem();
            
        }
    }
    public class toWest implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
        }
    }
    public class toSouth implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            Items();
        }
    }
    public class useitem implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            useItem();
                choice1.setText("1");
                choice2.setText("2");
                choice3.setText("3");
                choice4.setText("4");
                choice5.setText("5");
        }
    }
}