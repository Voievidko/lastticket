package entity.wagons;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {

    private List<String> price;

    public Price() {
    }

    public Price(List<String> price) {
        this.price = price;
    }
}
