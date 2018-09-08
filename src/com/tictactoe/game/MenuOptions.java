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
import javax.swing.border.LineBorder;

public class MenuOptions extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String playerNameSinglePlayer;
	String player1NameMultiPlayer;
	String player2NameMultiPlayer;
	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
//		frame.setTitle("Menu");
//		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public MenuOptions() {
		frame = this;
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 451, 434);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTicTacToe = new JLabel("Tic Tac Toe");
		lblTicTacToe.setOpaque(true);
		lblTicTacToe.setForeground(Color.WHITE);
		lblTicTacToe.setBackground(Color.RED);
		lblTicTacToe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTicTacToe.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblTicTacToe.setBounds(0, 0, 451, 72);
		contentPane.add(lblTicTacToe);
		
		JButton btnVsCpu = new JButton("Single Player");
		btnVsCpu.setFocusPainted(false);
		btnVsCpu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerNameSinglePlayer = JOptionPane.showInputDialog("Enter player name : ");
				frame.setVisible(false);
				frame.dispose();
				SinglePlayerGame singlePlayerGame = new SinglePlayerGame(playerNameSinglePlayer);
				singlePlayerGame.setVisible(true);
//				SinglePlayerGame.main(null);
			}
		});
		btnVsCpu.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnVsCpu.setBackground(Color.WHITE);
		btnVsCpu.setBounds(163, 163, 130, 47);
		contentPane.add(btnVsCpu);
		
		JButton btnPlayers = new JButton("MultiPlayer");
		btnPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player1NameMultiPlayer = JOptionPane.showInputDialog("Enter player1 name : ");
				player2NameMultiPlayer = JOptionPane.showInputDialog("Enter player2 name : ");
				frame.setVisible(false);
				frame.dispose();
				MultiPlayerGame multiPlayerGame = new MultiPlayerGame(player1NameMultiPlayer,player2NameMultiPlayer);
				multiPlayerGame.setVisible(true);
			}
		});
		btnPlayers.setFocusPainted(false);
		btnPlayers.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnPlayers.setBackground(Color.WHITE);
		btnPlayers.setBounds(163, 229, 130, 47);
		contentPane.add(btnPlayers);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dailougeButton = JOptionPane.YES_NO_OPTION;
				int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?","Message",dailougeButton);
				if(result == JOptionPane.YES_OPTION){
					System.exit(0);	
				}
			}
		});
		btnExit.setFocusPainted(false);
		btnExit.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(163, 322, 130, 47);
		contentPane.add(btnExit);
	}
}
