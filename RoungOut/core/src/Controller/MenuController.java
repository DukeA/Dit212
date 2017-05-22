package Controller;

import IViews.IViews;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.ArrayList;

/**
 * Created by Alex on 2017-05-13.
 */
public class MenuController extends ClickListener implements IControllHandeling {

    ClickListener tmp = new ClickListener();
    //List that contains the views that this controller interacts with
    private ArrayList<IViews> viewSubscribers = new ArrayList<IViews>();

    //The handler that handles the switching of input processor
    private IHandler handler;

    //the enum that decides the typ of menu this is
    private final EnumIndexes typeOfMenu = EnumIndexes.MENU_CONTROLLER;


    private String latestKey = " ";//init with blank
    public String latestKeyPressed()
    {
        //Used for debug
        return latestKey;
    }
    public void clicked(InputEvent event, float x , float y) {

    }

    @Override
    public boolean keyDown(int keycode) {
        /**
         *  This will be called when a key is pressed down (keyboard) by libgdx's InputProcessor
         */
        latestKey = Input.Keys.toString(keycode);

        if (keycode== Input.Keys.ESCAPE){
            handler.callSetNewInput(EnumIndexes.GAME_CONTROLLER);
            //IF ESC -> Go back to the game
            updateAllViews();
        }

        return true;
    }

    //Helper method, code reuse
    private void updateAllViews() {
        //Call update to all views
        for (IViews view : viewSubscribers) {
            view.update(Gdx.graphics.getDeltaTime());
        }
    }

    @Override
    public void changeInputProcessor() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public EnumIndexes getTypeOfMenu(){ return typeOfMenu;}

    //We don't need these inputs
    @Override
    public boolean keyUp(int keycode) {
        return false;
    }
    @Override
    public boolean keyTyped(char character) { return false; }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) { return false; }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }
    @Override
    public boolean scrolled(int amount) {
        return false;
    }
    //End of these inputs


    public MenuController( IHandler handler) {

        this.handler = handler;


    }
    public MenuController() {

    }
}
