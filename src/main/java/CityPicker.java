import entity.city.City;
import mappers.CityMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.List;

public class CityPicker {
    private static final String URL = "https://booking.uz.gov.ua/train_search/station/?term=";

    public static String getCityCode(String cityName){
        String json = getJsonFromUZServer(cityName);
        List<City> citiesFromJson = CityMapper.toDto(json);
        String code = findCode(cityName, citiesFromJson);
        return code;
    }

    private static String findCode(String cityName, List<City> citiesFromJson) {
        for (City city : citiesFromJson){
            if (city.getTitle().equalsIgnoreCase(cityName)) return city.getValue();
        }
        return null;
    }

    private static String getJsonFromUZServer(String cityName){
        try {
            HttpClient client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(URL + cityName);

            HttpResponse response = client.execute(httpGet);
            ResponseHandler<String> handler = new BasicResponseHandler();
            return handler.handleResponse(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
