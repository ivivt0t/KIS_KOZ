package Lab1_CDI.Component;

import Lab1_CDI.FileReader.Abstraction.IFileReader;
import Lab1_CDI.FileReader.Annotation.JSON;
import Lab1_CDI.FileReader.Annotation.XML;
import Lab1_CDI.FileReader.Annotation.YAML;
import Lab1_CDI.Interceptor.ProfileInterceptor;

import javax.inject.Inject;
import javax.interceptor.Interceptors;

@Interceptors(ProfileInterceptor.class)
public class FileReader {

    @Inject
//    @JSON
//    @XML
    @YAML
    private IFileReader fileReader;

    public String readContent(String filepath) {
        return fileReader.readContent(filepath);
    }
}
