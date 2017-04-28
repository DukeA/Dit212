package Model.GameObjects;


/**
 * Created by Alex on 2017-04-01.
 */
public class Pad {

    //Variables for objects
    private float length;
    private float width;
    private double padXPos;
    private double padYPos;
    private float padSpeed;

    //Getters
    public float getLength() {
        return length;
    }
    public float getWidth() {
        return width;
    }
    public double getPadXPos() {
        return padXPos;
    }
    public double getPadYPos() {
        return padYPos;
    }
    public float getPadSpeed() {
        return padSpeed;
    }

    //Setters
    public void setPadXPos(double padXPos) {
        this.padXPos = padXPos;
    }
    public void setPadYPos(double padYPos) {
        this.padYPos = padYPos;
    }
    public void setSpeed(float speed) {
        this.padSpeed = speed;
    }

    //Constructor
    public Pad(float length, float width, double padXPos, double padYPos,float padSpeed) {
        this.length = length;
        this.width = width;
        this.padXPos = padXPos;
        this.padYPos = padYPos;
        this.padSpeed = padSpeed;
    }

    //Method: Moves by incrementing the x and y pos with it's speed
    public void padMove(){
        padXPos = padXPos + padSpeed;
        padYPos = padYPos + padSpeed;
    }

    //Overloaded Method: This simply sets the X and Y pos to the given values
    public void padMove(double xPos, double yPos) {
        setPadXPos(xPos);
        setPadYPos(yPos);
    }


}