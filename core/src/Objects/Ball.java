package Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Ball extends Actor {
	
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;
    private int leftLimit;
    private int rightLimit;
    private int topLimit;
    private int bottomLimit;
    Color color = Color.WHITE;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public void update() {
        x += xSpeed;
        y += ySpeed;
        if (x - size < 0 || x + size > Gdx.graphics.getWidth()) {
            xSpeed = -xSpeed;
        }
        if (y - size < 0 || (y + size) > Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }
    }
    public void draw(ShapeRenderer shape) {
        shape.circle(x, y, size);
        shape.setColor(color);
        shape.circle(x, y, size);
    }
    public void checkCollision(Table table) {
    	if (collidesWith(table)) {
            this.ySpeed = -this.ySpeed;
        }
    }
    public void checkCollision(Brick brick){
        if (collidesWith(brick)) {
            this.ySpeed = -this.ySpeed;
            brick.destroyed = true;
        }
    }
    private boolean collidesWith(Table table) {
    	if ((x-size <= table.x+table.ancho) && (table.x+table.ancho <= (x + size) + table.ancho) &&
                (y + size >= table.y - table.alto) && ((table.y - table.alto) >= ((y - size) - table.alto))) {
            return true;
        } else {
            return false;
        }
    }
  
    private boolean collidesWith(Brick brick){
        if ((x-size <= brick.x+brick.width) &&(brick.x+brick.width <= x+size + brick.width) &&
        		y + size >= brick.y && brick.y >= y - size - brick.height) {
            return true;
        } else {
            return false;
        }
    }
}
