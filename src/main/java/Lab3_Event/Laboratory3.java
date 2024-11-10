package Lab3_Event;

import Lab3_Event.Util.Point;
import Lab3_Event.Util.PointSet;
import Lab3_Event.Util.PointDistanceCalculator;
import Lab3_Event.Util.TrianglePerimeterCalculator;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Laboratory3 {

    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) {
        weld = new Weld();
        container = weld.initialize();

        try {
            // Получаем нужные бины через контейнер CDI
            PointSet pointSet = container.select(PointSet.class).get();

            // Создаем точки
            Point p1 = new Point(0, 0);
            Point p2 = new Point(3, 0);
            Point p3 = new Point(0, 4);
            Point p4 = new Point(5, 5);

            // Добавляем точки в PointSet и проверяем результаты
            pointSet.addPoint(p1);
            System.out.println("---------------------------------------------------------");
            pointSet.addPoint(p2);
            System.out.println("---------------------------------------------------------");
            pointSet.addPoint(p3);
            System.out.println("---------------------------------------------------------");
            pointSet.addPoint(p4);
            System.out.println("---------------------------------------------------------");
            pointSet.removePoint(p1); // Удаляем точку p1

        } finally {
            weld.shutdown();
        }
    }
}
