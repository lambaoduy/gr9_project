package view;

import java.io.IOException;

import javax.swing.JFrame;

import controller.CacheDataLoader;



public class GameFrame extends JFrame {
	MainPanel mainpanel;
	public static final int SCREEN_WIDTH=800;
	public static final int SCREEN_HEIGHT=600;

	public GameFrame() {
		try {
			CacheDataLoader.getInstance().LoadData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainpanel = new MainPanel();
		add(mainpanel);
		mainpanel.startGame();
		setSize(800, 600);
		setLocationRelativeTo(null);
		addKeyListener(mainpanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		GameFrame game = new GameFrame();
//		System.out.println((CacheDataLoader.getInstance().LoadAnimation());
	}
}
