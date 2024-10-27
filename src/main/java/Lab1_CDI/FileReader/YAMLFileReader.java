package Lab1_CDI.FileReader;

import Lab1_CDI.FileReader.Abstraction.IFileReader;
import Lab1_CDI.FileReader.Annotation.YAML;
import Lab1_CDI.Model.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.List;

@YAML
@NoArgsConstructor
public class YAMLFileReader implements IFileReader {
    @Override
    public String readContent(String filePath) {
        StringBuilder output = new StringBuilder();
        try {
            // Чтение студентов из файла
            List<Student> students = readYAMLFile(filePath);
            // Формируем строку для вывода
            for (Student student : students) {
                output.append("Name: ").append(student.getName())
                        .append(", Surname: ").append(student.getSurname())
                        .append(", Age: ").append(student.getAge())
                        .append("\n"); // Переход на новую строку
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка при чтении файла: " + e.getMessage(); // Возвращаем сообщение об ошибке
        }

        return output.toString(); // Возвращаем сформированную строку
    }

    public List<Student> readYAMLFile(String filePath) throws IOException {
        YAMLMapper yamlMapper = new YAMLMapper();
        return yamlMapper.readValue(new File(filePath), new TypeReference<List<Student>>() {});
    }
}
