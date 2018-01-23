package mappers;

import entity.trains.Trains;
import entity.trainsUPD.Data;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UpdatedTrainsMapperTest {
    private static final String PATH = "src\\main\\resources\\updatedAnswer.json";

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
        Data trains = trainsMapper.toDto(json);

        assertNotNull(trains);

        System.out.println(trains.getTrains());
        //assertEquals(16, trains.getTrains().size());
        //assertEquals("Сидячий другого класу", trains.getValue().get(0).getTypes().get(0).getTitle());


    }
}