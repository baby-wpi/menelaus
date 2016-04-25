package menelaus.model.basic;

import java.io.Serializable;

/**
 * Created by @author frankegan on 4/24/16.
 */
public class Coordinate implements Serializable{
    public float x, y;

    public Coordinate(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
