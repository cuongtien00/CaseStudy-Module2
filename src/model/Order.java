package model;

import java.util.List;

public class Order {
    private String type;
    private String size;
    private int quantity;
    private String sugarPercent;
    private String icePercent;
    private String topping;
    private  List<Topping> toppings;
    private List<MilkTea>milkTeas;

    public Order() {
    }

    public List<MilkTea> getMilkTeas() {
        return milkTeas;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public void setMilkTeas(List<MilkTea> milkTeas) {
        this.milkTeas = milkTeas;
    }

    public Order(String type, String size, int quantity, String sugarPercent, String icePercent,String topping) {
        this.type = type;
        this.size = size;
        this.quantity = quantity;
        this.sugarPercent = sugarPercent;
        this.icePercent = icePercent;
        this.topping = topping;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
    public double getTotalPrice(){
        double price = 0;
        for (MilkTea a: milkTeas ){
            if(a.getName().equalsIgnoreCase(type)){
                price = a.getPrice() * quantity;
            }
        }
        for (Topping a: toppings) {
            if(a.getName().equalsIgnoreCase(topping)){
                price += a.getPrice();
            }
        }
        return price;
    }
}
