package entity.trains;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Train {
    private String num;
    private int category;
    private int isTransformer;
    private String travelTime;
    private From from;
    private To to;
    private List<Type> types;
    private Child child;
    private int allowStudent;
    private int allowBooking;
    private int isCis;
    private int allowRoundtrip;
    private int isEurope;
    private int noReserve;
    private int allowPrivilege;

    public Train() {
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

    public int getIsTransformer() {
        return isTransformer;
    }

    public void setIsTransformer(int isTransformer) {
        this.isTransformer = isTransformer;
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

    public int getAllowStudent() {
        return allowStudent;
    }

    public void setAllowStudent(int allowStudent) {
        this.allowStudent = allowStudent;
    }

    public int getAllowBooking() {
        return allowBooking;
    }

    public void setAllowBooking(int allowBooking) {
        this.allowBooking = allowBooking;
    }

    public int getIsCis() {
        return isCis;
    }

    public void setIsCis(int isCis) {
        this.isCis = isCis;
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

    public int getAllowPrivilege() {
        return allowPrivilege;
    }

    public void setAllowPrivilege(int allowPrivilege) {
        this.allowPrivilege = allowPrivilege;
    }
}
