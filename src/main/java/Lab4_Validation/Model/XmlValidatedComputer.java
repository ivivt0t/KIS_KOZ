package Lab4_Validation.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class XmlValidatedComputer {

    private String model;
    private String processor;
    private int ram;
    private int hdd;
    private String operatingSystem;
}
