package Lab5_Annotation_Validation.Annotation;

import Lab5_Annotation_Validation.Validator.CompatibilityValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CompatibilityValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CompatibleComponents {
    String message() default "Processor type is not compatible with the motherboard socket";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
