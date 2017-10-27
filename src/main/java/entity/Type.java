package entity;

public class Type {
    private String id;
    private String title;
    private String letter;
    private int places;

    public Type(String id, String title, String letter, int places) {
        this.id = id;
        this.title = title;
        this.letter = letter;
        this.places = places;
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

    @Override
    public String toString() {
        return "Type{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", letter='" + letter + '\'' +
                ", places=" + places +
                '}';
    }
}
