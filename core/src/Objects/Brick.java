package Objects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Brick {
    int x,y,width,height;
    public boolean destroyed = false;
    public Brick(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void draw(ShapeRenderer shape){
        shape.rect(x, y, width, height);
    }
}