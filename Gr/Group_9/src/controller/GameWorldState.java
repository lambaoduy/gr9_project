package controller;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Queue;

import model.Enemy;
import model.Ground;
import model.Human;
import model.MainPlayer;
import model.Obstruction;
import model.ObstructionGroup;
import view.GameFrame;
import view.MainPanel;

public class GameWorldState extends State {
	private BufferedImage bufferedImage;
	private MainPlayer mainPlayer;
	private ObstructionGroup enemys;
	private boolean isrunning=true;
	Ground ground;
	

	public GameWorldState(MainPanel gamePanel) {
		super(gamePanel);
		// TODO Auto-generated constructor stub
		
		ground = new Ground(0, 400, this);
		mainPlayer = new Human(200, 200, this);
		enemys= new ObstructionGroup(this);
		bufferedImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
//		ground.Update();
		if (isrunning) {
			Queue<Obstruction> list= enemys.getObstructions();
			for (Obstruction obstruction : list) {
				if (mainPlayer.getBoundForCollision().intersects(obstruction.getBoundForCollision())) {
					isrunning=false;
				}
			}
			enemys.run();
			mainPlayer.Update();
			enemys.Update();
			
		}
		enemys.stop();
		
	}

	@Override
	public void Render() {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) bufferedImage.getGraphics();
		g2.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
		ground.draw(g2);
		mainPlayer.draw(g2);
		enemys.paint(g2);
	}

	public MainPlayer getMainPlayer() {
		return mainPlayer;
	}

	public void setMainPlayer(MainPlayer mainPlayer) {
		this.mainPlayer = mainPlayer;
	}

	public int getGround() {
		return ground.getYGround();
	}

	public void setGround(Ground ground) {
		this.ground = ground;
	}

	@Override
	public BufferedImage getBufferedImage() {
		// TODO Auto-generated method stub
		return bufferedImage;
	}

	@Override
	public void setPressedButton(int code) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setReleasedButton(int code) {
		// TODO Auto-generated method stub

	}

}
