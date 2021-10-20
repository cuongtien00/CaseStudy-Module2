package views;

import controller.BillManager;
import controller.CustomerManager;
import controller.MilkTeaManager;
import controller.ToppingManager;
import model.*;
import storage.BillFile;
import storage.CustomerFile;
import storage.MilkTeaFile;
import storage.ToppingFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillView {
    private static CustomerManager customerManager = CustomerManager.getInstance();
    private static MilkTeaManager milkTeaManager = MilkTeaManager.getInstance();
    private static ToppingManager toppingManager = ToppingManager.getInstance();
    private static BillManager billManager = BillManager.getInstance();


    public void runBillView() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
//                    Customer customer = customerManager.searchC(inputName());
//                    if (customer != null) {
//                        Scanner input = new Scanner(System.in);
//                        System.out.println("Nhap code bill");
//                        String codeBill = input.nextLine(); //code bill
//                        Bill bill = new Bill(codeBill, customer);
//                        billManager.addNewBill(bill);
//                        billManager.showList();
//                        break;
//                    Customer customer = customerManager.searchC(inputName());
//                    if(customer != null){
//                        Scanner input = new Scanner(System.in);
//                        System.out.println("Nhap code bill");
//                        String codeBill = input.nextLine(); //code bill
//                        billManager.addNewBill(new Bill(codeBill,customer));
//                        milkTeaManager.showList();
//                        System.out.println("Nhap code ");
//                        String code = scanner.nextLine();
//                        for (MilkTea a:milkTeaManager.getMilkTeaList()) {
//                            if(a.getCode().equalsIgnoreCase(code)){
//                                billManager.
//                            }
//                        }
//
//                    } else {
//                        System.out.println("Khong tim thay khach hang");
//                    }

//                    }
            }
        }
    }

    public static void main(String[] args) {

        try {
            customerManager.setCustomerList(CustomerFile.getInstance().fileReader());
            milkTeaManager.setMilkTeaList(MilkTeaFile.getInstance().fileReader());
            toppingManager.setToppings(ToppingFile.getInstance().fileReader());
            billManager.setBillList(BillFile.getInstance().fileReader());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        buyMilkTea();
    }

    private static void dingTeaMenu() {
        System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　　    　＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　  　＝＝＝＝＝。DINGTEA　募茶。＝＝＝＝＝");
        System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　　    　＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
        System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　。WELCOME。　　　　　　　");
        milkTeaManager.showList();
        toppingManager.showList();
    }

    private static void buyMilkTea() {
        dingTeaMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moi ban chon code tra sua");
        String code = scanner.nextLine();
        MilkTea milkTea = new MilkTea();
        for (MilkTea a : milkTeaManager.getMilkTeaList()) {
            if (a.getCode().equalsIgnoreCase(code)) {
                milkTea = a;
            }
        }
        Scanner input2 = new Scanner(System.in);
        System.out.println("Moi chon size ");
        String size = input2.nextLine();
        Scanner input3 = new Scanner(System.in);
        System.out.println("chon so luong");
        int quantity = input3.nextInt();
        Scanner input4 = new Scanner(System.in);
        System.out.println("Chon % duong ");
        String sugar = input4.nextLine();
        Scanner input5 = new Scanner(System.in);
        System.out.println("Chon da");
        String ice = input5.nextLine();
        Scanner input6 = new Scanner(System.in);
        System.out.println("chon id cua topping");
        String id = input6.nextLine();
        Topping topping = new Topping();
        for (Topping a : toppingManager.getToppings()) {
            if (a.getId().equalsIgnoreCase(id)) {
                topping = a;
            }
        }
        milkTea.setSize(size);
        milkTea.setQuantity(quantity);
        milkTea.setSugar(sugar);
        milkTea.setIce(ice);
        milkTea.setTopping(topping);
        Scanner scanner1 = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.println("Moi nhap ten khach hang");
        String name = scanner1.nextLine();
        for (Customer a : customerManager.getCustomerList()
        ) {
            if (a.getName().equalsIgnoreCase(name)) {
                customer = a;
            }
        }
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Nhap code bill");
        String codeBill = scanner2.nextLine();
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Nhap ngay ");
        String date = scanner3.nextLine();


        Bill billOfCuong = new Bill(codeBill, customer, date);
        billOfCuong.addNewMilkTea(milkTea);
        System.out.println(billOfCuong);
    }

    public static String inputName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten:");
        return scanner.nextLine();
    }

    public static void showMenu() {
        System.out.println("===========BILL-LIST-MANAGER=============");
        System.out.println("1. Xuất Bill: ");
        System.out.println("2. Sửa Bill: ");
        System.out.println("3. Xóa Bill: ");
        System.out.println("4. Hiển thị list Bills: ");
        System.out.println("6. Exit: ");
        System.out.println("Nhập lựa chọn: ");
    }

    private static Bill newBill() {
        Scanner input1 = new Scanner(System.in);
        System.out.println("Nhập billCode: ");
        String code = input1.nextLine();
        Scanner input2 = new Scanner(System.in);
        System.out.println("Nhập ngày xuất Bill: ");
        String date = input2.nextLine();
        Customer customer = newCustomer();
//        MilkTea milkTea = newMilkTea();
        return new Bill(code, customer, date);

    }

    private static MilkTea newMilkTea() {
        Scanner input = new Scanner(System.in);
        System.out.println("Moi nhap code: ");
        String code = input.nextLine();
        System.out.println("Mời nhập loại trà sữa: ");
        String name = input.nextLine();
        Scanner input2 = new Scanner(System.in);
        System.out.println("Moi nhap gia");
        double price = input2.nextDouble();
        return new MilkTea(code, name, price);
    }

    private static Customer newCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên khách hàng");
        String name = input.nextLine();
        System.out.println("Nhập địa chỉ");
        String add = input.nextLine();
        Customer customer = new Customer(name, add);
        return customer;
    }


    private static Topping newTopping() {
        Scanner input2 = new Scanner(System.in);
        System.out.println("Nhập code: ");
        String code = input2.nextLine();
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập tên topping: ");
        String name = input.nextLine();
        Scanner input1 = new Scanner(System.in);
        System.out.println("Nhập giá: ");
        double price = input1.nextDouble();
        Topping topping = new Topping(code, name, price);
        return topping;
    }
}

