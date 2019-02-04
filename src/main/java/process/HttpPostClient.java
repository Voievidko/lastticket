package process;

import entity.trains.Train;
import mappers.TrainsMapper;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HttpPostClient {

    private final static String SEARCH_TRAINS_URL = "https://booking.uz.gov.ua/train_search/";
    private final static String SEARCH_CITY_URL = "https://booking.uz.gov.ua/train_search/station/?term=";

    static String getCityListFromUZServer(String cityName){
        try {
            HttpClient client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(SEARCH_CITY_URL + cityName);

            HttpResponse response = client.execute(httpGet);
            ResponseHandler<String> handler = new BasicResponseHandler();
            return handler.handleResponse(response);
        } catch (IOException e) {
            System.out.println("Seems UZ server is down");
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    List<Train> sendPost(String cityCodeFrom, String cityCodeTo, String date) {
        StringBuilder result = new StringBuilder();
        try {
            HttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(SEARCH_TRAINS_URL);

            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add(new BasicNameValuePair("from", cityCodeFrom));
            urlParameters.add(new BasicNameValuePair("to", cityCodeTo));
            urlParameters.add(new BasicNameValuePair("date", date));
            urlParameters.add(new BasicNameValuePair("time", "00:00"));
            urlParameters.add(new BasicNameValuePair("another_ec", "0"));

            post.setEntity(new UrlEncodedFormEntity(urlParameters, "UTF-8"));


            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return TrainsMapper.toDto(result.toString()).getData().getTrains();
    }
}
