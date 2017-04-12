import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class Movie2 extends JFrame implements KeyListener, ActionListener {
	public void actionPerformed(ActionEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	System.out.println("KEY TYPED: " + e.getID());
	}
	public void keyPressed1(KeyEvent e) {
	System.out.println("KEY PRESSED: " + e.getID());
	}
	public void keyReleased(KeyEvent e) {
	System.out.println("KEY RELEASED: " + e.getID());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animation first = new Animation(1920, 1080);

		first.addKeyListener(first);

		Sprite sp1 = new Sprite("sprite1t2.png");
		sp1.setPosition(1000,0);

		Sprite sp2 = new Sprite("g3457.png");
		sp2.setPosition(100,0);

		//Sprite sp3 = new Sprite("");
		Sprite sp4 = new Sprite("shot.png");
		first.setFrameRate(1000);


		first.setBackgroundImage("background.png");
		first.addSprite(sp1);
		first.addSprite(sp2);
		//first.addSprite(sp3);
		first.addSprite(sp4);
		first.frameFinished();
		sp4.setSize(50, 15);
		
		
	
		
		boolean posSet=false;
		//first.keyTyped(e);
		int q=0;
		int y=0;
		int x=999;
		int z=0;

		
		while(y<1860){
			sp1.setPosition(x,0);
			sp2.setPosition(z,0);
			y++;
			x--;
			z++;
			
			if(z==100){
				sp4.setPosition(z+300, 220);
				posSet=true;
				q=z+300;
			}
			if(posSet==true){
				q+=5;
				sp4.setPosition(q, 220);
			}
			if(q>x+126){
				first.removeSprite(sp1);
				first.removeSprite(sp4);
				x=1000;
			}
			if(z>x-170){
				first.removeSprite(sp1);
				first.removeSprite(sp2);
			}
			first.frameFinished();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyPressed11(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyReleased1(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped1(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	}


