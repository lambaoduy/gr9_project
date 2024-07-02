package model;

import controller.GameWorldState;

public class Human extends MainPlayer {
	private float width = 30;
	private float height = 30;

	public Human(float posX, float posY, GameWorldState gameWorldState) {
		super(posX, posY, gameWorldState);
		// TODO Auto-generated constructor stub
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

}
