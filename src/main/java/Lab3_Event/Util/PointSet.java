package Lab3_Event.Util;

import Lab3_Event.Annotation.AddedPoint;
import Lab3_Event.Annotation.RemovedPoint;
import lombok.Getter;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class PointSet {

    @Getter
    private List<Point> pointList = new ArrayList<>();

    @Inject
    @AddedPoint
    private Event<List<Point>> pointAddedEvent;

    @Inject
    @RemovedPoint
    private Event<List<Point>> pointRemovedEvent;

    public void addPoint(Point point) {
        pointList.add(point);
        printPoints();
        pointAddedEvent.fire(new ArrayList<>(pointList));  // Генерация события добавления точки
    }

    public void removePoint(Point point) {
        if (pointList.contains(point)) {
            pointList.remove(point);
            printPoints();
            pointRemovedEvent.fire(new ArrayList<>(pointList));  // Генерация события удаления точки
        } else {
            System.out.println("Точка не найдена: " + point);
        }
    }

    private void printPoints() {
        System.out.println("Текущий список точек:");
        for (Point point : pointList) {
            System.out.println(point);
        }
    }

}
