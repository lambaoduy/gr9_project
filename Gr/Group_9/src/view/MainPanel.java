package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.CacheDataLoader;
import controller.GameWorldState;
import controller.State;

public class MainPanel extends JPanel implements Runnable, KeyListener {
	Thread gameThread;
	InputManager input;
	State gameState;
	
	public boolean isRunning = true;

	public MainPanel() {
		// TODO Auto-generated constructor stub
		gameState = new GameWorldState(this);
		input = new InputManager(gameState);

	}

	public void startGame() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	int a = 0;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(gameState.getBufferedImage(), 0, 0, this);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long FPS = 80;// Frames – per – second, chỉ số khung hình trên mỗi giây
		long previousTime = System.nanoTime();// thời gian bắt đầu 1 period
		long currentTime;
		long sleepTime;// thời gian trống khi hoàn thành period
		long period = 1000000000 / FPS;

		while (isRunning) {
			gameState.Update();
			gameState.Render();
			repaint();

			currentTime = System.nanoTime();
			sleepTime = period - (currentTime - previousTime);

			try {

				if (sleepTime > 0)
					Thread.sleep(sleepTime / 1000000);
				else
					Thread.sleep(period / 2000000);

			} catch (Exception e) {
			}

			previousTime = System.nanoTime();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		input.processKeycode(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
