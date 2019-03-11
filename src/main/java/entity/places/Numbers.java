package entity.places;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Numbers {

    private List<String> placeNumbers;

    public Numbers() {
    }

    @JsonProperty("Б")
    public List<String> getPlaceNumbers() {
        return placeNumbers;
    }

    public void setPlaceNumbers(List<String> placeNumbers) {
        this.placeNumbers = placeNumbers;
    }
}
