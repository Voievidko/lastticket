package entity.trains;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonRootName(value = "list")
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
    private int noReserve;


    public Train() {
    }

    public Train(String num, int category, String travelTime, From from, To to, List<Type> types,
                 Child child, int allowStud, int allowBooking, int allowRoundtrip, int isEurope, int noReserve) {
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
        this.noReserve = noReserve;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public To getTo() {
        return to;
    }

    public void setTo(To to) {
        this.to = to;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public int getAllowStud() {
        return allowStud;
    }

    public void setAllowStud(int allowStud) {
        this.allowStud = allowStud;
    }

    public int getAllowBooking() {
        return allowBooking;
    }

    public void setAllowBooking(int allowBooking) {
        this.allowBooking = allowBooking;
    }

    public int getAllowRoundtrip() {
        return allowRoundtrip;
    }

    public void setAllowRoundtrip(int allowRoundtrip) {
        this.allowRoundtrip = allowRoundtrip;
    }

    public int getIsEurope() {
        return isEurope;
    }

    public void setIsEurope(int isEurope) {
        this.isEurope = isEurope;
    }

    public int getNoReserve() {
        return noReserve;
    }

    public void setNoReserve(int noReserve) {
        this.noReserve = noReserve;
    }
}
