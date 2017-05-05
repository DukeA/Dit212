package View.ObjectView;

import Model.GameObjects.Ball;
import Model.GameObjects.IBall;
import Model.GameObjects.Physics.CircleBody;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by DukeA on 2017-04-28.
 */
public class BallView implements  IBall {

    private Ball ball;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private int WIDTH;
    private int HEIGHT;
    private float xBall;
    private float yBall;

    public BallView(int WIDTH, int HEIGHT,SpriteBatch batch, ShapeRenderer renderer) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.batch = batch;
        this.shapeRenderer = renderer;
        ball = getball();
    }

    public void render(float delta) {
        this.update(delta);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.ellipse((float)ball.getX()
                ,(float) ball.getY()
                ,(float)ball.getRadius() *((WIDTH/4)/(HEIGHT/4))
                ,(float)ball.getRadius()*((WIDTH/4)/(HEIGHT/4)));
        shapeRenderer.end();

    }


    public void update(float delta) {
        ball.setY(ball.getY()+ball.getSpeed()+ball.getAngle());
        ball.setX(ball.getX()+ball.getSpeed()+ball.getAngle());
    }

    public void reSize(int width, int height) {

    }
    public void dispose() {
        shapeRenderer.dispose();
    }
    @Override
    public Ball getball() {
        return new Ball(WIDTH / 2, HEIGHT / 2, 30f, 1, 1);
    }
}
