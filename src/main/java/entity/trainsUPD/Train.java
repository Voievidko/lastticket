package entity.trainsUPD;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Train {
    private String num;
    private int category;
    private String travelTime;
    private From from;
    private To to;
    private List<Type> types;
    private Child child;
    private int allowStud;
    private int allowBooking;
    private int allowRoundtrip;
    private int isEurope;

    public Train() {
    }

    public Train(String num, int category, String travelTime, From from, To to, List<Type> types, Child child, int allowStud, int allowBooking, int allowRoundtrip, int isEurope) {
        this.num = num;
        this.category = category;
        this.travelTime = travelTime;
        this.from = from;
        this.to = to;
        this.types = types;
        this.child = child;
        this.allowStud = allowStud;
        this.allowBooking = allowBooking;
        this.allowRoundtrip = allowRoundtrip;
        this.isEurope = isEurope;
    }
}
