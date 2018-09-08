package com.tictactoe.game;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import jaco.mp3.player.MP3Player;

public class SplashScreen extends JWindow {

	/**
	 * The {@code SplashScreen} is the intro screen for Tic Tac Toe game.
	 * @since 4 July 2018
	 * @author sanjay
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	MP3Player player;
	JProgressBar progressBar = new JProgressBar();
	private static int counter;
	private static SplashScreen frame;
	Timer timer;
	
	/**
	 * {@code playMusic} method performs playing background music for the intro screen.
	 * @param null
	 */
	public void playMusic(){
		player = new MP3Player();
		player.addToPlayList(SplashScreen.class.getResource("introShort.mp3"));
		player.play();
	}
	
	/**
	 * {@code stopMusic} method stops background music for the intro screen.
	 * @param null
	 */
	public void stopMusic(){
		if(player != null){
			player.stop();
		}
	}
	
	/**
	 * {@code animation} method creates an object of {@code Timer} class that updates {@code ProgressBar} value with time.
	 * @param null
	 */
	public void animation(){
		timer = new Timer(51,(e)->{
			if(counter>100){
				stopMusic();
				frame.setVisible(false);
				frame.dispose();
				MenuOptions menuOptions = new MenuOptions();
				menuOptions.setTitle("Menu");
				menuOptions.setLocationRelativeTo(null);
				menuOptions.setVisible(true);
				timer.stop();
			
			}
			progressBar.setValue(counter);
			counter++;	
		});
		timer.start();
	}
	
	/**
	 * {@code main} method is the entry point for the {@code SplashScreen} class.
	 * @param String[]
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SplashScreen();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SplashScreen() {
		setBounds(100, 100, 546, 349);
		animation();
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		playMusic();
		
		JLabel copyrightLabel = new JLabel("Copyright \u00a9 Sanjay 2018");
		copyrightLabel.setOpaque(true);
		copyrightLabel.setBackground(Color.DARK_GRAY);
		copyrightLabel.setForeground(Color.WHITE);
		copyrightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		copyrightLabel.setBounds(0, 320, 548, 29);
		contentPane.add(copyrightLabel);
		
		progressBar.setStringPainted(true);
		progressBar.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
//		UIManager.put("progressBar.background", Color.ORANGE);
//		UIManager.put("progressBar.foreground", Color.BLUE);
//		UIManager.put("progressBar.selectionBackground", Color.RED);
//		UIManager.put("progressBar.selectionForeground", Color.GREEN);
		progressBar.setBounds(0, 300, 556, 20);
		contentPane.add(progressBar);
		
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(SplashScreen.class.getResource("splashScreenImage.png")));
		label.setBounds(0, 0, 548, 300);
		contentPane.add(label);
	}
}
