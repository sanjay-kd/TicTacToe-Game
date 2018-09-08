package com.tictactoe.game;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import jaco.mp3.player.MP3Player;

public class SinglePlayerGame extends JFrame {

	/**
	 * The {@code Game} is the playing board screen for Tic Tac Toe game.
	 * @since 4 July 2018
	 * @author sanjay
	 */
	private static final long serialVersionUID = 7252992861238213874L;
	JButton one = new JButton();
	JButton two = new JButton();
	JButton three = new JButton();
	JButton four = new JButton();
	JButton five = new JButton();
	JButton six = new JButton();
	JButton seven = new JButton();
	JButton eight = new JButton();
	JButton nine = new JButton();
	
	ArrayList<JButton> arrayList = new ArrayList<>();
	ArrayList<JButton> userSelectedButtonsList = new ArrayList<>();
	ArrayList<JButton> cpuSelectedButtonsList = new ArrayList<>();
	
	JLabel player1NameLabel = new JLabel("Computer");
	JLabel player2NameLabel = new JLabel();
	JLabel player1ScoreLabel = new JLabel("0");
	JLabel player2ScoreLabel = new JLabel("0");
	JLabel label = new JLabel("-");
	JButton restartGameBtn = new JButton("Restart");
	private JPanel contentPane;
	private boolean isXorZero;
	private int player1Score;
	private int player2Score;
	private final JButton resetGameBtn = new JButton("Reset");
	MP3Player sound;
	private boolean computerChance;
	private int randomIndex;
	private boolean result;
	JButton winningButton;
	private JFrame frame;
	private final JButton menuBtn = new JButton("Menu");
	
	
	
	//This method is created because after checking if User is Winning the programs was setting random text on some buttons and showed Game Over popup message window.
	//This method is called inside isGameOver() method.
	public void setTextInArrayList(){
		for(int i=0;i<arrayList.size();i++){
			arrayList.get(i).setText("");
		}
	}
	
	public boolean isRowValueEqualForCpu(JButton first, JButton second, JButton third){
		first.setText("X");
		return first.getText().equals(second.getText()) && first.getText().equals(third.getText()) && first.getX()==second.getX() && first.getX()==third.getX() ||
				first.getText().equals(second.getText()) && first.getText().equals(third.getText()) && first.getY()==second.getY() && first.getY()==third.getY();
	}
	
	public boolean checkCpuWin(){
		result = false;
		for(int i=0;i<arrayList.size();i++)
		{
			if(!result){
				if(cpuSelectedButtonsList.size() == 2)
				{
					result = isRowValueEqualForCpu(arrayList.get(i),cpuSelectedButtonsList.get(0),cpuSelectedButtonsList.get(1));
					if(result)
					{
						winningButton = arrayList.get(i);
					}
				}
				else if(cpuSelectedButtonsList.size() == 3){
					result = isRowValueEqualForCpu(arrayList.get(i),cpuSelectedButtonsList.get(0),cpuSelectedButtonsList.get(1))||
							isRowValueEqualForCpu(arrayList.get(i),cpuSelectedButtonsList.get(0),cpuSelectedButtonsList.get(2)) ||
							isRowValueEqualForCpu(arrayList.get(i),cpuSelectedButtonsList.get(1),cpuSelectedButtonsList.get(2));
					if(result)
					{
						winningButton = arrayList.get(i);
					}
				}
				else if(cpuSelectedButtonsList.size() == 4){
					result = isRowValueEqualForCpu(arrayList.get(i),cpuSelectedButtonsList.get(0),cpuSelectedButtonsList.get(1))||
							 isRowValueEqualForCpu(arrayList.get(i),cpuSelectedButtonsList.get(0),cpuSelectedButtonsList.get(2)) ||
							 isRowValueEqualForCpu(arrayList.get(i),cpuSelectedButtonsList.get(0),cpuSelectedButtonsList.get(3)) ||
							 isRowValueEqualForCpu(arrayList.get(i),cpuSelectedButtonsList.get(1),cpuSelectedButtonsList.get(2)) ||
							 isRowValueEqualForCpu(arrayList.get(i),cpuSelectedButtonsList.get(1),cpuSelectedButtonsList.get(3)) ||
							 isRowValueEqualForCpu(arrayList.get(i),cpuSelectedButtonsList.get(2),cpuSelectedButtonsList.get(3));
					if(result)
					{
						winningButton = arrayList.get(i);
					}
				}
			}
		}
		return result;
	}
	
