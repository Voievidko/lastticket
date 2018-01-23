package entity.trainsUPD;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class From {
    private String code;
    private String station;
    private String stationTrain;
    private String date;
    private String time;
    private int sortTime;
    private String srcDate;

    public From() {
    }

    public From(String code, String station, String stationTrain, String date, String time, int sortTime, String srcDate) {
        this.code = code;
        this.station = station;
        this.stationTrain = stationTrain;
        this.date = date;
        this.time = time;
        this.sortTime = sortTime;
        this.srcDate = srcDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getStationTrain() {
        return stationTrain;
    }

    public void setStationTrain(String stationTrain) {
        this.stationTrain = stationTrain;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSortTime() {
        return sortTime;
    }

    public void setSortTime(int sortTime) {
        this.sortTime = sortTime;
    }

    public String getSrcDate() {
        return srcDate;
    }

    public void setSrcDate(String srcDate) {
        this.srcDate = srcDate;
    }
}
