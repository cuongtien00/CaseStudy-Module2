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
    private static BillView billView;

    private BillView() {
    }

    public static BillView getInstance() {
        if (billView == null) {
            billView = new BillView();
        }
        return billView;
    }

    private static CustomerManager customerManager = CustomerManager.getInstance();
    private static MilkTeaManager milkTeaManager = MilkTeaManager.getInstance();
    private static ToppingManager toppingManager = ToppingManager.getInstance();
    private static BillManager billManager = BillManager.getInstance();


    public void runBillView() {
        Scanner scanner = new Scanner(System.in);
        try {
            billManager.setBillList(BillFile.getInstance().fileReader());
            milkTeaManager.setMilkTeaList(MilkTeaFile.getInstance().fileReader());
            customerManager.setCustomerList(CustomerFile.getInstance().fileReader());
            toppingManager.setToppings(ToppingFile.getInstance().fileReader());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        int choice = -1;
        while (choice != 0) {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    try {
                        billManager.addNewBill(newBill());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        billManager.editBill(inputCode(), newBill());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        billManager.removeBill(inputCode());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    billManager.showList();
                    break;
                case 0:
            }
        }
    }

    public static String inputName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten:");
        return scanner.nextLine();
    }

    private static String inputCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap id: ");
        return scanner.nextLine();

    }

    public static void showMenu() {
        System.out.println("===========BILL-LIST-MANAGER=============");
        System.out.println("1. Xuất Bill: ");
        System.out.println("2. Sửa Bill: ");
        System.out.println("3. Xóa Bill: ");
        System.out.println("4. Hiển thị list Bills: ");
        System.out.println("0. Exit: ");
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

