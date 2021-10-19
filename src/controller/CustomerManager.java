package controller;

import model.Customer;
import storage.CustomerReaderWriterFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customerList;
    private CustomerReaderWriterFile customerReaderWriterFile;

    public CustomerManager() {
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

    public void addNewC(Customer customer) throws IOException {
        customerList.add(customer);
        customerReaderWriterFile.fileWriter(customerList);
    }
    public void removeC(int index) throws IOException {
        customerList.remove(index);
        customerReaderWriterFile.fileWriter(customerList);
    }
    public void editC(int index, Customer customer) throws IOException {
        customerList.set(index,customer);
        customerReaderWriterFile.fileWriter(customerList);
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
