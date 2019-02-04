package mappers;

import entity.city.City;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.List;

public class CityMapper {
    private CityMapper(){
        throw new IllegalArgumentException("Utility class");
    }

    public static List<City> toDto(String input){
        String json = trimParentheses(input);
        ObjectMapper mapper = new ObjectMapper();

        List<City> city  = null;
        try {
            city = mapper.readValue(json, new TypeReference<List<City>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return city;
    }

    private static String trimParentheses(String input){
        return input.substring(input.indexOf('['), input.indexOf(']') + 1);
    }
}
