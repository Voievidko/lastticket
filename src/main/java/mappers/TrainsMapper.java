package mappers;

import entity.trainsUPD.Data;
import entity.trainsUPD.Trains;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrainsMapper {
    public static Trains toDto(String input){

        Trains trains = null;
        ObjectMapper mapper = new ObjectMapper();

        try{
            trains = mapper.readValue(input, Trains.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            return null;
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trains;
    }
}
