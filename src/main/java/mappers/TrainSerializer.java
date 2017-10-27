package mappers;

import com.google.gson.*;
import entity.From;
import entity.Till;
import entity.Train;
import entity.Type;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

public class TrainSerializer implements JsonDeserializer {

    public Train deserialize(JsonElement jsonElement, java.lang.reflect.Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        Gson gson = new Gson();

        String num = object.get("num").getAsString();
        int model = object.get("model").getAsInt();
        int category = object.get("category").getAsInt();
        String travelTime = object.get("travel_time").getAsString();

        From from = gson.fromJson(jsonElement, From.class);
        Till till = gson.fromJson(jsonElement, Till.class);
        Type type1 = gson.fromJson(jsonElement, Type.class);
        List<Type> types = new ArrayList<Type>();
        types.add(type1);
        int allow_stud = object.get("allow_stud").getAsInt();
        int allow_transportation = object.get("allow_transportation").getAsInt();
        int allow_booking = object.get("allow_booking").getAsInt();
        int allow_roundtrip = object.get("allow_roundtrip").getAsInt();


        DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
        DateTime dt = formatter.parseDateTime(travelTime);
        System.out.println("-------------------------------");
        System.out.println(dt);
        System.out.println("-------------------------------");


        return new Train(num, model, category, dt, from,till,types,allow_stud,allow_transportation,allow_booking,allow_roundtrip);
        //return null;
    }

    public JsonElement serialize(Object o, Type type, JsonSerializationContext jsonSerializationContext) {
        return null;
    }
}
