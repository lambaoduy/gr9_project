package view;

import java.awt.event.KeyEvent;

import controller.GameWorldState;
import controller.State;

public class InputManager {
	GameWorldState world;

	public InputManager(State world) {
		super();
		this.world = (GameWorldState) world;
	}

	public void processKeycode(int keycode) {
		switch (keycode) {
		case KeyEvent.VK_SPACE:
			world.getMainPlayer().jump();;

			break;

		}
	}

}
