package mappers;

import entity.trainsUPD.Trains;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UpdatedTrainsMapperTest {
    private static final String PATH = "src/main/resources/updatedAnswer.json";


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

        Trains trains = trainsMapper.toDto(json);

        assertNotNull(trains);

        assertEquals(20,trains.getData().getTrains().size());
        assertEquals("007Л",trains.getData().getTrains().get(2).getNum());
        assertEquals("9:46",trains.getData().getTrains().get(1).getTravelTime());
        //assertEquals(16, trains.getTrains().size());
        //assertEquals("Сидячий другого класу", trains.getValue().get(0).getTypes().get(0).getTitle());


    }
}