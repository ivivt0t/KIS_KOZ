package Lab5_Annotation_Validation.Validator;

import Lab5_Annotation_Validation.Annotation.CompatibleComponents;
import Lab5_Annotation_Validation.Model.Computer;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CompatibilityValidator implements ConstraintValidator<CompatibleComponents, Computer> {

    @Override
    public boolean isValid(Computer computer, ConstraintValidatorContext context) {
        if (computer.getProcessor() == null || computer.getMotherboard() == null) {
            return true; // Проверка на null проводится другими аннотациями
        }

        String processorSocket = computer.getProcessor().getSocket();
        String motherboardSocket = computer.getMotherboard().getSocket();

        return processorSocket != null && processorSocket.equals(motherboardSocket);
    }
}
