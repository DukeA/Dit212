package Tests;

import Model.GameObjects.Brick;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ken Bäcklund
 */
public class BrickTest {

    private static final float THRESHOLD = 0.0001f;

    private static final float XPOS = 0f;
    private static final float YPOS = 0f;
    private static final float WIDTH = 30f;
    private static final float HEIGHT = 20f;
    private static final double ANGLE = Math.PI / 2f;   // =45 degrees
    private static final float SPEED = 10f;
    private Brick brick;

    @BeforeEach
    void setUp() {
        brick = new Brick(XPOS, YPOS, WIDTH, HEIGHT);
    }

    @Test
    void getters() {
        Assertions.assertEquals(XPOS, brick.getX(), THRESHOLD);
        Assertions.assertEquals(YPOS, brick.getY(), THRESHOLD);
    }

    @Test
    void setters() {
        brick.setX(10);
        Assertions.assertEquals(10, brick.getX(), THRESHOLD);

        brick.setY(11);
        Assertions.assertEquals(11, brick.getY(), THRESHOLD);

        float expectedX = XPOS - 10f;
        float expectedY = YPOS - 10f;
        brick.setPosition(expectedX, expectedY);
        Assertions.assertEquals(expectedX, brick.getX(), THRESHOLD);
        Assertions.assertEquals(expectedY, brick.getY(), THRESHOLD);
    }

}
