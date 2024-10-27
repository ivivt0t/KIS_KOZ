package Lab1_CDI.FileReader;

import Lab1_CDI.FileReader.Abstraction.IFileReader;
import Lab1_CDI.FileReader.Annotation.JSON;
import Lab1_CDI.Model.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.List;

@JSON
@NoArgsConstructor
public class JSONFileReader implements IFileReader {
    @Override
    public String readContent(String filePath) {
        StringBuilder output = new StringBuilder(); // Создаём StringBuilder для формирования строки
        try {
            // Чтение студентов из файла
            List<Student> students = readJSONFile(filePath);
            // Формируем строку для вывода
            for (Student student : students) {
                output.append("Имя: ").append(student.getName())
                        .append(", Фамилия: ").append(student.getSurname())
                        .append(", Возраст: ").append(student.getAge())
                        .append("\n"); // Переход на новую строку
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка при чтении файла: " + e.getMessage(); // Возвращаем сообщение об ошибке
        }

        return output.toString(); // Возвращаем сформированную строку
    }

    public List<Student> readJSONFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), new TypeReference<List<Student>>() {});
    }
}