	public boolean isRowValueEqualForUser(JButton first, JButton second, JButton third){
		first.setText("O");
		return first.getText().equals(second.getText()) && first.getText().equals(third.getText()) && first.getX()==second.getX() && first.getX()==third.getX() ||
				first.getText().equals(second.getText()) && first.getText().equals(third.getText()) && first.getY()==second.getY() && first.getY()==third.getY();
	}
	
	public boolean checkUserWin(){
		result = false;
		for(int i=0;i<arrayList.size();i++)
		{
			if(!result){
				if(userSelectedButtonsList.size() == 2)
				{
					result = isRowValueEqualForUser(arrayList.get(i),userSelectedButtonsList.get(0),userSelectedButtonsList.get(1));
					if(result)
					{
						winningButton = arrayList.get(i);
					}
				}
				else if(userSelectedButtonsList.size() == 3){
					result = isRowValueEqualForUser(arrayList.get(i),userSelectedButtonsList.get(0),userSelectedButtonsList.get(1))||
							 isRowValueEqualForUser(arrayList.get(i),userSelectedButtonsList.get(0),userSelectedButtonsList.get(2)) ||
							 isRowValueEqualForUser(arrayList.get(i),userSelectedButtonsList.get(1),userSelectedButtonsList.get(2));
					if(result)
					{
						winningButton = arrayList.get(i);
					}
				}
				else if(userSelectedButtonsList.size() == 4){
					result = isRowValueEqualForUser(arrayList.get(i),userSelectedButtonsList.get(0),userSelectedButtonsList.get(1))||
							 isRowValueEqualForUser(arrayList.get(i),userSelectedButtonsList.get(0),userSelectedButtonsList.get(2)) ||
							 isRowValueEqualForUser(arrayList.get(i),userSelectedButtonsList.get(0),userSelectedButtonsList.get(3)) ||
							 isRowValueEqualForUser(arrayList.get(i),userSelectedButtonsList.get(1),userSelectedButtonsList.get(2)) ||
							 isRowValueEqualForUser(arrayList.get(i),userSelectedButtonsList.get(1),userSelectedButtonsList.get(3)) ||
							 isRowValueEqualForUser(arrayList.get(i),userSelectedButtonsList.get(2),userSelectedButtonsList.get(3));
					if(result)
					{
						winningButton = arrayList.get(i);
					}
				}
			}
		}
		return result;
	}
	
	public void addToArrayList(){
		arrayList.add(one);
		arrayList.add(two);
		arrayList.add(three);
		arrayList.add(four);
		arrayList.add(five);
		arrayList.add(six);
		arrayList.add(seven);
		arrayList.add(eight);
		arrayList.add(nine);
	}
	
	private void selectButtonFromArrayList(){
		if(computerChance){
			Random random = new Random();
			if(!arrayList.isEmpty()){
				randomIndex = random.nextInt(arrayList.size());
				if(!(arrayList.get(randomIndex).getText().trim().length()>0)){
					//call check if CPU wins function then set Text on that button accordingly
					// if cpuWins then set Text directly and if user winning then set text at that position
					if(checkCpuWin()){
						setText(winningButton);
					}
					else if(checkUserWin()){
						setText(winningButton);
					}
					else{
						setText(arrayList.get(randomIndex));
					}
							
				}
				else{
					selectButtonFromArrayList();
				}
			}
		}
	}
	
	/**
	 * {@code onClickSound} method performs playing sound when button is clicked.
	 * @param null
	 * 
	 */
	public void onClickSound(){
		sound = new MP3Player();
		sound.addToPlayList(SplashScreen.class.getResource("click.mp3"));
		sound.play();
	}
	
	/**
	 * {@code gameOverSound} method performs playing sound when game is over that is when either player wins.
	 * @param null
	 */
	public void gameOverSound(){
		sound = new MP3Player();
		sound.addToPlayList(SplashScreen.class.getResource("gameOver.mp3"));
		sound.play();
	}
	
	/**
	 * {@code resetGame} method resets the game.
	 * @param null
	 * 
	 */
	public void resetGame(){
		restartGame();
		player1Score =0;
		player2Score =0;
		player1ScoreLabel.setText(String.valueOf(player1Score));
		player2ScoreLabel.setText(String.valueOf(player2Score));
	}
	
	
	/**
	 * {@code playMusic} method restarts the game.
	 * @param null
	 * 
	 */
	public void restartGame(){
		one.setText("");
		two.setText("");
		three.setText("");
		four.setText("");
		five.setText("");
		six.setText("");
		seven.setText("");
		eight.setText("");
		nine.setText("");
		arrayList.clear();
		addToArrayList();
		cpuSelectedButtonsList.clear();
		userSelectedButtonsList.clear();
		isXorZero = false;
		computerChance =false;
		result = false;
	}
	
