package models;

import java.util.LinkedList;
import java.util.List;

public class Shape {
    private final List<Point> points = new LinkedList<>();


    /**
     * Adds a new point to the list.
     * If the list of points is empty, the new point will be added to the start of the list.
     * Otherwise, point will be added between the two closest points.
     *
     * @param newPoint Point to be added to the list.
     */
    public void addPoint(Point newPoint) {
        if (points.isEmpty()) {
            points.add(newPoint);
            return;
        }

        int closestIndex = 0;
        double closestDistance = Double.POSITIVE_INFINITY;
        int size = points.size();
        for (int i = 0; i < size; i++) {
            double distance = newPoint.getDistanceTo(points.get(i)) + newPoint.getDistanceTo(points.get((i + 1) % size));
            if (distance < closestDistance) {
                closestDistance = distance;
                closestIndex = i;
            }
        }

        points.add(closestIndex + 1, newPoint);
    }


    /**
     * Calculating the perimeter of the shape.
     *
     * @return Total perimeter of the shape
     */
    public double getPerimeter() {
        int count = points.size();
        double perimeter = 0;
        for (int i = 0; i < count; i++)
            perimeter += points.get(i).getDistanceTo(points.get((i + 1) % count));
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
        if (count <= 1) return 0;
        if (count == 2) return getPerimeter();
        return getPerimeter() / count;
    }

    /**
     * Returning the longest side of the shape.
     *
     * @return Longest side of the shape
     */
    public double getLongestSide() {
        double mx = 0;
        int size = points.size();
        for (int i = 0; i < size; i++)
            mx = Math.max(points.get(i).getDistanceTo(points.get((i + 1) % size)), mx);
        return mx;
    }
}
