package controller;

import model.Customer;
import storage.CustomerReaderWriterFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private static CustomerManager customerManager;
    private List<Customer> customerList = new ArrayList<>();
    private CustomerReaderWriterFile customerReaderWriterFile;

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

    public CustomerReaderWriterFile getCustomerReaderWriterFile() {
        return customerReaderWriterFile;
    }

    public CustomerManager(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public CustomerManager(CustomerReaderWriterFile customerReaderWriterFile) {
        this.customerReaderWriterFile= customerReaderWriterFile;
    }

    public void setCustomerReaderWriterFile(CustomerReaderWriterFile customerReaderWriterFile) {
        this.customerReaderWriterFile = customerReaderWriterFile;
    }

    public void addNewC(Customer customer) {
        customerList.add(customer);
//        customerReaderWriterFile.fileWriter(customerList);
    }
    public void removeC(String name) {
        int index = findByName(name);
        customerList.remove(index);
//        customerReaderWriterFile.fileWriter(customerList);
    }
    public void editC(String name, Customer customer) {
        int index = findByName(name);
        customerList.set(index,customer);
//        customerReaderWriterFile.fileWriter(customerList);
    }
    public void showList(){
        for (Customer a:customerList) {
            System.out.println(a);
        }
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
