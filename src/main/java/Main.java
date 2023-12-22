import models.Point;
import models.Shape;

import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("source");

        if (inputStream == null) {
            System.out.println("File not founded!");
            return;
        }

        Scanner sc = new Scanner(inputStream);
        Shape shape = new Shape();

        while (sc.hasNext()) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();

            Point point = new Point(x, y);
            shape.addPoint(point);
        }

        System.out.println(shape.getPerimeter());
        System.out.println(shape.getLongestSide());
        System.out.println(shape.getAverageSide());
    }
}
