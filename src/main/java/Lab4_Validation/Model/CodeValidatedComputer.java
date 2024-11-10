package Lab4_Validation.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodeValidatedComputer {

    @NotNull(message = "Модель не должна быть пустой")
    @Pattern(regexp = "^[A-Za-z0-9\\s-]+$", message = "Модель может содержать только буквы, цифры, пробелы и дефисы")
    private String model;

    @NotNull(message = "Процессор не должен быть пустым")
    @Pattern(regexp = "^[A-Za-z0-9\\s]+$", message = "Процессор может содержать только буквы, цифры и пробелы")
    private String processor;

    @Min(value = 1, message = "Объем ОЗУ должен быть больше 1 ГБ")
    @Max(value = 128, message = "Объем ОЗУ не может превышать 128 ГБ")
    private int ram;

    @Min(value = 10, message = "Объем жесткого диска должен быть больше 10 ГБ")
    @Max(value = 5000, message = "Объем жесткого диска не может превышать 5000 ГБ")
    private int hdd;

    @NotNull(message = "Операционная система не должна быть пустой")
    private String operatingSystem;
}
