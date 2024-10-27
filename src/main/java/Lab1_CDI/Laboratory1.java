package Lab1_CDI;

import Lab1_CDI.Component.FileReader;
import lombok.NoArgsConstructor;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

@NoArgsConstructor
public class Laboratory1 {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) {
        weld = new Weld();
        container = weld.initialize();

        try {

//            String JSON_FILE_PATH = "src/main/resources/files/data.json";
//            String XML_FILE_PATH = "src/main/resources/files/data.xml";
            String YAML_FILE_PATH = "src/main/resources/files/data.yaml";

            FileReader fileReader = container.select(FileReader.class).get();

//             String output = fileReader.readContent(JSON_FILE_PATH);
//             String output = fileReader.readContent(XML_FILE_PATH);
             String output = fileReader.readContent(YAML_FILE_PATH);

             System.out.println(output);

        } finally {
            weld.shutdown();
        }
    }
}
