package Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

public class Wall extends Actor {
	private Array<Brick> listaLadrillos;
	private Texture brickTexture;
	private int width;
	private int height;
	private Brick brick;
	
	public Wall(Texture textureBrick) {
		listaLadrillos = new Array<Brick>();
		brickTexture = textureBrick;
		width = brickTexture.getWidth();
		height = brickTexture.getHeight();
		cargarLadrillos();
}
	
	
	public Array<Brick> getListaLadrillos() {
		return listaLadrillos;
	}


	public void cargarLadrillos() {
	        
	        for (int y = Gdx.graphics.getHeight()/2; y < Gdx.graphics.getHeight(); y +=height  + 10) {
	            for (int x = 0; x < Gdx.graphics.getWidth(); x += width + 10) {
	            	brick = new Brick(brickTexture);
	            	
	            	brick.setBounds(x, y, width, height);
	            	brick.brickRect.setPosition(brick.getX(), brick.getY());
	            	brick.brickRect.setWidth(brick.getWidth());
	            	brick.brickRect.setHeight(brick.getHeight());
	            	listaLadrillos.add(brick);
	            	
	            }
	        }
	}
	
	public void eliminarLadrillo(int indice) {
		
	}
	
	public void draw(Batch batch, float parentAlpha) {
		  for (Brick brick : listaLadrillos) {
			  batch.draw(brickTexture, brick.getX(), brick.getY());
	        }
	}
	
	public boolean isEmpty() {
		if(!listaLadrillos.isEmpty()) {
			return false;
		}
		return true;
	}

	
}

