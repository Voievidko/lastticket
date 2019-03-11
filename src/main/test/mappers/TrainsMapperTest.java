package mappers;

import entity.trains.Trains;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TrainsMapperTest {
    private static final String PATH = "src/main/resources/train_list_response_1.json";

    @Test
    public void baseTest(){
        String json = TestUtils.readFile(PATH);
        Trains trains = TrainsMapper.toDto(json);

        assertNotNull(trains);
        assertEquals(1, trains.getData().getTrains().size());
        assertEquals("049К",trains.getData().getTrains().get(0).getNum());
    }
}