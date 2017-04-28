package Model.GameObjects;

import java.util.ArrayList;

/**
 * Created by DukeA on 2017-04-04.
 * Modified by Alex on 2017-04-24
 */
public class Player {
    private Pad pad;
    private float PadLength = 30; //default value
    private float PadWidth = 20; //default value
    private int points;

    public Player(){
        pad = new Pad(PadLength,PadWidth,0,0,0);
        points = 0;
    }

    //Overloaded with specific parameters, points allways starts at 0
    public Player(float PadL, float PadW, double PadXPos, double PadYPos, float PadSpeed){
        pad = new Pad(PadL,PadW,PadXPos,PadYPos,PadSpeed);
        points = 0;
    }

    public void setPadCoordinates(float x, float y) {
      pad.setPadXPos(x);
      pad.setPadYPos(y);
    }
    public ArrayList<Double> getPadCoordinates() {
        ArrayList<Double> coordinateList = new ArrayList<Double>();
        coordinateList.add(0,pad.getPadXPos());
        coordinateList.add(1,pad.getPadYPos());
        return coordinateList;
    }
    public Pad getPad() {
        return this.pad;
    }

    public void movePad() {
       //  this.pad.PadMove(pad.getPadXPos()+pad.getPadSpeed(),pad.getPadYPos()+pad.getPadSpeed());
        this.pad.padMove();
    }



    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void offsetPoints() {points = points +1;} //increment by 1

    public void offsetPoints(int value) {points = points + value;} //offsets by a given value

    public void setPad(Pad pad) {
        this.pad = pad;
    }

}