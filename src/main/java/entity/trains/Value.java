package entity.trains;

import java.util.List;

public class Value {
    private String num;
    private int model;
    private int category;
    private String travel_time;
    private From from;
    private int is_europe;
    private Till till;
    private List<Type> types;
    private int allow_stud;
    private int allow_transportation;
    private int allow_booking;
    private int allow_roundtrip;

    public Value() {
    }

    public Value(String num, int model, int category, String travel_time, From from, int is_europe, Till till, List<Type> types, int allow_stud, int allow_transportation, int allow_booking, int allow_roundtrip) {
        this.num = num;
        this.model = model;
        this.category = category;
        this.travel_time = travel_time;
        this.from = from;
        this.is_europe = is_europe;
        this.till = till;
        this.types = types;
        this.allow_stud = allow_stud;
        this.allow_transportation = allow_transportation;
        this.allow_booking = allow_booking;
        this.allow_roundtrip = allow_roundtrip;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getTravel_time() {
        return travel_time;
    }

    public void setTravel_time(String travel_time) {
        this.travel_time = travel_time;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public Till getTill() {
        return till;
    }

    public void setTill(Till till) {
        this.till = till;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public int getAllow_stud() {
        return allow_stud;
    }

    public void setAllow_stud(int allow_stud) {
        this.allow_stud = allow_stud;
    }

    public int getAllow_transportation() {
        return allow_transportation;
    }

    public void setAllow_transportation(int allow_transportation) {
        this.allow_transportation = allow_transportation;
    }

    public int getAllow_booking() {
        return allow_booking;
    }

    public void setAllow_booking(int allow_booking) {
        this.allow_booking = allow_booking;
    }

    public int getAllow_roundtrip() {
        return allow_roundtrip;
    }

    public void setAllow_roundtrip(int allow_roundtrip) {
        this.allow_roundtrip = allow_roundtrip;
    }

    @Override
    public String toString() {
        return "Value{" + "\n" +
                "num='" + num + "'" +"\n" +
                "model=" + model + "\n" +
                "category=" + category + "\n" +
                "travel_time='" + travel_time + "'" +"\n" +
                "from=" + from + "\n" +
                "till=" + till + "\n" +
                "types=" + types + "\n" +
                "allow_stud=" + allow_stud + "\n" +
                "allow_transportation=" + allow_transportation + "\n" +
                "allow_booking=" + allow_booking + "\n" +
                "allow_roundtrip=" + allow_roundtrip + "\n" +
                '}';
    }


    public int getIs_europe() {
        return is_europe;
    }

    public void setIs_europe(int is_europe) {
        this.is_europe = is_europe;
    }
}