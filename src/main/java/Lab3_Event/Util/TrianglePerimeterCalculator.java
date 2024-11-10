package Lab3_Event.Util;

import Lab3_Event.Annotation.AddedPoint;
import Lab3_Event.Annotation.RemovedPoint;

import javax.enterprise.event.Observes;
import java.util.List;

public class TrianglePerimeterCalculator {

    // Обработка события добавления точки
    public void calculatePerimeterOnAdd(@Observes @AddedPoint List<Point> pointList) {
        if (pointList.size() >= 3) {
            Point[] triangle = findTriangleWithMaxPerimeter(pointList);
            System.out.println("Треугольник с максимальным периметром: " + triangle[0] + ", " + triangle[1] + ", " + triangle[2]);
        }
    }

    // Обработка события удаления точки
    public void calculatePerimeterOnRemove(@Observes @RemovedPoint List<Point> pointList) {
        if (pointList.size() >= 3) {
            Point[] triangle = findTriangleWithMaxPerimeter(pointList);
            System.out.println("Треугольник с максимальным периметром: " + triangle[0] + ", " + triangle[1] + ", " + triangle[2]);
        }
    }

    // Метод для нахождения треугольника с максимальным периметром
    private Point[] findTriangleWithMaxPerimeter(List<Point> pointList) {
        double maxPerimeter = Double.MIN_VALUE;
        Point[] maxTriangle = new Point[3];

        for (int i = 0; i < pointList.size(); i++) {
            for (int j = i + 1; j < pointList.size(); j++) {
                for (int k = j + 1; k < pointList.size(); k++) {
                    Point p1 = pointList.get(i);
                    Point p2 = pointList.get(j);
                    Point p3 = pointList.get(k);
                    double perimeter = p1.distanceTo(p2) + p2.distanceTo(p3) + p3.distanceTo(p1);
                    if (perimeter > maxPerimeter) {
                        maxPerimeter = perimeter;
                        maxTriangle[0] = p1;
                        maxTriangle[1] = p2;
                        maxTriangle[2] = p3;
                    }
                }
            }
        }
        return maxTriangle;
    }
}
