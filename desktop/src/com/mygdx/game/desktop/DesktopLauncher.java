package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "HelloWorld";
		config.width = 700;
		config.height = 400;
		new LwjglApplication(new MainGame(), config);
	//new LwjglApplication(new MyGdxGame(), config);

	}
}
