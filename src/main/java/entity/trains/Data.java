package entity.trains;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    private List<Train> trains;

    public Data() {
    }

    public Data(List<Train> trains) {
        this.trains = trains;
    }

    @JsonProperty("list")
    public List<Train> getTrains() {
        return trains;
    }

    @JsonProperty("list")
    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }
}
