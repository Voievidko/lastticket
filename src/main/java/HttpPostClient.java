import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HttpPostClient {
    private final String URL = "https://booking.uz.gov.ua/purchase/search/";

    public static void main(String[] args) throws Exception {
        HttpPostClient http = new HttpPostClient();
        http.sendPost();
    }

    // HTTP POST request
    private void sendPost() throws Exception {
        HttpClient client = HttpClients.createDefault();
        //HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(URL);

        // add header

//        post.setHeader("Accept", "*/*");
//        post.setHeader("Content-Type","application/x-www-form-urlencoded");
//        post.setHeader("GV-Ajax", "1");
//        post.setHeader("GV-Screen", "1920x1080");
//        post.setHeader("Referer", "https://booking.uz.gov.ua/");
//        post.setHeader("Accept-Language", "ru-RU");
//        post.setHeader("Accept-Encoding", "gzip, deflate");
//        post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko");
//        post.setHeader("Host", "booking.uz.gov.ua");
//        post.setHeader("Content-Length", "263");
//        post.setHeader("DNT", "1");
//        post.setHeader("Connection", "Keep-Alive");
//        post.setHeader("Cache-Control", "no-cache");
//        post.setHeader("Cookie", "_gv_lang=uk; __utma=31515437.1167593834.1426147746.1447325206." +
//                "1450785433.5; _gv_sessid=dtfvv9vh1smpdups284hj2isb0; HTTPSERVERID=server1; _ga=GA1.3.1167593" +
//                "834.1426147746; _gid=GA1.3.603776797.1508740788; _gat=1");


        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("station_id_from", "2200001"));
        urlParameters.add(new BasicNameValuePair("station_id_till", "2218200"));
        urlParameters.add(new BasicNameValuePair("station_from", "Київ"));
        urlParameters.add(new BasicNameValuePair("station_till", "Івано-Франківськ"));
        urlParameters.add(new BasicNameValuePair("date_dep", "30.11.2017"));
        urlParameters.add(new BasicNameValuePair("time_dep", "00:00"));
        urlParameters.add(new BasicNameValuePair("time_dep_till", ""));
        urlParameters.add(new BasicNameValuePair("another_ec", "0"));
        urlParameters.add(new BasicNameValuePair("search", ""));


        post.setEntity(new UrlEncodedFormEntity(urlParameters, "UTF-8"));


        HttpResponse response = client.execute(post);

        System.out.println("Sending 'POST' request to URL : " + URL);
        System.out.println("Post parameters : " + post.getEntity());
        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println(result.toString());

    }
}
