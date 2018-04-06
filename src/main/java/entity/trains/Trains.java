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

    public String getNumbersOfTrainsInOneLine(){
        String str = "[";
        for(int i = 0; i < this.getData().getTrains().size(); i++){
            Train train = this.getData().getTrains().get(i);
            str += train.getNum();
            if (i != this.getData().getTrains().size() - 1) str +=  ", ";
        }
        str = str + "]";
        return str;
    }
}
