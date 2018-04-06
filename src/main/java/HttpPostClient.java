import entity.trains.Train;
import entity.trains.Trains;
import entity.trains.Type;
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
    private final int DELAY_MIN = 5000; //ms
    private final int DELAY_DELTA = 10000; //ms

    public void searchTicketWithDelay(String fromStation, String toStation, String date, List<String> neededTrains){
        HttpPostClient httpPostClient = new HttpPostClient();

        System.out.println("Code for " + fromStation + ": " + CityPicker.getCityCode(fromStation));
        System.out.println("Code for " + toStation + ": " + CityPicker.getCityCode(toStation));

        System.out.println("Start: ");

        Trains trains = null;
        boolean flag = true;

        while (flag){
            try {
                trains = httpPostClient.sendPost(fromStation, toStation, date);

                int numberOfPlaces = 0;
                if ((numberOfPlaces = ifPlaceExist(trains, neededTrains)) > 0){
                    System.out.println("Trains was found");
                    System.out.println("Number of places: " + numberOfPlaces);

                    JOptionPane pane = new JOptionPane("Tickets was found");
                    JDialog dialog = pane.createDialog("Buy!");
                    dialog.setAlwaysOnTop(true);
                    dialog.show();

                    flag = false;
                    System.exit(0);
                    return;
                } else {
                    int sleepTime = getDelay();
                    System.out.println("There no trains now");
                    System.out.println("        Delay: " + (double)sleepTime/1000 + " seconds; ");
                    System.out.println("        Total numbers of trains: " + trains.getData().getTrains().size() + "; ");
                    System.out.println("        Numbers: " + trains.getNumbersOfTrainsInOneLine());
                    System.out.println("        Search in scope: " + neededTrains);
                    System.out.println();

                    Thread.sleep(sleepTime);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private int ifPlaceExist(Trains trains, List<String> neededTrains){
        int places = 0;
        for (Train train : trains.getData().getTrains()){
            for (Type type : train.getTypes()){
                if (numberOfTrainsChecker(train, neededTrains)){
                    places += type.getPlaces();
                }
            }
        }
        return places;
    }

    private boolean numberOfTrainsChecker (Train train, List<String> neededTrains){
        if (neededTrains == null || neededTrains.isEmpty()) return true;
        for (String numberOfTrains : neededTrains){
            if (train.getNum().equalsIgnoreCase(numberOfTrains)) {
                return true;
            }
        }
        return false;
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
        urlParameters.add(new BasicNameValuePair("date", date));
        urlParameters.add(new BasicNameValuePair("time", "00:00"));
        urlParameters.add(new BasicNameValuePair("another_ec", "0"));


        post.setEntity(new UrlEncodedFormEntity(urlParameters, "UTF-8"));


        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return TrainsMapper.toDto(result.toString());
    }

    private int getDelay(){
        Random rnd = new Random();
        return  (int)(DELAY_MIN + DELAY_DELTA * rnd.nextDouble());
    }
}
