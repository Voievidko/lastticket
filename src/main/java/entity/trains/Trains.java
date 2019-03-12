package entity.trains;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("data")
public class Trains {

    private List<Train> trains;

    public Trains() {
    }

    @JsonProperty("list")
    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }
}
