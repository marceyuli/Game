package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import Objects.Ball;
import Objects.Brick;
import Objects.Table;

import com.badlogic.gdx.graphics.GL20;

public class MyGdxGame extends ApplicationAdapter {
    ShapeRenderer shape;
    Ball ball;
    Table table;
    ArrayList<Brick> bricks = new ArrayList<>();

    @Override
    public void create () {
        shape = new ShapeRenderer();
        ball = new Ball(150, 200, 20, 5, 5);
        table = new Table(5,5,0,50,10,5);
        int blockWidth = 63;
        int blockHeight = 20;
        
        for (int y = Gdx.graphics.getHeight()/2; y < Gdx.graphics.getHeight(); y += blockHeight + 10) {
            for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
            	bricks.add(new Brick(x, y, blockWidth, blockHeight));
            }
        }
    }

    @Override
    public void render() {
    	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	
        ball.update();
        table.update();
        ball.checkCollision(table);
        
        shape.begin(ShapeRenderer.ShapeType.Filled);
        ball.draw(shape);
        table.draw(shape);
        for (Brick brick : bricks) {
        	brick.draw(shape);
        	ball.checkCollision(brick);
        }
        for (int i = 0; i < bricks.size(); i++) {
			Brick b = bricks.get(i);
			if (b.destroyed) {
				bricks.remove(b);
				// we need to decrement i when a ball gets removed, otherwise we skip a block!
				i--;
			}
		}
        
        shape.end();
    }
}