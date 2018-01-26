import entity.trainsUPD.Trains;
import mappers.TrainsMapper;
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
    private final String URL = "https://booking.uz.gov.ua/train_search/";

    public void searchTicketWithDelay(String fromStation, String toStation, String date){
        HttpPostClient httpPostClient = new HttpPostClient();

        System.out.println("Code for " + fromStation + ": " + CityPicker.getCityCode(fromStation));
        System.out.println("Code for " + toStation + ": " + CityPicker.getCityCode(toStation));

        System.out.println("Start: ");


        Trains trains = null;

        boolean flag = true;



        while (flag){
            try {
                trains = httpPostClient.sendPost(fromStation, toStation, date);

                if (trains!=null && !trains.getData().equals("013К")){
                    System.out.println("Trains was found");

                    //JOptionPane.showMessageDialog(null, "Buy!","", JOptionPane.ERROR_MESSAGE);

                    JOptionPane pane = new JOptionPane("Tickets was found");
                    JDialog dialog = pane.createDialog("Buy!");
                    dialog.setAlwaysOnTop(true);
                    dialog.show();


                    flag = false;
                    System.exit(0);
                    return;
                } else {
                    int sleepTime = getDelay();
                    System.out.println("There no trains now. Delay: " + (double)sleepTime/1000 + " seconds");

                    Thread.sleep(sleepTime);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // HTTP POST request
    private Trains sendPost(String fromStation, String toStation, String date) throws Exception {
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(URL);

        String fromStationCode = CityPicker.getCityCode(fromStation);
        String toStationCode = CityPicker.getCityCode(toStation);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("from", fromStationCode));
        urlParameters.add(new BasicNameValuePair("to", toStationCode));
//        urlParameters.add(new BasicNameValuePair("station_from", ""));
//        urlParameters.add(new BasicNameValuePair("station_till", ""));
        urlParameters.add(new BasicNameValuePair("date", date));
        urlParameters.add(new BasicNameValuePair("time", "00:00"));
//        urlParameters.add(new BasicNameValuePair("time_dep_till", ""));
        urlParameters.add(new BasicNameValuePair("another_ec", "0"));
        //urlParameters.add(new BasicNameValuePair("search", ""));


        post.setEntity(new UrlEncodedFormEntity(urlParameters, "UTF-8"));


        HttpResponse response = client.execute(post);

        //System.out.println(response.toString());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println(result.toString());
        return TrainsMapper.toDto(result.toString());
    }

    private int getDelay(){
        Random rnd = new Random();
        return  (int)(5000 + 10000 * rnd.nextDouble());
    }
}
