package Lab2_Decorator.Decorator;

import Lab2_Decorator.Car.Car;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
@AllArgsConstructor
@NoArgsConstructor
public class TruckCar implements Car {

    private int loadCapacity = 100;

    @Delegate
    @Inject
    private Car car;

    @Override
    public String getDescription() {
        return car.getDescription() + ", Load capacity: " + loadCapacity;
    }
}
