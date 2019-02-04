package entity.trains;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

//@JsonRootName(value = "list")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trains {
    private Data data;

    public Trains() {
    }

    public Trains(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
