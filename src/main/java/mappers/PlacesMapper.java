package mappers;

import entity.places.Places;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class PlacesMapper {

    private PlacesMapper () {
        throw new IllegalArgumentException("Utility class");
    }

    public static Places toDto (String input){
        Places places = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE);

        try {
            places = mapper.readValue(input, Places.class);
        } catch (IOException e){
            e.printStackTrace();
        }
        return places;
    }
}