package mappers;

import entity.city.City;
import entity.trains.Trains;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.List;

public class CityMapper {
    public static List<City> toDto(String input){
        String json = input.substring(input.indexOf('['), input.indexOf(']') + 1);
        ObjectMapper mapper = new ObjectMapper();

        List<City> city  = null;
        try {
            city = mapper.readValue(json, new TypeReference<List<City>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return city;
    }
}
