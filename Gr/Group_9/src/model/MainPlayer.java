package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import controller.GameWorldState;
import controller.State;

public abstract class MainPlayer extends GameObject {
	private boolean isJumping;
	private boolean isLanding;

	private float mass = 0.1f;
	private float speedX = 0;
	private float speedY = 0;

	public boolean isLanding() {
		return isLanding;
	}

	public void setLanding(boolean isLanding) {
		this.isLanding = isLanding;
	}

	public MainPlayer(float posX, float posY, GameWorldState gameWorldState) {
		super(posY, posY, gameWorldState);

	}

	public boolean isJumping() {
		return isJumping;
	}

	public void setJumping(boolean isJumping) {
		this.isJumping = isJumping;
	}

	public abstract float getWidth();

	public abstract void setWidth(float width);

	public abstract float getHeight();

	public abstract void setHeight(float height);

	public float getMass() {
		return mass;
	}

	public void setMass(float mass) {
		this.mass = mass;
	}

	public float getSpeedX() {
		return speedX;
	}

	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}

	public float getSpeedY() {
		return speedY;
	}

	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}

	public void Update() {
		Rectangle rec = getBoundForCollision();
		setPosX(getPosX() + speedX);
		setPosY(getPosY() + getSpeedY());
		int land = (int) (getGameWorld().getGround() - getHeight() / 2);
		if (speedY != 0) {
			setLanding(true);
		}
		if (isLanding = true) {
			setSpeedY(getSpeedY() + mass);
		}

		if (getPosY() > land && getSpeedY() != 0) {
			setJumping(false);
			setSpeedY(0);
			setPosY(land);
			setLanding(false);
		}
	}


	public Rectangle getBoundForCollision() {
		// TODO Auto-generated method stub
		Rectangle bound = new Rectangle();
		bound.x = (int) (getPosX() - (getWidth() / 2));
		bound.y = (int) (getPosY() - (getHeight() / 2));
		bound.width = (int) getWidth();
		bound.height = (int) getHeight();
		return bound;
	}

	public void draw(Graphics2D g2) {
//		System.out.println(getPosX());
		drawBoundForCollision(g2);

	}

	public void jump() {

		if (!isJumping()) {
			setJumping(true);
			setSpeedY(-5.0f);
		}
	}

	public void stopRun() {
		setSpeedX(0);

	}

	public void drawBoundForCollision(Graphics2D g2) {
		Rectangle rect = getBoundForCollision();
		g2.setColor(Color.BLUE);
		g2.drawRect(rect.x ,rect.y,
				rect.width, rect.height);
	}


}
