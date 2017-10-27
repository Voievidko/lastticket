import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.From;
import entity.Train;
import mappers.TrainSerializer;

/**
 * Created by voievidko_ri on 26.10.2017.
 */
public class Main {
    public static void main(String[] args) {




        String jsonTrain = "{\"num\":\"749К\",\"model\":0,\"category\":2,\"travel_time\":\"7:49\",\"from\":{\"station\":\"Київ-Пасажирський\",\"date\":1512043740,\"src_date\":\"2017-11-30 14:09:00\"},\"till\":{\"station\":\"Івано-Франківськ\",\"date\":1512071880,\"src_date\":\"2017-11-30 21:58:00\"},\"types\":[{\"id\":\"С1\",\"title\":\"Сидячий першого класу\",\"letter\":\"С1\",\"places\":36},{\"id\":\"С2\",\"title\":\"Сидячий другого класу\",\"letter\":\"С2\",\"places\":56}],\"allow_stud\":1,\"allow_transportation\":1,\"allow_booking\":1,\"allow_roundtrip\":1}";

        Gson gson = new Gson();
        From from = gson.fromJson(jsonTrain, From.class);
        System.out.println(from);

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Train.class, new TrainSerializer());


        Gson updatedGson = builder.create();
        Train train = updatedGson.fromJson(jsonTrain, Train.class);

        System.out.println(train);
    }
}
