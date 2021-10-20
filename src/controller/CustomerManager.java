package controller;

import model.Customer;
import storage.CustomerFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private static CustomerManager customerManager;
    private List<Customer> customerList = new ArrayList<>();
    private CustomerFile customerFile = CustomerFile.getInstance();

    private CustomerManager() {
    }
    public static CustomerManager getInstance(){
        if(customerManager==null){
            customerManager = new CustomerManager();
        }
        return customerManager;
    }
    public int findByName(String name){
        for (Customer a:customerList) {
            if(a.getName().equalsIgnoreCase(name)){
              return customerList.indexOf(a);
            }
        }
        return -1;
    }

    public static CustomerManager getCustomerManager() {
        return customerManager;
    }

    public static void setCustomerManager(CustomerManager customerManager) {
        CustomerManager.customerManager = customerManager;
    }

    public CustomerFile getCustomerReaderWriterFile() {
        return customerFile;
    }

    public CustomerManager(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public CustomerManager(CustomerFile customerFile) {
        this.customerFile = customerFile;
    }

    public void setCustomerReaderWriterFile(CustomerFile customerFile) {
        this.customerFile = customerFile;
    }

    public void addNewC(Customer customer) throws IOException {
        customerList.add(customer);
        customerFile.fileWriter(customerList);
    }
    public void removeC(String name) throws IOException {
        int index = findByName(name);
        customerList.remove(index);
        customerFile.fileWriter(customerList);
    }
    public void editC(String name, Customer customer) throws IOException {
        int index = findByName(name);
        customerList.set(index,customer);
        customerFile.fileWriter(customerList);
    }
    public Customer searchC(String name){
        for (Customer a :customerList
             ) {
            if(a.getName().equalsIgnoreCase(name)){
                return a;
            }
        }
        return null;
    }
    public void showList(){
        System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――DANH SÁCH KHÁCH HÀNG――――――――――――――――――――――――――――――――――――――――――――――――");
        for (Customer a:customerList) {
            System.out.println("                                                                 "+a);
        }
        System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――～⊝～⊝～⊝～―――――――――――――――――――――――――――――――――――――――――――――――――――");

    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
