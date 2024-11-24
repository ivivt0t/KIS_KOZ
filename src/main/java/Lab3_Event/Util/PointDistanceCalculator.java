package Lab3_Event.Util;

import Lab3_Event.Annotation.AddedPoint;
import Lab3_Event.Annotation.RemovedPoint;

import javax.enterprise.event.Observes;
import java.util.List;

public class PointDistanceCalculator {

    // Обработка события добавления точки
    public void calculateDistanceOnAdd(@Observes @AddedPoint List<Point> pointList) {
        if (pointList.size() < 3) {
            System.out.println("Недостаточно точек для расчета (минимум 3).");
            return;
        }
        Point minDistancePoint = findPointWithMinDistance(pointList);
        System.out.println("Точка с минимальной суммой расстояний: " + minDistancePoint);
    }

    // Обработка события удаления точки
    public void calculateDistanceOnRemove(@Observes @RemovedPoint List<Point> pointList) {
        if (pointList.size() < 3) {
            System.out.println("Недостаточно точек для расчета (минимум 3).");
            return;
        }
        Point minDistancePoint = findPointWithMinDistance(pointList);
        System.out.println("Точка с минимальной суммой расстояний: " + minDistancePoint);
    }

    // Метод для нахождения точки с минимальной суммой расстояний
    private Point findPointWithMinDistance(List<Point> pointList) {
        double minDistanceSum = Double.MAX_VALUE;
        Point minPoint = null;

        for (int i = 0; i < pointList.size(); i++) {
            Point p1 = pointList.get(i);
            double distanceSum = 0;
            for (int j = 0; j < pointList.size(); j++) {
                if (i != j) {
                    distanceSum += p1.distanceTo(pointList.get(j));
                }
            }
            if (distanceSum < minDistanceSum) {
                minDistanceSum = distanceSum;
                minPoint = p1;
            }
        }
        return minPoint;
    }
}
