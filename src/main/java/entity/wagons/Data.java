package entity.wagons;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private List<Type> types;
    private List<Wagon> wagons;

    public Data() {
    }

    public Data(List<Type> types, List<Wagon> wagons) {
        this.types = types;
        this.wagons = wagons;
    }

    @JsonProperty("types")
    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    @JsonProperty("wagons")
    public List<Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }
}
