package managers;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import Objects.Table;

public class PlayerManager extends  InputAdapter {
	
	private Table table;

	
	public PlayerManager(Table table) {
		super();
		this.table = table;
	}


	@Override
	public boolean mouseMoved(int screenX, int screenY) {
//		if(table.getX() + table.getWidth() > Gdx.graphics.getWidth()) {
	//		table.move(Gdx.graphics.getWidth() - table.getWidth() );
		//	return true;
		//}
		this.table.move(screenX);
		return true;
	}

	
	
	



}
