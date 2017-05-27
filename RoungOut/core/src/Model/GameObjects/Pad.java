package Model.GameObjects;
import Model.GameObjects.Physics.Body;
import Model.GameObjects.Physics.RectangleBody;


/**
 * @author Alex
 * Created on 2017-04-01.
 * @author Adam
 * Heavly modified on 2017-05-21
 */
public class Pad {

    private RectangleBody body;
    private float originX;
    private float originY;

    //Completly revamped, barely needed since a body is a pad

    /**
     * Getters for
     * X-Origin
     * Y-Origin (X&Y Origin is the point the pad rotates around)
     * Length (Reality Height, relic from first weeks of project)
     * Width
     * X-Position
     * Y-Position
     * Speed
     * Angle (Angle of direction)
     * Body
     */
    public float getOriginX(){
        return originX;
    }
    public float getOriginY() {
        return  originY;
    }
    public float getLength() {
        return body.getHeight();
    }

    public float getWidth() {
        return body.getWidth();
    }

    public float getPadXPos() {
        return body.getX();
    }

    public float getPadYPos() {
        return body.getY();
    }

    public float getPadSpeed() {
        return body.getSpeed();
    }

    public float getAngle(){return body.getDirection();}

    public Body getBody() {
        return body;
    }

    /**Setters(mainly used in testing) exists for:
     * X-Position
     * Y-Position
     * Speed
     */
    public void setPadXPos(float padXPos) {
        body.setX(padXPos);
    }

    public void setPadYPos(float padYPos) {
        body.setY(padYPos);
    }

    public void setSpeed(float speed) {
        body.setSpeed(speed);
    }

    /**
     * Constructor
     * @param length Length of the pad
     * @param width Width of the pad
     * @param originX X-Position of the point to circles around
     * @param originY Y-Position of the point to circles around
     * @param padXPos X-Position of the pad
     * @param padYPos Y-Position of the pad
     * @param padSpeed Speed of the pad
     */
    public Pad(float length, float width, float originX, float originY, float padXPos, float padYPos, float padSpeed) {
        this.body = new RectangleBody(padXPos, padYPos, width, length);
        this.body.setSpeed(padSpeed);
        this.originY = originY;
        this.originX =originX;
        this.body.setDirection(0);
    }

    /**
     * Moves left by incrementing the x and y pos with it's speed
     *
     */
    public void padMoveLeft() {

        float x = body.getX();
        float y = body.getY();


        //float angle = (float)Math.acos();

        double rot = -1.0/180.0*Math.PI;
        double cs = Math.cos(rot);
        double sn = Math.sin(rot);

        double translated_x = x - originX;
        double translated_y = y - originY;

        double result_x = translated_x * cs - translated_y * sn;
        double result_y = translated_x * sn + translated_y * cs;

        result_x += originX;
        result_y += originY;



        body.setX((float)result_x);
        //padXPos = padXPos + padSpeed;
        body.setY((float)result_y);


    }

    /**
     * Moves right by incrementing the x and y pos with it's speed
     */
    public void padMoveRight() {
        //float x = body.getX()-originX;
        //float y = body.getY()-originY;

        float x = body.getX();
        float y = body.getY();

        //float angle = (float)Math.acos();

        double rot = 1.0/180.0*Math.PI;
        double cs = Math.cos(rot);
        double sn = Math.sin(rot);

        double translated_x = x - originX;
        double translated_y = y - originY;

        double result_x = translated_x * cs - translated_y * sn;
        double result_y = translated_x * sn + translated_y * cs;

        result_x += originX;
        result_y += originY;


        body.setX((float)result_x);
        //padXPos = padXPos + padSpeed;
        body.setY((float)result_y);
        //padYPos = padYPos + padSpeed;
    }

    //Overloaded Method: This simply sets the X and Y pos to the given values

    /**
     * Sets the X&Y Position (name is a relic from early weeks of the project)
     * @param xPos
     * @param yPos
     */
    public void padMove(float xPos, float yPos) {
        setPadXPos(xPos);
        setPadYPos(yPos);
    }


}
