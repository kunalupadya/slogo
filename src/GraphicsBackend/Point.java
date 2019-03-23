package GraphicsBackend;

/**
 * @author kunalupadya
 */
public class Point {
    private double myX;
    private double myY;

    public Point(double x, double y){
        myX = x;
        myY = y;
    }

    /**
     * gets x
     * @return
     */
    public double getMyX() {
        return myX;
    }

    /**
     * gets y
     * @return
     */
    public double getMyY() {
        return myY;
    }
}
