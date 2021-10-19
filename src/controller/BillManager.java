package controller;

import model.Bill;
import storage.BillReaderWriterFile;

import java.io.IOException;
import java.util.List;

public class BillManager {
    private List<Bill> billList;
    private BillReaderWriterFile billReaderWriterFile;

    public BillManager() {
    }

    public BillManager(List<Bill> billList) {
        this.billList = billList;
    }

    public List<Bill> getBillList() {
        return billList;
    }
    public void addNewBill(Bill bill) throws IOException {
        billList.add(bill);
        billReaderWriterFile.fileWriter(billList);
    }
    public void editBill(int index, Bill bill) throws IOException {
        billList.set(index, bill);
        billReaderWriterFile.fileWriter(billList);
    }
    public void removeBill(Bill bill) throws IOException {
        billList.remove(bill);
        billReaderWriterFile.fileWriter(billList);
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }
    public void showList(){
        for (Bill a: billList) {
            System.out.println(a);
        }
    }

}
