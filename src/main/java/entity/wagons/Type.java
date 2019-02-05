package entity.wagons;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Type {
    private String typeId;
    private String title;
    private int free;
    private int cost;
    private boolean isOneCost;

    public Type() {
    }

    public Type(String typeId, String title, int free, int cost, boolean isOneCost) {
        this.typeId = typeId;
        this.title = title;
        this.free = free;
        this.cost = cost;
        this.isOneCost = isOneCost;
    }

    @JsonProperty("type_id")
    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean getIsOneCost() {
        return isOneCost;
    }

    public void setIsOneCost(boolean isOneCost) {
        this.isOneCost = isOneCost;
    }
}
