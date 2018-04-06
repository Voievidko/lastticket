package mappers;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class TrainsMapperTest {
    private static final String PATH = "src\\main\\resources\\answer.json";

    @Test
    public void baseTest(){
        String json = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH));
            String sCurrentLine;

            while ((sCurrentLine = bufferedReader.readLine()) != null) {
                json += sCurrentLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        TrainsMapper trainsMapper = new TrainsMapper();
        entity.trains.Trains trains = trainsMapper.toDto(json);

        assertNotNull(trains);
        assertEquals(6, trains.getData());
        //assertEquals("Сидячий другого класу", trains.getValue().get(0).getTypes().get(0).getTitle());


    }
}