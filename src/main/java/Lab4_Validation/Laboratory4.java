package Lab4_Validation;

import Lab4_Validation.Model.CodeValidatedComputer;
import Lab4_Validation.Model.XmlValidatedComputer;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import java.util.Set;

public class Laboratory4 {

    public static void main(String[] args) {
        // Создание фабрики валидаторов
        ValidatorFactory factory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator = factory.getValidator();

        // Создание и проверка объекта XmlValidatedComputer
        XmlValidatedComputer xmlComputer = new XmlValidatedComputer();
        xmlComputer.setModel("MacBook Pro");
        xmlComputer.setProcessor("Intel i9");
        xmlComputer.setRam(32);
        xmlComputer.setHdd(512);
        xmlComputer.setOperatingSystem("macOS");

        System.out.println("Валидация XmlValidatedComputer:");
        validateAndPrint(validator, xmlComputer);

        // Создание и проверка объекта Computer
        CodeValidatedComputer computer = new CodeValidatedComputer();
        computer.setModel("Dell XPS 13");
        computer.setProcessor("Intel i7");
        computer.setRam(16);
        computer.setHdd(512);
        computer.setOperatingSystem("Windows 10");

        System.out.println("\nВалидация Computer:");
        validateAndPrint(validator, computer);
    }

    // Метод для валидации и вывода результата валидации в консоль
    private static <T> void validateAndPrint(Validator validator, T object) {
        Set<ConstraintViolation<T>> violations = validator.validate(object);
        if (violations.isEmpty()) {
            System.out.println("Валидация прошла успешно!");
        } else {
            for (ConstraintViolation<T> violation : violations) {
                System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
            }
        }
    }
}
