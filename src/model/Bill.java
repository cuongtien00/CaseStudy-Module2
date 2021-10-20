package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bill implements Serializable {

    private String code;
    private Customer customer;
    private String date;
    private List<MilkTea> milkTeaList = new ArrayList<>();

    public List<MilkTea> getMilkTeaList() {
        return milkTeaList;
    }
public void addNewMilkTea(MilkTea milkTea){
        milkTeaList.add(milkTea);
}
    public void setMilkTeaList(List<MilkTea> milkTeaList) {
        this.milkTeaList = milkTeaList;
    }

    public Bill(String codeBill, Customer customer) {
    }

    public Bill(String code, Customer customer, String date) {
        this.code = code;
        this.customer = customer;
        this.date = date;
    }
public void showListMilkTea(){
    for (MilkTea a :milkTeaList) {
        System.out.println(a);
    }
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
        return "＝＝＝＝＝＝Bill＝＝＝＝＝＝" +"\n"+
                "Ngày: " + date + '\n' +
                "Mã Bill: " + code + '\n' +
                  customer +"\n"+
                "Giỏ hàng: " + milkTeaList
                ;
    }
}
