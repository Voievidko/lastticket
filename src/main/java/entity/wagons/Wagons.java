package entity.wagons;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonRootName;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "data")
public class Wagons {
    private List<Type> types;
    private List<Wagon> wagons;
    private String tplPage;

    public Wagons() {
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }

    public String getTplPage() {
        return tplPage;
    }

    public void setTplPage(String tplPage) {
        this.tplPage = tplPage;
    }
}
