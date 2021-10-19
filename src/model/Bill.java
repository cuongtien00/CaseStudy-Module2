package model;

import java.io.Serializable;

public class Bill implements Serializable {

    private String code;
    private Customer customer;
    private String date;
    private Order order;


    public Bill() {
    }

    public Bill(String code, Customer customer, String date, Order order) {
        this.code = code;
        this.customer = customer;
        this.date = date;
        this.order = order;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getTotalPrice(){
       return order.getTotalPrice();
    }


    @Override
    public String toString() {
        return "Bill{" +
                "code='" + code + '\'' +
                ", customer=" + customer +
                ", date='" + date + '\'' +
                ", order=" + order +
                '}';
    }
}
