import java.awt.*;
import java.awt.color.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
public class Game implements ActionListener{
	private JFrame frame;
	private JLayeredPane lpane;
	private JPanel base;
	private Timer time;
	private int counter;
	private Ship ship;
	private JTextField text;
	private ArrayList<graphicAsteroid> Asteroids;
	private int typedAns;
	private int playerScore;
	private int playerHealth;
	private JLabel Score;
	private JLabel Health;
	public Game(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(650,770));
		frame.setResizable(false);
		lpane = new JLayeredPane();
		frame.add(lpane,BorderLayout.CENTER);
		
		
		base = new JPanel();
		base.setLayout(null);
		base.setBounds(0, 0, 800, 1000);
		base.setOpaque(true);
		base.setBackground(Color.black);
		lpane.add(base, new Integer(0),0);
		
		startGame();
		
		Score = new JLabel("Score: " + playerScore);
		Score.setForeground(Color.white);
		Score.setLocation(280, 10);
		Score.setSize(60, 14);
		base.add(Score);
		
		Health = new JLabel("Health: " + playerHealth);
		Health.setForeground(Color.white);
		Health.setLocation(280, 30);
		Health.setSize(90, 30);
		base.add(Health);
		
		
		
		
		text = new JTextField(20);
		text.setBounds(10,10,50,50);
	    text.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	String ans = text.getText();
	        	typedAns = Integer.parseInt(ans);
	        	System.out.println("My answer:" + typedAns);
	    		for(int i = 0;i< Asteroids.size();i++){
	    			if(typedAns == Asteroids.get(i).getAnswer()){
	    				playerScore+= Asteroids.get(i).getAsteroid().getPoints();
	    				Score.setText("Score: " + playerScore);
	    				Asteroids.get(i).solve();
	    				Asteroids.remove(i);
	    				i--;	
	    			}
	    		}
		    	text.setText("");
	        }
	      });
		base.add(text);
		
		

		frame.addKeyListener(ship);
		frame.pack();
		frame.setVisible(true);
	}
	private void startGame(){
		Asteroids = new ArrayList<graphicAsteroid>();
		counter = 0;
		time = new Timer(10,this);
		time.start();
		playerScore = 0;
		playerHealth = 100;

	}
	
	private void createAsteroids(){
		int lane = (int) (Math.random()*3+1);
		int size = (int) (Math.random()*100 + 1);
		
		if(size>=0 && size<50)
			size=1;
		else if(size>=50 && size<80)
			size=2;
		else if(size>=80)
			size=3;
		
		graphicAsteroid As = new graphicAsteroid(lane,size);
		As.setBounds(0,0,650,770);
		As.setOpaque(false);
		Asteroids.add(As);
		lpane.add(Asteroids.get(Asteroids.size()-1),new Integer(1),0);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		counter++;
		if(counter%150 == 0)
			createAsteroids();
		for(int i = 0;i<Asteroids.size();i++){
			if(!Asteroids.get(i).onScreen()){
				Asteroids.remove(i);
				i--;
				playerHealth-=10;
				Health.setText("Health: " + playerHealth);
				if(playerHealth == 0){
					System.exit(1);
				}
				System.out.println("hit \t Player Health: " + playerHealth);
			}
		}
	}
	public static void main (String args[]){
		new Game();
	}
}
