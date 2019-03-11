package mappers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestUtils {

    public static String readFile(String pathToFile){
        String json = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile));
            String sCurrentLine;

            while ((sCurrentLine = bufferedReader.readLine()) != null) {
                json += sCurrentLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
