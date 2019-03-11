package mappers;

import entity.city.City;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class CityMapperTest {

    private static final String PATH = "src\\main\\resources\\cities_response_1.json";

    @Test
    public void baseTest(){
        String json = TestUtils.readFile(PATH);
        List<City> trains = CityMapper.toDto(json);

        assertNotNull(trains);
    }

}