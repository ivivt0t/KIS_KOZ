package Lab5_Annotation_Validation;

import Lab5_Annotation_Validation.Model.Computer;
import Lab5_Annotation_Validation.Model.Motherboard;
import Lab5_Annotation_Validation.Model.Processor;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

public class Laboratory5 {
    public static void main(String[] args) {
        Processor intelProcessor = new Processor("Intel", "LGA1200");
        Motherboard intelMotherboard = new Motherboard("LGA1200");

        Processor amdProcessor = new Processor("AMD", "AM4");
        Motherboard amdMotherboard = new Motherboard("AM4");

        Motherboard incompatibleMotherboard = new Motherboard("AM5");

        Computer validComputer = new Computer(intelProcessor, intelMotherboard);
        Computer invalidComputer = new Computer(intelProcessor, incompatibleMotherboard);
        Computer validAmdComputer = new Computer(amdProcessor, amdMotherboard);

        ValidatorFactory factory = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator = factory.getValidator();

        System.out.println("Валидный Intel-компьютер:");
        validator.validate(validComputer).forEach(violation -> System.out.println(violation.getMessage()));

        System.out.println("\nНевалидный компьютер:");
        validator.validate(invalidComputer).forEach(violation -> System.out.println(violation.getMessage()));

        System.out.println("\nВалидный AMD-компьютер:");
        validator.validate(validAmdComputer).forEach(violation -> System.out.println(violation.getMessage()));
    }
}
