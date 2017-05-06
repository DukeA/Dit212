package Model.GameObjects.Physics;

/**
 * @author Ken Bäcklund
 */
public interface Body {

    float getX();
    float getY();
    float getAngle();
    float getSpeed();

    void setX(float xPos);
    void setY(float yPos);
    void setPosition(float xPos, float yPos);
    void setAngle(float radians);
    void setSpeed(float speed);
    void setMaxSpeed(float maxSpeed);

    float distance(Body body);
    float distance(float xPos, float yPos);

    void move();
    Location getLoc();
}
