package mappers;

import entity.wagons.Data;
import entity.wagons.OuterData;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class WagonMapper {

    private WagonMapper (){
        throw new IllegalArgumentException("Utility class");
    }

    public static Data toDto(String input){
        OuterData data = null;
        ObjectMapper mapper = new ObjectMapper();

        try{
            data = mapper.readValue(input, OuterData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.getData();
    }
}
