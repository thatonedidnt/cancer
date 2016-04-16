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
	private ArrayList<graphicAsteroid> Asteroids;
	public Game(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(650,770));
		frame.setResizable(false);
		lpane = new JLayeredPane();
		frame.add(lpane,BorderLayout.CENTER);
		
		
		base = new JPanel();
		base.setBounds(0, 0, 800, 1000);
		base.setOpaque(true);
		base.setBackground(Color.black);
		lpane.add(base, new Integer(0),0);
		
		ship = new Ship();
		ship.setBounds(0,0,650,770);
		ship.setOpaque(false);
		lpane.add(ship, new Integer(1),0);
		
		startGame();
		frame.addKeyListener(ship);
		frame.pack();
		frame.setVisible(true);
	}
	private void startGame(){
		Asteroids = new ArrayList<graphicAsteroid>();
		counter = 0;
		time = new Timer(10,this);
		time.start();

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
	}
	public static void main (String args[]){
		new Game();
	}
}
