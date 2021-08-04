package Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Table {
	float x;
	float y;
	float z;
	float ancho;
	float alto;
	float profundo;
	
	
	public Table(float x,float y,float z,float ancho,float alto,float profundo) {
		this.x= x;
		this.y= y;
		this.z= z;
		this.ancho= ancho;
		this.alto= alto;
		this.profundo = profundo;
	}
	  public void update(){
	        this.x = (Gdx.input.getX() );
	    }
	
	public void draw(ShapeRenderer shape) {
        shape.box(x, y, z, ancho, alto, profundo);
    }
}
