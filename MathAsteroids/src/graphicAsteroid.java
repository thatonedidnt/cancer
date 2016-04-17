import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class graphicAsteroid extends JPanel{
	private int height;
	private int laneX;
	private int radius;
	private int speed;
	private int answer;
	private boolean solved = false;
	private Asteroid getEq;
	private Timer Fall;
	private BufferedImage image;
	
	
	public graphicAsteroid(int lane, int size){
		height = 0;
		setXY(lane,size);
		answer = getEq.getAnswer();
		final ActionListener fall = new ActionListener(){
			public void actionPerformed (ActionEvent e){
				height+=speed;
				if(!solved){
					repaint();
				}
			}
		};
		Fall = new Timer(30,fall);
		Fall.start();
	}
	public void solve(){
		solved = true;
	}
	public boolean onScreen(){
		if(height<=770)
			return true;
		else
			return false;
	}
	public Asteroid getAsteroid(){
		return getEq;
	}
	public int getAnswer(){
		return getEq.getAnswer();
	}
	private void setXY(int lane, int size){
		if(lane == 1)
			laneX = 108;
		else if (lane == 2)
			laneX = 324;
		else if (lane ==3)
			laneX = 540;
		if(size == 1){
			radius = 20;
			getEq= new EasyAsteroid();
			speed = 3;
			try {
                image = ImageIO.read(new File("resources/smallasteroid.png"));
            } catch (IOException ex) {
                System.out.print("can't find pic");
            }

		}
		else if (size == 2){
			radius = 40;
			speed = 2;
			getEq= new MediumAsteroid();
			try {
                image = ImageIO.read(new File("resources/asteroid.png"));
            } catch (IOException ex) {
                System.out.print("can't find pic");
            }
			
		}
		else if (size == 3){
			radius = 80;
			speed = 1;
			getEq= new HardAsteroid();
			try {
                image = ImageIO.read(new File("resources/bigasteroid.png"));
            } catch (IOException ex) {
                System.out.print("can't find pic");
            }
		}
	}

	public void paint(Graphics g){
		super.paintComponent(g);
		//g.setColor(Color.green);
		//g.fillOval(laneX, height, radius, radius);
		g.drawImage(image, laneX, height, null);
		g.setColor(Color.WHITE);
		g.drawString(getEq.toString(), laneX, height);
	}
}
