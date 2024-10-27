package Lab2_Decorator;

import Lab2_Decorator.Car.CarBean;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Laboratory2 {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) {
        weld = new Weld();
        container = weld.initialize();

        try {
            CarBean carBean = container.select(CarBean.class).get();

            System.out.println(carBean.getDescription());

        } finally {
            weld.shutdown();
        }
    }

}
