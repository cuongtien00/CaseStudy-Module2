package model;

public class MilkTea {
    private String name;
    private String size;
    private String sugarPercent;
    private String icePercent;
    private double price;

    public MilkTea() {
    }

    public MilkTea(String name, String size, String sugarPercent, String icePercent) {
        this.name = name;
        this.size = size;
        this.sugarPercent = sugarPercent;
        this.icePercent = icePercent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSugarPercent() {
        return sugarPercent;
    }

    public void setSugarPercent(String sugarPercent) {
        this.sugarPercent = sugarPercent;
    }

    public String getIcePercent() {
        return icePercent;
    }

    public void setIcePercent(String icePercent) {
        this.icePercent = icePercent;
    }

    @Override
    public String toString() {
        return "MilkTea{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", sugarPercent='" + sugarPercent + '\'' +
                ", icePercent='" + icePercent + '\'' +
                ", price=" + price +
                '}';
    }
}
