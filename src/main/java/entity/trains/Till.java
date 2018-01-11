package entity.trains;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Till {
    private String station;
    private String date;
    private String src_date;

    public Till() {
    }

    public Till(String station, String date, String src_date) {
        this.station = station;
        this.date = date;
        this.src_date = src_date;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSrc_date() {
        return src_date;
    }

    public void setSrc_date(String src_date) {
        this.src_date = src_date;
    }

    @Override
    public String toString() {
        return "From{" +
                "station='" + station + '\'' +
                ", date='" + date + '\'' +
                ", src_date='" + src_date + '\'' +
                '}';
    }
}