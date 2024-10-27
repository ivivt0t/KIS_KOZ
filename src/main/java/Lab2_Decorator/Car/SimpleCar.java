package Lab2_Decorator.Car;

import lombok.NoArgsConstructor;

import javax.enterprise.inject.Default;

@Default
@NoArgsConstructor
public class SimpleCar implements Car {
    @Override
    public String getDescription() {
        int year = 2018;
        String model = "M3";
        String brand = "BMW";
        return "Brand: " + brand + ", Model: " + model + ", Year: " + year;
    }

}
