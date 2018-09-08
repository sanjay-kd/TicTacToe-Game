package com.tictactoe.game;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MultiPlayerGame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7252992861238213874L;
	SinglePlayerGame singlePlayerGame;
	JButton one = new JButton();
	JButton two = new JButton();
	JButton three = new JButton();
	JButton four = new JButton();
	JButton five = new JButton();
	JButton six = new JButton();
	JButton seven = new JButton();
	JButton eight = new JButton();
	JButton nine = new JButton();
	JLabel player1NameLabel = new JLabel("Player 1");
	JLabel player2NameLabel = new JLabel("Player 2");
	JLabel player1ScoreLabel = new JLabel("0");
	JLabel player2ScoreLabel = new JLabel("0");
	JLabel label = new JLabel("-");
	JButton restartGameBtn = new JButton("Restart");
	private JPanel contentPane;
	private boolean isXorZero;
	private int player1Score;
	private int player2Score;
	private JButton resetGameBtn = new JButton("Reset");
	private JButton menuBtn = new JButton("Menu");
	private JFrame frame;
	
	public void resetGame(){
		restartGame();
		player1Score =0;
		player2Score =0;
		player1ScoreLabel.setText(String.valueOf(player1Score));
		player2ScoreLabel.setText(String.valueOf(player2Score));
	}
	
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
		isXorZero = false;
	}
	
	public boolean isGameOver(){
		
		return 	isRowValueEqual(one,two,three)    ||
				isRowValueEqual(four,five,six)    ||
				isRowValueEqual(seven,eight,nine) ||
				isRowValueEqual(one,four,seven)   ||
				isRowValueEqual(two,five,eight)   ||
				isRowValueEqual(three,six,nine)   ||
				isRowValueEqual(one,five,nine)    ||
				isRowValueEqual(three,five,seven);
	}
	
	public boolean isRowValueEqual(JButton first, JButton second, JButton third){
		if(!first.getText().isEmpty() && !second.getText().isEmpty() && !third.getText().isEmpty()){
			if(first.getText().equals(second.getText()) && first.getText().equals(third.getText())){
				if(first.getText().equals("X")){
					player1Score++;
				}
				else{
					player2Score++;
				}
				player1ScoreLabel.setText(String.valueOf(player1Score));
				player2ScoreLabel.setText(String.valueOf(player2Score));
				singlePlayerGame.gameOverSound();
				JOptionPane.showMessageDialog(this, "Game Over");
				restartGame();
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
	
	public boolean isAlreadyMarked(JButton button){
		if(button.getText().trim().length()>0){
			JOptionPane.showMessageDialog(this, "Already marked");
			return true;
		}
		else{
			return false;
		}
	}
	
	public void setText(JButton currentButton){
		if(isXorZero){
			player1ScoreLabel.setForeground(Color.RED);
			currentButton.setText("X");
			currentButton.setForeground(Color.RED);
		}
		else{
			player2ScoreLabel.setForeground(Color.BLUE);
			currentButton.setText("O");
			currentButton.setForeground(Color.BLUE);
		}
		isXorZero = !isXorZero;
	}

	public MultiPlayerGame(String player1NameMultiPlayer,String player2NameMultiPlayer){
		frame = this;
		frame.setVisible(true);
		singlePlayerGame = new SinglePlayerGame(null);
		setTitle("Tic Tac Toe");
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(519, 593);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton easyLevelBtn = new JButton("Easy");
		easyLevelBtn.setForeground(new Color(50, 205, 50));
		easyLevelBtn.setBounds(58, 31, 95, 39);
		contentPane.add(easyLevelBtn);
		
		JButton normalLevelBtn = new JButton("Normal");
		normalLevelBtn.setForeground(new Color(255, 153, 51));
		normalLevelBtn.setBounds(196, 31, 95, 39);
		contentPane.add(normalLevelBtn);
		
		JButton hardLevelBtn = new JButton("Hard");
		hardLevelBtn.setForeground(new Color(255, 0, 0));
		hardLevelBtn.setBounds(337, 31, 95, 39);
		contentPane.add(hardLevelBtn);
		
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAlreadyMarked(one)){
					singlePlayerGame.onClickSound();
					setText(one);
					isGameOver();
				}
			}
		});
		one.setBackground(Color.WHITE);
		one.setForeground(Color.BLUE);
		one.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		one.setBounds(115, 134, 95, 95);
		contentPane.add(one);
		
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAlreadyMarked(two)){
					singlePlayerGame.onClickSound();
					setText(two);
					isGameOver();
				}
			}
		});
		two.setForeground(Color.RED);
		two.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		two.setBounds(207, 134, 95, 95);
		contentPane.add(two);
		
		
		three.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAlreadyMarked(three)){
					singlePlayerGame.onClickSound();
					setText(three);
					isGameOver();
				}
			}
		});
		three.setBounds(299, 134, 95, 95);
		contentPane.add(three);
		
		
		four.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAlreadyMarked(four)){
					singlePlayerGame.onClickSound();
					setText(four);
					isGameOver();
				}
			}
		});
		four.setBounds(115, 225, 95, 95);
		contentPane.add(four);
		
		
		five.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAlreadyMarked(five)){
					singlePlayerGame.onClickSound();
					setText(five);
					isGameOver();
				}
			}
		});
		five.setBounds(207, 225, 95, 95);
		contentPane.add(five);
		
		
		six.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAlreadyMarked(six)){
					singlePlayerGame.onClickSound();
					setText(six);
					isGameOver();
				}
			}
		});
		six.setBounds(299, 225, 95, 95);
		contentPane.add(six);
		
	
		seven.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAlreadyMarked(seven)){
					singlePlayerGame.onClickSound();
					setText(seven);
					isGameOver();
				}
			}
		});
		seven.setBounds(115, 316, 95, 95);
		contentPane.add(seven);
		
	
		eight.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAlreadyMarked(eight)){
					singlePlayerGame.onClickSound();
					setText(eight);
					isGameOver();
				}
			}
		});
		eight.setBounds(207, 316, 95, 95);
		contentPane.add(eight);
		
		
		nine.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isAlreadyMarked(nine)){
					singlePlayerGame.onClickSound();
					setText(nine);
					isGameOver();
				}
			}
		});
		nine.setBounds(299, 316, 95, 95);
		contentPane.add(nine);
		
		
		player1NameLabel.setForeground(Color.WHITE);
		player1NameLabel.setFont(new Font("Marion", Font.BOLD, 20));
		player1NameLabel.setBounds(46, 493, 81, 27);
		player1NameLabel.setText(player1NameMultiPlayer);
		contentPane.add(player1NameLabel);
		
		player2NameLabel.setForeground(Color.WHITE);
		player2NameLabel.setFont(new Font("Marion", Font.BOLD, 20));
		player2NameLabel.setBounds(238, 493, 81, 27);
		player2NameLabel.setText(player2NameMultiPlayer);
		contentPane.add(player2NameLabel);
		
		player1ScoreLabel.setForeground(new Color(255, 255, 255));
		player1ScoreLabel.setFont(new Font("Arial Black", Font.PLAIN, 24));
		player1ScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		player1ScoreLabel.setBounds(124, 475, 42, 59);
		contentPane.add(player1ScoreLabel);
		
		
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
		restartGameBtn.setFocusPainted(false);
		
		restartGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restartGame();
			}
		});
		restartGameBtn.setBackground(Color.WHITE);
		restartGameBtn.setBounds(432, 423, 81, 49);
		contentPane.add(restartGameBtn);
		resetGameBtn.setFocusPainted(false);
		
		
		resetGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetGame();
			}
		});
		resetGameBtn.setBackground(Color.WHITE);
		resetGameBtn.setBounds(432, 469, 81, 49);
		
		contentPane.add(resetGameBtn);
		menuBtn.setFocusPainted(false);
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
		
		
		menuBtn.setBackground(Color.WHITE);
		menuBtn.setBounds(432, 516, 81, 49);
		contentPane.add(menuBtn);

	}
}
