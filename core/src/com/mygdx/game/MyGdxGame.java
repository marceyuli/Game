package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import Objects.Ball;

import com.badlogic.gdx.graphics.GL20;

public class MyGdxGame extends ApplicationAdapter {
    ShapeRenderer shape;
    Ball ball;

    @Override
    public void create () {
        shape = new ShapeRenderer();
        ball = new Ball(150, 200, 80, 5, 5);
    }

    @Override
    public void render() {
    	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        ball.update();
        shape.begin(ShapeRenderer.ShapeType.Filled);
        ball.draw(shape);
        shape.end();
    }
}