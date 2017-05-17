package Controller;

import View.ObjectView.IViews;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.util.ArrayList;

/**
 * Created by Alex on 2017-05-15.
 */
public class OptionsController implements IController{



    //List that contains the views that this controller interacts with
    private ArrayList<IViews> viewSubscribers = new ArrayList<IViews>();

    //The handler that handles the switching of input processor
    private IHandler handler;

    //the enum that decides the typ of menu this is
    private final EnumIndexes typeOfMenu = EnumIndexes.OPTIONS_CONTOLLER;


    private String latestKey = " ";//init with blank
    public String latestKeyPressed()
    {
        //Used for debug
        return latestKey;
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


    public OptionsController(ArrayList<IViews> viewSubscribers, IHandler handler) {
        this.viewSubscribers = viewSubscribers;

        this.handler = handler;


    }
}