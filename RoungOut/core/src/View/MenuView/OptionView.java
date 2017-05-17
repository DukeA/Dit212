package View.MenuView;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by DukeA on 2017-05-05.
 */
public class OptionView implements Screen {

    private int WIDTH;
    private int HEIGHT;
    private SpriteBatch batch;
    private Window resArea;
    private Window muteArea;
    private Window keyArea;
    private Skin skin;
    private Table table;
    private Label label;
    private Stage stage;
    private BitmapFont font;
    private Game game;

    private CheckBox[] box;
    private CheckBox[] muteBox;

    public OptionView(int WIDTH, int HEIGHT , Game game) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.game = game;
        this.skin = new Skin(Gdx.files.internal("uiskin.json"));
        font = new BitmapFont();
        stage = new Stage();
        batch = new SpriteBatch();

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        table = new Table();
        table.setFillParent(true);
        table.top();
        resArea = new Window("Resolution",skin);
        muteArea = new Window("Mute",skin);
        keyArea = new Window("Key Change",skin);
        box = new CheckBox [3];
        muteBox = new CheckBox[2];
        label = new Label("Options",skin);


        table.add(label).padTop(150);
        label.setFontScale(4);
        label.setEllipsis(true);
        table.row();
        table.add(resArea).padTop(100).width(400).height(100);
        resArea.setMovable(false);
        keyArea.setMovable(false);
        muteArea.setMovable(false);
        for (int i =0; i<box.length; i++) {
            box[i] = new CheckBox("",skin);
            resArea.add(box[i]);
        }
        box[0].setText("1980 X 1080");
        box[0].addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){

            }
        });


        box[1].setText("720 X 420");
        box[1].addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){

            }
        });

        box[2].setText("1280 X 720");
        box[2].addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){

            }
        });


        table.row();
        table.add(muteArea).width(400).height(100);
        muteArea.add(muteBox);
        for (int i =0; i<muteBox.length; i++) {
            muteBox[i] = new CheckBox("",skin);
            muteArea.add(muteBox[i]);
        }
        muteBox[0].setText("Yes");
        muteBox[0].addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){

            }
        });


        muteBox[1].setText("No");
        muteBox[1].addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){

            }
        });





        table.row();
        table.add(keyArea).width(400).height(100);
        stage.addActor(table);




    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f,0f,0f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch = new SpriteBatch();

        batch.begin();
        stage.act();
        stage.draw();
        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
