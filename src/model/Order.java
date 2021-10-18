package model;

public class Order {
    private String code;
    private MilkTea milkTea;
    private Topping topping;
    private Customer customer;

    public Order() {
    }

    public Order(String code, MilkTea milkTea, Topping topping, Customer customer) {
        this.code = code;
        this.milkTea = milkTea;
        this.topping = topping;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "code='" + code + '\'' +
                ", milkTea=" + milkTea +
                ", topping=" + topping +
                ", customer=" + customer +
                '}';
    }
}
