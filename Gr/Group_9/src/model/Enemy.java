package model;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import controller.GameWorldState;
import controller.State;

public class Enemy extends Obstruction {
	private int width = 30;
	private int height = 30;
	private Rectangle rect;

	public Enemy(float posX, float posY, GameWorldState gameWorldState) {
		super(posX, posY, gameWorldState);
		rect = new Rectangle((int) posX, (int) posY, width, height);
	}

	public Rectangle getRect() {
		return rect;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
