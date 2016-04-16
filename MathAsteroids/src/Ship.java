import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Ship extends JPanel implements KeyListener{
	private int currentLane;
	private int laneX;
	public Ship(){
		currentLane = 2;
		setLaneX(currentLane);
		repaint();
		addKeyListener(this);
	}
	private void setLaneX(int lane){
		if(lane == 1)
			laneX = 108;
		else if (lane == 2)
			laneX = 324;
		else if (lane ==3)
			laneX = 540;
	}
	public void paint(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(laneX, 650, 50, 50);
	}

	@Override
	public void keyPressed(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    switch(keyCode) { 
	        case 37:
	            currentLane--;
	            setLaneX(currentLane);
	            repaint();
	            break;
	        case 39:
	            currentLane++;
	            setLaneX(currentLane);
	            repaint();
	            break; 	
	     }
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
