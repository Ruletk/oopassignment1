package models;

public class Point {
    private final double x;

    private final double y;


    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistanceTo(Point dest) {
        return Math.sqrt(
                Math.pow(this.x - dest.x, 2) + Math.pow(this.y - dest.y, 2)
        );
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
