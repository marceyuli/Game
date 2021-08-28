package Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Table extends Actor{
	private Texture table;
	public Rectangle tableRect;
	
	
	public Table(Texture table) {
		this.table = table;
		setSize(table.getWidth(), table.getHeight());
		this.tableRect = new Rectangle(getX(), getY(), getWidth(), getHeight());
		
	}
	
	@Override
	public void act(float delta) {
		int maxX = (int) (Gdx.graphics.getWidth() - table.getWidth());
		
		super.act(delta);
		
		tableRect.setX(getX());
		tableRect.setY(getY());
		
		if(getX() > maxX){
	        setX(maxX);}
		
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(table, getX(), getY());
	}
	
	public void move(float x) {
		
		setX(x);
	}
	
}
