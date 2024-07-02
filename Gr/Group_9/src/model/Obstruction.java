package model;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import controller.GameWorldState;

public abstract class Obstruction extends GameObject {
	private int speed;
	private GameWorldState gameWorldState;

	public Obstruction(float x, float y, GameWorldState gameWorld) {
		super(x, y, gameWorld);
		// TODO Auto-generated constructor stub
		this.gameWorldState=gameWorld;
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		int posX = (int) getPosX();
		setPosX(posX +speed);

	}

	public void draw(Graphics2D g2) {

//		g2.fillRect((int) getPosX(), (int) getRect().y - getHeight(), (int) getRect().getWidth(),
//				(int) getRect().getHeight());
		Rectangle rect = getBoundForCollision();
		g2.fillRect(rect.x, rect.y, rect.width, rect.height);
	}

	public abstract int getWidth();

	public abstract void setWidth(int width);

	public abstract int getHeight();

	public abstract void setHeight(int height);

	public abstract Rectangle getRect();

	public Rectangle getBoundForCollision() {
		// TODO Auto-generated method stub
		Rectangle bound = new Rectangle();
		bound.x=(int) getPosX();
		bound.width=getWidth();
		bound.height=getHeight();
		if ( getPosY()>=this.getGameWorld().getGround()) {
			bound.y=this.gameWorldState.getGround()-getHeight();
		}else {
			bound.y=(int) getPosY();
		}
		
		return bound;
	}
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
