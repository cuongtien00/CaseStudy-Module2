package model;

import java.io.Serializable;

public class MilkTea implements Serializable {
    private String code;
    private String name;
    private double price;
    private String size;
    private int quantity;
    private String sugar;
    private String ice;
    private Topping topping;
//    private int count;

//    public int getCount() {
//        return count;
//    }

//    public void setCount(int count) {
//        this.count = count;
//    }

    public MilkTea() {
    }

    public MilkTea(String code,String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public MilkTea(String code, String name, double price, String size, int quantity, String sugar, String ice, Topping topping) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.size = size;
        this.quantity = quantity;
        this.sugar = sugar;
        this.ice = ice;
        this.topping = topping;
//        this.count = 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    @Override
    public String toString() {
        return name +", code: " + code + ", giá: "+price+", Size: " + size +  ", Số lượng: " + quantity + ", Đường: " + sugar +"%" + ", Đá: " + ice + "%" +", "+ ", topping: "+topping;


    }
}
