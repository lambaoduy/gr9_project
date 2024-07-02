package model;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

import javax.swing.RepaintManager;

import controller.GameWorldState;
import view.GameFrame;

public class ObstructionGroup {
	private GameWorldState gameWorldState ;

	private Queue<Obstruction> obstructions;

//	    private BufferedImage chimneyImage, chimneyImage2;

	public static int SIZE = 6;
	private static int x = GameFrame.SCREEN_WIDTH;
	private int flyY = 300;
	private int landY;

	public ObstructionGroup(GameWorldState gameWorldState) {
		// TODO Auto-generated constructor stub
		this.gameWorldState=gameWorldState;
		obstructions = new LinkedList<>();
		landY = gameWorldState.getGround();
		for (int i = 0; i < SIZE/2; i++) {
			int random = getRandomY();
			if ((i +random)%2 == 0) {
				Obstruction ob = new Enemy(i * 400 + x, flyY, gameWorldState);
				obstructions.add(ob);
			} else {
				Obstruction ob = new Enemy(i * 400 + x, landY, gameWorldState);
				obstructions.add(ob);
			}

		}
	}

	public int getRandomY() {
		Random random = new Random();
		int a;
		a = random.nextInt(10);

		return a;
	}

	public void paint(Graphics2D g2) {
//		        for(int i = 0;i < 6; i++) {
////		            if(i%2==0)
////		                g2.drawImage(chimneyImage, (int )chimneys.get(i).getPosX(), (int)chimneys.get(i).getPosY(), null);
////		            else g2.drawImage(chimneyImage2, (int )chimneys.get(i).getPosX(), (int)chimneys.get(i).getPosY(), null);
//		       
//		        }
		for (Obstruction obstruction : obstructions) {
			System.out.println(obstructions.size());
			obstruction.draw(g2);
		}
	}

	public void Update() {
		// TODO Auto-generated method stub
		for (Obstruction obstruction : obstructions) {
			obstruction.Update();
		}
		if (obstructions.peek().getPosX()< -74) {
			obstructions.poll();
			addNewbstructionO();
		}
		
	}

	private void addNewbstructionO() {
		// TODO Auto-generated method stub
		int random = getRandomY();
		if ((random)%2 == 0) {
			Obstruction ob = new Enemy(400 + x, flyY, this.gameWorldState);
			obstructions.add(ob);
		} else {
			Obstruction ob = new Enemy( 400 + x, landY, this.gameWorldState);
			obstructions.add(ob);
		}
	}

	public Queue<Obstruction> getObstructions() {
		return obstructions;
	}

	public void setObstructions(Queue<Obstruction> obstructions) {
		this.obstructions = obstructions;
	}

	public void stop() {
		// TODO Auto-generated method stub
		for (Obstruction obstruction : obstructions) {
			obstruction.setSpeed(0);
		}
	}
	public void run() {
		for (Obstruction obstruction : obstructions) {
			obstruction.setSpeed(-3);
		}
	}
	
}
