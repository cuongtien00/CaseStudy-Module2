package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bill implements Serializable {
    private LocalDate time;
    private String code;
    private Customer customer;
    private String date;
    private List<MilkTea> milkTeaList = new ArrayList<>();
    private double totalPrice;

    public List<MilkTea> getMilkTeaList() {
        return milkTeaList;
    }

    public Bill() {
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
    public double getTotalPrice(){
        for (MilkTea a:milkTeaList) {
            if(a.getSize().equalsIgnoreCase("M")){
                totalPrice += a.getQuantity()*a.getPrice()+a.getTopping().getPrice();
            }
            if(a.getSize().equalsIgnoreCase("L")){
                totalPrice += a.getQuantity()*a.getPrice()+a.getQuantity()*10000+a.getTopping().getPrice();
            }
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return  "\n"+
                "                                                                             DING TEA VIET NAM" +"\n"+
                "                                                                         245 BEN OANH, THAI NGUYEN"+"\n"+
                "                                                                             Tel: 03 5577 0616"+"\n"+
                "                                                                     Ngày:"+ LocalDate.now()+ '\n' +
                "                                                                     "+customer +"\n"+
                "                                                                                   Giỏ hàng: " +"\n"+
                milkTeaList+"\n"+
                "                                                                     Grand Total                    "+getTotalPrice()+"\n"+
                "                                                                               www.dingtea.vn"+"\n"+
                "                                                                         Pass Wifi: Conlaumoinoinha"
                ;
    }
}
