package process;

import entity.city.City;
import mappers.CityMapper;

import java.util.List;

public class CityPicker {

    private CityPicker(){
        throw new IllegalArgumentException("Utility class");
    }

    public static String getCityCode(String targetCity){
        String json = HttpPostClient.getCityListFromUZServer(targetCity);
        List<City> citiesFromJson = CityMapper.toDto(json);
        return findCityCode(targetCity, citiesFromJson);
    }

    private static String findCityCode(String cityName, List<City> citiesFromJson) {
        for (City city : citiesFromJson){
            if (city.getTitle().equalsIgnoreCase(cityName)) return city.getValue();
        }
        throw new IllegalArgumentException("Code for city " + cityName + "wasn't founded");
    }
}
