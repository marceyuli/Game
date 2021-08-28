package com.mygdx.game;

import com.badlogic.gdx.Game;

import Screens.GameOverScreen;
import Screens.MainGameScreen;
import Screens.MenuScreen;

public class MainGame extends Game{
	public MainGameScreen mainGameScreen;
	public MenuScreen menuScreen;
	public GameOverScreen gameOverScreen;
	@Override
	public void create() {
		
		mainGameScreen = new MainGameScreen(this);
		gameOverScreen = new GameOverScreen(this);
		menuScreen = new MenuScreen(this);
		
		setScreen(menuScreen);
	}

}
