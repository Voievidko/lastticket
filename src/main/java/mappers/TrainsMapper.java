package mappers;

import entity.trains.Trains;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class TrainsMapper {

    private TrainsMapper (){
        throw new IllegalArgumentException("Utility class");
    }

    public static Trains toDto(String input){
        Trains trains = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE);

        try{
            trains = mapper.readValue(input, Trains.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trains;
    }
}
