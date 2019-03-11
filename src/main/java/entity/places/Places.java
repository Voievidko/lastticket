package entity.places;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonRootName;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "data")
public class Places {
    private Numbers places;
    private String schemeId;

    public Places() {
    }

    public Numbers getPlaces() {
        return places;
    }

    public void setPlaces(Numbers places) {
        this.places = places;
    }

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }
}
