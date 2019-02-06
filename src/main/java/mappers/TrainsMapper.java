package mappers;

import entity.trains.Trains;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class TrainsMapper {

    private TrainsMapper (){
        throw new IllegalArgumentException("Utility class");
    }

    public static Trains toDto(String input){
        Trains trains = null;
        ObjectMapper mapper = new ObjectMapper();

        try{
            trains = mapper.readValue(input, Trains.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trains;
    }
}
