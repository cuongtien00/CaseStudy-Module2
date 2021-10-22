package controller;

import model.Customer;
import storage.CustomerFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private static CustomerManager customerManager;
    private List<Customer> customerList = new ArrayList<>();
    private  static CustomerFile customerFile = CustomerFile.getInstance();

    private CustomerManager() {
    }
    public static CustomerManager getInstance(){
        if(customerManager==null){
            customerManager = new CustomerManager();
        }
        return customerManager;
    }
    public int findById(String id){
        for (Customer a:customerList) {
            if(a.getId().equalsIgnoreCase(id)){
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
    public void removeC(String id) throws IOException {
        int index = findById(id);
        customerList.remove(index);
        customerFile.fileWriter(customerList);
    }
    public void editC(String id, Customer customer) throws IOException {
        int index = findById(id);
        customerList.set(index,customer);
        customerFile.fileWriter(customerList);
    }
    public Customer searchC(String id){
        for (Customer a :customerList
             ) {
            if(a.getId().equalsIgnoreCase(id)){
                return a;
            }
        }
        return null;
    }
    public boolean checkId(String id){
        boolean check = false;
        for (Customer a:customerList ){
            if(a.getId().equalsIgnoreCase(id)){
                check = true;
            }
        }
        return check;
    }
    public void showList(){
        System.out.println("―――――――――――――――――――――――――――――――――――――――――――――――――――レシート――――――――――――――――――――――――――――――――――――――――――――――――――――");
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
