package mappers;

import entity.trainsUPD.Data;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrainsMapper {
    public static Data toDto(String input){

        Data trains = null;
        ObjectMapper mapper = new ObjectMapper();

        try{
            trains = mapper.readValue(input, Data.class);
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
