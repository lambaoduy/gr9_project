package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import controller.CacheDataLoader;
import controller.GameWorldState;
import view.GameFrame;

public class Ground extends GameObject {
	int x2, y2;

	public Ground(float x1, float y1, GameWorldState gameWorld) {
		super(x1, y1, gameWorld);
		x2 = (int) (x1 + GameFrame.SCREEN_WIDTH);
		y2 = (int) (GameFrame.SCREEN_HEIGHT - y1);
	}

	public void Update() {
		
	}

	public int getYGround() {
		return (int) getPosY();
	}

	public void draw(Graphics2D g2) {

		g2.setColor(Color.gray);

		g2.fillRect(0 , (int) getPosY() , x2, y2);

	}

}
