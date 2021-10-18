package controller;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customerList;

    public CustomerManager() {
        customerList = new ArrayList<>();
    }
    public void inputInfo(){

    }
    public void showList(){
        for (Customer a:customerList) {
            System.out.println(a);
        }
    }
}
