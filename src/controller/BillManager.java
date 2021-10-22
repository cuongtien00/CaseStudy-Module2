package controller;

import model.Bill;
import storage.BillFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BillManager {
    private static  BillManager billManager ;
    private List<Bill> billList = new ArrayList<>();
    private static BillFile billFile = BillFile.getInstance();
    private CustomerManager customerManager = CustomerManager.getInstance();
    private MilkTeaManager milkTeaManager = MilkTeaManager.getInstance();
    private ToppingManager toppingManager = ToppingManager.getInstance();

    private BillManager() {
    }
    public static BillManager getInstance(){
        if(billManager ==null){
            billManager = new BillManager();
        }
        return billManager;
    }

    public BillManager(List<Bill> billList) {
        this.billList = billList;
    }

    public List<Bill> getBillList() {
        return billList;
    }
    public void addNewBill(Bill bill) throws IOException {
        billList.add(bill);
        billFile.fileWriter(billList);
    }
    public int findByCode(String code){
        for (Bill a : billList) {
            if(a.getCode().equalsIgnoreCase(code)){
                return billList.indexOf(a);
            }
        }
        return -1;
    }
    public void editBill(String code, Bill bill) throws IOException {
        int index = findByCode(code);
        billList.set(index, bill);
        billFile.fileWriter(billList);
    }
    public void removeBill(String code) throws IOException {
        int index = findByCode(code);
        billList.remove(index);
        billFile.fileWriter(billList);
    }


    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }
    public void showList(){
        System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――DANH SÁCH HÓA ĐƠN――――――――――――――――――――――――――――――――――――――――――――――――");
        for (Bill a: billList) {
            System.out.println("                                          "+a);
        }
        System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――～⊝～⊝～⊝～―――――――――――――――――――――――――――――――――――――――――――――――――――");

    }

}
