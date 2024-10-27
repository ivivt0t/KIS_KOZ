package Lab2_Decorator.Car;

import javax.inject.Inject;

public class CarBean {

    @Inject
    private Car car;

    public String getDescription() {
        return car.getDescription();
    }
}
