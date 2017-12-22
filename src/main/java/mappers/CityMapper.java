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
    public List<City> toDto(String input){


        JsonFactory jf = new JsonFactory();
        jf.enable(JsonParser.Feature.ALLOW_COMMENTS);

        ObjectMapper mapper = new ObjectMapper(jf);

        List<City> city  = null;
        try {
            city = mapper.readValue(input, new TypeReference<List<City>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return city;
    }
}
