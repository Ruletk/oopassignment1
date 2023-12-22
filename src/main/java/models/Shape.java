package models;

import java.util.ArrayList;
import java.util.List;

public class Shape {
    private final List<Point> points = new ArrayList<>();


    /*
    * Adds a new point to the list.
    * If the list of points is empty, the new point will be added to the start of the list.
    * Otherwise, point will be added between the two closest points.
    *
    * @param newPoint Point to be added to the list.
     */
    public void addPoint(Point newPoint) {
        int closestIndex = 0;
        double closestDistance = Double.POSITIVE_INFINITY;
        for (int i = 0; i < points.size(); i++) {
            double d1 = newPoint.getDistanceTo(points.get(i));
            double d2 = points.size() - 1 == i ?
                    newPoint.getDistanceTo(points.get(0)) :
                    newPoint.getDistanceTo(points.get(i + 1));
            if (d1 + d2 < closestDistance) {
                closestDistance = d1 + d2;
                closestIndex = i;
            }
        }
        if (points.isEmpty()) points.add(newPoint);
        else points.add(closestIndex + 1, newPoint);
    }


    /**
     * Calculating the perimeter of the shape.
     *
     * @return Total perimeter of the shape
     */
    public double getPerimeter() {
        int count = points.size();
        double perimeter = points.get(0).getDistanceTo(points.get(count - 1));
        for (int i = 0; i < count - 1; i++)
            perimeter += points.get(i).getDistanceTo(points.get(i + 1));
        return perimeter;
    }

    /**
     * Calculating the average of the length of the sides.
     * Using arithmetic average formula.
     * If the shape have no or 1 point, 0 will be returned.
     * If the shape have 2 points, total length will be returned.
     *
     * @return Average length of the sides.
     */
    public double getAverageSide() {
        int count = points.size();
        if (count == 2) return getPerimeter();
        return count <= 1 ? 0 : getPerimeter() / count;
    }

    /**
     * Returning the longest side of the shape.
     *
     * @return Longest side of the shape
     */
    public double getLongestSide() {
        double mx = 0;
        for (int i = 0; i < points.size() - 1; i++)
            mx = Math.max(points.get(i).getDistanceTo(points.get(i + 1)), mx);
        return mx;
    }
}