	/**
	 * {@code playMusic} method returns whether game is over or not.
	 * @param null
	 */
	public boolean isGameOver(){
		
		setTextInArrayList();
		
		return 	isRowValueEqual(one,two,three)    ||
				isRowValueEqual(four,five,six)    ||
				isRowValueEqual(seven,eight,nine) ||
				isRowValueEqual(one,four,seven)   ||
				isRowValueEqual(two,five,eight)   ||
				isRowValueEqual(three,six,nine)   ||
				isRowValueEqual(one,five,nine)    ||
				isRowValueEqual(three,five,seven);
	}
	
	/**
	 * {@code isRowEqual} method return boolean.
	 * The method computes whether text in one of the row or column or diaognal are is equal.
	 * 
	 * @param Three objects of type JButtons
	 * 
	 */
	public boolean isRowValueEqual(JButton first, JButton second, JButton third){
		if(!first.getText().isEmpty() && !second.getText().isEmpty() && !third.getText().isEmpty()){
			if(first.getText().equals(second.getText()) && first.getText().equals(third.getText())){
				gameOverSound();
				if(first.getText().equals("X")){
					player1Score++;
					JOptionPane.showMessageDialog(this, "Game Over and Win by Computer");
				}
				else{
					player2Score++;
					JOptionPane.showMessageDialog(this, "Game Over and Win by You");
				}
				restartGame();
				player1ScoreLabel.setText(String.valueOf(player1Score));
				player2ScoreLabel.setText(String.valueOf(player2Score));

				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	/**
	 * {@code isAlreadyMarked} method checks whether button is already marked or not.
	 * @param object of type JButton
	 * 
	 */
	public boolean isAlreadyMarked(JButton button){
		if(button.getText().trim().length()>0){
			JOptionPane.showMessageDialog(this, "Already marked");
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * {@code setTex} method sets text (X/O) on the button when it is clicked.
	 * @param object of type JButton
	 * 
	 */
	public void setText(JButton currentButton){
		if(isXorZero){
			player1ScoreLabel.setForeground(Color.RED);
			currentButton.setText("X");
			cpuSelectedButtonsList.add(currentButton);
			currentButton.setForeground(Color.RED);
			computerChance = false;
		}
		else{
			player2ScoreLabel.setForeground(Color.BLUE);
			currentButton.setText("O");
			userSelectedButtonsList.add(currentButton);
			currentButton.setForeground(Color.BLUE);
			computerChance = true;
		}
		result = false;
		arrayList.remove(currentButton);
		isXorZero = !isXorZero;
		isGameOver();
	}

	/**
	 * {@code main} method is the entry point for {@code Game}.
	 * @param null
	 * 
	 */

	public SinglePlayerGame(String playerName) {
		frame = this;
		this.setVisible(true);
		setTitle("Tic Tac Toe");
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(528, 593);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addToArrayList();
		
		JButton easyLevelBtn = new JButton("Easy");
		easyLevelBtn.setFocusPainted(false);
		easyLevelBtn.setForeground(new Color(50, 205, 50));
		easyLevelBtn.setBounds(58, 31, 95, 39);
		contentPane.add(easyLevelBtn);
		
		JButton normalLevelBtn = new JButton("Normal");
		normalLevelBtn.setFocusPainted(false);
		normalLevelBtn.setForeground(new Color(255, 153, 51));
		normalLevelBtn.setBounds(196, 31, 95, 39);
		contentPane.add(normalLevelBtn);
		
		JButton hardLevelBtn = new JButton("Hard");
		hardLevelBtn.setFocusPainted(false);
		hardLevelBtn.setForeground(new Color(255, 0, 0));
		hardLevelBtn.setBounds(337, 31, 95, 39);
		contentPane.add(hardLevelBtn);
		one.setToolTipText("");
		one.setFocusPainted(false);
		
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAlreadyMarked(one)){
					onClickSound();
					setText(one);
					if(!isGameOver()){
						selectButtonFromArrayList();
					}
				}
			}
		});
		one.setBackground(Color.WHITE);
		one.setForeground(Color.BLUE);
		one.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		one.setBounds(115, 134, 95, 95);
		contentPane.add(one);
		two.setToolTipText("");
		
		two.setFocusPainted(false);
		
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAlreadyMarked(two)){
					onClickSound();
					setText(two);
					if(!isGameOver()){;
						selectButtonFromArrayList();
					}
				}
			}
		});
		two.setForeground(Color.RED);
		two.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		two.setBounds(207, 134, 95, 95);
		contentPane.add(two);
		three.setToolTipText("");
		
		three.setFocusPainted(false);
		
		three.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAlreadyMarked(three)){
					onClickSound();
					setText(three);
					if(!isGameOver()){
						selectButtonFromArrayList();
					}
				}
			}
		});
		three.setBounds(299, 134, 95, 95);
		contentPane.add(three);
		four.setToolTipText("");
		
		
		four.setFocusPainted(false);
		
		
		four.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAlreadyMarked(four)){
					onClickSound();
					setText(four);
					if(!isGameOver()){
						selectButtonFromArrayList();
					}
				}
			}
		});
		four.setBounds(115, 225, 95, 95);
		contentPane.add(four);
		five.setToolTipText("");
		
		
		five.setFocusPainted(false);
		
		
		five.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAlreadyMarked(five)){
					onClickSound();
					setText(five);
					if(!isGameOver()){
						selectButtonFromArrayList();
					}
				}
			}
		});
		five.setBounds(207, 225, 95, 95);
		contentPane.add(five);
		six.setToolTipText("");
		
		
		six.setFocusPainted(false);
		
		
		six.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAlreadyMarked(six)){
					onClickSound();
					setText(six);
					if(!isGameOver()){
						selectButtonFromArrayList();
					}
				}
			}
		});
		six.setBounds(299, 225, 95, 95);
		contentPane.add(six);
		seven.setToolTipText("");
		
		
		seven.setFocusPainted(false);
		
	
		seven.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAlreadyMarked(seven)){
					onClickSound();
					setText(seven);
					if(!isGameOver()){
						selectButtonFromArrayList();
					}
				}
			}
		});
		seven.setBounds(115, 316, 95, 95);
		contentPane.add(seven);
		eight.setToolTipText("");
		
		
		eight.setFocusPainted(false);
		
	
		eight.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAlreadyMarked(eight)){
					onClickSound();
					setText(eight);
					if(!isGameOver()){
						selectButtonFromArrayList();
					}
				}
			}
		});
		eight.setBounds(207, 316, 95, 95);
		contentPane.add(eight);
		nine.setToolTipText("");
		
		
		nine.setFocusPainted(false);
		
		
		nine.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAlreadyMarked(nine)){
					onClickSound();
					setText(nine);
					if(!isGameOver()){
						selectButtonFromArrayList();
					}
				}
			}
		});
		nine.setBounds(299, 316, 95, 95);
		contentPane.add(nine);
		
		
		player1NameLabel.setForeground(Color.WHITE);
		player1NameLabel.setFont(new Font("Marion", Font.BOLD, 20));
		player1NameLabel.setBounds(32, 493, 95, 27);
		contentPane.add(player1NameLabel);
		
		player2NameLabel.setForeground(Color.WHITE);
		player2NameLabel.setFont(new Font("Marion", Font.BOLD, 20));
		player2NameLabel.setBounds(238, 493, 95, 27);
		player2NameLabel.setText(playerName);
		contentPane.add(player2NameLabel);
		
		player1ScoreLabel.setForeground(new Color(255, 255, 255));
		player1ScoreLabel.setFont(new Font("Arial Black", Font.PLAIN, 24));
		player1ScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		player1ScoreLabel.setBounds(124, 475, 42, 59);
		contentPane.add(player1ScoreLabel);
		restartGameBtn.setFocusPainted(false);
		
		restartGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restartGame();
			}
		});
		restartGameBtn.setBackground(Color.WHITE);
		restartGameBtn.setBounds(429, 420, 81, 49);
		contentPane.add(restartGameBtn);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Arial Black", Font.PLAIN, 24));
		label.setBounds(162, 475, 42, 59);
		
		contentPane.add(label);
		player2ScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		player2ScoreLabel.setForeground(new Color(255, 255, 255));
		player2ScoreLabel.setFont(new Font("Arial Black", Font.PLAIN, 24));
		player2ScoreLabel.setBounds(196, 475, 42, 59);
		
		contentPane.add(player2ScoreLabel);
		resetGameBtn.setFocusPainted(false);
		resetGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetGame();
			}
		});
		resetGameBtn.setBackground(Color.WHITE);
		resetGameBtn.setBounds(429, 466, 81, 49);
		
		contentPane.add(resetGameBtn);
		menuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				MenuOptions menuOptions = new MenuOptions();
				menuOptions.setTitle("Menu");
				menuOptions.setLocationRelativeTo(null);
				menuOptions.setVisible(true);
			}
		});
		menuBtn.setFocusPainted(false);
		menuBtn.setBackground(Color.WHITE);
		menuBtn.setBounds(429, 513, 81, 49);
		
		contentPane.add(menuBtn);
	}
}
