package entity.trainsUPD;

import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName(value = "list")
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
