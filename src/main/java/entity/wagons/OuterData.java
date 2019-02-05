package entity.wagons;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonUnwrapped;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OuterData {
    private Data data;

    public OuterData() {
    }

    public OuterData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}