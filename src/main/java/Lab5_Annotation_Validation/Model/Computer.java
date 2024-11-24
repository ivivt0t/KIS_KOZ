package Lab5_Annotation_Validation.Model;

import Lab5_Annotation_Validation.Annotation.CompatibleComponents;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@CompatibleComponents
public class Computer {
    private Processor processor;
    private Motherboard motherboard;
}
