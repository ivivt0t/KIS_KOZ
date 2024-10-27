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
public class SportsCar implements Car {

    private int maxSpeed = 300;
    private int enginePower = 350;

    @Inject
    @Delegate
    private Car car;

    @Override
    public String getDescription() {
        return car.getDescription() + ", Max speed: " + maxSpeed + ", Engine power: " + enginePower;
    }
}
