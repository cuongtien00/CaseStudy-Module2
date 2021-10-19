package controller;

import model.Bill;
import storage.BillReaderWriterFile;

import java.io.IOException;
import java.util.List;

public class OrderManager {
    private List<Bill> billList;
    private BillReaderWriterFile billReaderWriterFile;

    public OrderManager() {
    }

    public OrderManager(List<Bill> billList) {
        this.billList = billList;
    }

    public List<Bill> getOrderList() {
        return billList;
    }
    public void addNewOrder(Bill bill) throws IOException {
        billList.add(bill);
        billReaderWriterFile.fileWriter(billList);
    }
    public void editOrder(int index, Bill bill) throws IOException {
        billList.set(index, bill);
        billReaderWriterFile.fileWriter(billList);
    }
    public void removeOrder(Bill bill) throws IOException {
        billList.remove(bill);
        billReaderWriterFile.fileWriter(billList);
    }

    public void setOrderList(List<Bill> billList) {
        this.billList = billList;
    }
    public void showList(){
        for (Bill a: billList) {
            System.out.println(a);
        }
    }

}
