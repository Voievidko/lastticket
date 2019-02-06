package entity.wagons;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wagon {
    private int num;
    private String typeId;
    private String type;
    private String wagonClass;
    private int railway;
    private int free;
    private boolean byWishes;
    private boolean hasBedding;
    private boolean obligatoryBedding;
    private List<String> services;
    private Map<String, Integer> prices;
    private int reservePrice;
    private boolean allowBonus;
    private String air;

    public Wagon() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @JsonProperty("type_id")
    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("class")
    public String getWagonClass() {
        return wagonClass;
    }

    public void setWagonClass(String wagonClass) {
        this.wagonClass = wagonClass;
    }

    public int getRailway() {
        return railway;
    }

    public void setRailway(int railway) {
        this.railway = railway;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public boolean isByWishes() {
        return byWishes;
    }

    public void setByWishes(boolean byWishes) {
        this.byWishes = byWishes;
    }

    public boolean isHasBedding() {
        return hasBedding;
    }

    public void setHasBedding(boolean hasBedding) {
        this.hasBedding = hasBedding;
    }

    public boolean isObligatoryBedding() {
        return obligatoryBedding;
    }

    public void setObligatoryBedding(boolean obligatoryBedding) {
        this.obligatoryBedding = obligatoryBedding;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public Map<String, Integer> getPrices() {
        return prices;
    }

    public void setPrices(Map<String, Integer> prices) {
        this.prices = prices;
    }

    public int getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(int reservePrice) {
        this.reservePrice = reservePrice;
    }

    public boolean isAllowBonus() {
        return allowBonus;
    }

    public void setAllowBonus(boolean allowBonus) {
        this.allowBonus = allowBonus;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }
}
