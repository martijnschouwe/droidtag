package org.droidtag.game;


/**
 * @author mschouwe
 *         Enum with guntypes configuration will hold gun features like nr of clips, firerate etc, specsource : wikipedia
 */
public enum GunType {

    XM8(1, "Heckler and Koch", 3.4f, 838, 750);

    int id;
    String manufacturer;
    float weight;
    int length;
    int roundPerMinute;

    private GunType(int id, String manufacturer, float weight, int length, int rpm) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.weight = weight;
        this.length = length;
        this.roundPerMinute = rpm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getRoundPerMinute() {
        return roundPerMinute;
    }

    public void setRoundPerMinute(int roundPerMinute) {
        this.roundPerMinute = roundPerMinute;
    }
}
