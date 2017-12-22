package mappers;

import entity.city.City;
import entity.trains.Trains;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class CityMapperTest {

    private static final String PATH = "src\\main\\resources\\cities.json";

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

        CityMapper cityMapper = new CityMapper();
        List<City> trains = cityMapper.toDto(json);

        assertNotNull(trains);
    }

}