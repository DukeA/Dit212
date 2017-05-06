package View.ObjectView;

import Model.GameObjects.Brick;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

/**
 * Created by DukeA on 2017-05-06.
 */
public class BrickView  {


    private int WIDTH;
    private int HEIGHT;
    private ShapeRenderer shapeRenderer;
    private ArrayList<Integer> bricks;



    public BrickView(int Width, int Height, ShapeRenderer renderer) {
        this.WIDTH = Width;
        this.HEIGHT = Height;
        this.shapeRenderer = renderer;
    }

    public void render(float delta) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.LIGHT_GRAY);
        //shapeRenderer.rect();
    }
    public void dispose() {
        shapeRenderer.dispose();
    }
    public void resize(int width, int HEIGHT) {

    }


}