package Objects;

/**
 * класс координат в формате (x,y)
 */

public class Coordinates {
    private float x;
    private long y; 

    public Coordinates(float x, long y)
    {
        this.x=x;
        this.y=y;
    }

    public long getY() {
        return y;
    }

    public float getX() {
        return x;
    }

    @Override
    public String toString()
    {
        return String.valueOf(x) + "," + Long.toString(y);
    }
}
