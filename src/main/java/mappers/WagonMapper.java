package mappers;

import entity.wagons.Wagons;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class WagonMapper {

    private WagonMapper (){
        throw new IllegalArgumentException("Utility class");
    }

    public static Wagons toDto(String input){
        Wagons wagons = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE);

        try{
            wagons = mapper.readValue(input, Wagons.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wagons;
    }
}
