package model;

import java.io.Serializable;
import java.util.List;

public class Bill implements Serializable {

    private String code;
    private Customer customer;
    private String date;
    private List<MilkTea> milkTeaList;


    public Bill() {
    }

    public Bill(String code, Customer customer, String date) {
        this.code = code;
        this.customer = customer;
        this.date = date;
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


    @Override
    public String toString() {
        return "Bill{" +
                "code='" + code + '\'' +
                ", customer=" + customer +
                ", date='" + date + '\'' +
                '}';
    }
}
