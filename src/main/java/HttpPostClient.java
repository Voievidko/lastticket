import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.From;
import entity.Train;
import mappers.TrainSerializer;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HttpPostClient {
    private final String URL = "https://booking.uz.gov.ua/purchase/search/";

    public static void main(String[] args){
        HttpPostClient httpPostClient = new HttpPostClient();
        boolean flag = true;
        while (flag){
            try {
                int counter = httpPostClient.printNumberOfTrains();
                if (counter>2){
                    System.out.println("BUY!!!!!!!");
                    JOptionPane.showMessageDialog(null, "Buy", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
                    flag = false;
                } else {
                    Random rnd = new Random();
                    int sleepTime = (int)(5000 + 10000 * rnd.nextDouble());
                    Thread.sleep(sleepTime);
                    System.out.println("Number of trains now: " + counter + "  Sleep time: " + sleepTime);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }

    private int printNumberOfTrains() throws Exception {
        HttpPostClient http = new HttpPostClient();
        String JsonLine = http.sendPost();
//        System.out.println(JsonLine);

        int index = JsonLine.indexOf("num");
        int count = 0;
        while (index != -1) {
            count++;
            JsonLine = JsonLine.substring(index + 1);
            index = JsonLine.indexOf("num");
        }

//        System.out.println(count);
        return count;
    }

    // HTTP POST request
    private String sendPost() throws Exception {
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(URL);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("station_id_from", "2218200"));
        urlParameters.add(new BasicNameValuePair("station_id_till", "2200001"));
        urlParameters.add(new BasicNameValuePair("station_from", "Івано-Франківськ"));
        urlParameters.add(new BasicNameValuePair("station_till", "Київ"));
        urlParameters.add(new BasicNameValuePair("date_dep", "22.12.2017"));
        urlParameters.add(new BasicNameValuePair("time_dep", "00:00"));
        urlParameters.add(new BasicNameValuePair("time_dep_till", ""));
        urlParameters.add(new BasicNameValuePair("another_ec", "0"));
        urlParameters.add(new BasicNameValuePair("search", ""));


        post.setEntity(new UrlEncodedFormEntity(urlParameters, "UTF-8"));


        HttpResponse response = client.execute(post);

//        System.out.println("Sending 'POST' request to URL : " + URL);
//        System.out.println("Post parameters : " + post.getEntity());
//        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return result.toString();

    }
}