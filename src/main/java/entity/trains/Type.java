package entity.trains;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Type {
    private String id;
    private String title;
    private String letter;
    private int places;

    public Type() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }
}
