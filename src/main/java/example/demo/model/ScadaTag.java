package example.demo.model;

import javax.persistence.*;

@Entity
public class ScadaTag {
    @Id
    private String name;
    private int value;
    private boolean quality;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isQuality() {
        return quality;
    }

    public void setQuality(boolean quality) {
        this.quality = quality;
    }
}
